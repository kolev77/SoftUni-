package javache;

import javache.http.*;
import javache.io.Reader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

public class RequestHandler {
    private final String DB_PATH = System.getProperty("user.dir")
            + "\\src\\resources\\db\\users.txt";
    private HttpRequest httpRequest;

    private HttpResponse httpResponse;

    private HttpSession session;

    private static final String SERVER_SESSION_KEY = "JAVACHE_SESSION_ID";

    public RequestHandler(HttpSession session) {
        this.session = session;
    }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();

        HashMap<String, String> bodyParameters = this.httpRequest.getBodyParameters();
        String url = this.httpRequest.getRequestUrl();
        String resourcesFolder = System.getProperty("user.dir") + "\\src\\resources\\";
        String assetsFolder = resourcesFolder + "assets";
        String filePath = assetsFolder + url;
        switch (url) {
            case "/":
                try {
                    byte[] fileContents = Files.readAllBytes(Paths.get(assetsFolder + "\\html\\index.html"));
                    return this.Ok(fileContents);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case "/users/register":
                String email = bodyParameters.get("email");
                String password = bodyParameters.get("password");
                String confirm = bodyParameters.get("confirm");

                if (!password.equals(confirm)) {
                    return this.BadRequest("Passwords mismatch.".getBytes());
                }

                try {
                    User user = this.findUserDataByEmail(email);
                    if (user != null) {
                        return this.BadRequest("User already exists.".getBytes());
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(DB_PATH, true))) {
                        writer.write(UUID.randomUUID().toString() + "|" + email + "|" + password + System.lineSeparator());
                    }
                    this.httpResponse.addHeader("Location", "/html/login.html");
                    return this.Redirect(new byte[0]);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return this.Ok("<p>I am register</p>".getBytes());
            case "/users/login":
                String loginEmail = bodyParameters.get("email");
                String loginPassword = bodyParameters.get("password");

                try {
                    User user = this.findUserDataByEmail(loginEmail);
                    if (user == null) {
                        return this.BadRequest(new byte[0]);
                    }
                    if (!user.getPassword().equals(loginPassword)) {
                        return this.BadRequest("Password was incorrect ! ".getBytes());
                    }
                    String sessionId = UUID.randomUUID().toString();

                    this.session.setSessionData(
                            sessionId,
                            new HashMap<String, Object>() {{
                                put("userId", user.getId());
                            }}
                    );


                    this.httpResponse.addCookie(SERVER_SESSION_KEY, sessionId);
                    this.httpResponse.addHeader("Location", "/users/profile");
                    return this.Redirect(new byte[0]);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return this.Ok("<p>I am login</p>".getBytes());
            case "/users/profile":
                byte[] guestContents = null;
                try {
                    guestContents = Files.readAllBytes(Paths.get(resourcesFolder + "pages\\profile\\guest.html"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!this.httpRequest.getCookies().containsKey(SERVER_SESSION_KEY)) {
                    return this.Ok(guestContents);

                } else {
                    String sessionId = this.httpRequest.getCookies().get(SERVER_SESSION_KEY);
                    String userId = (String) this.session.getSessionData(sessionId)
                            .get("userId");
                    try {
                        User user = findUserDataById(userId);
                        if (user == null) {
                            return this.Ok(guestContents);
                        }

                        String loggedContents = Reader.readAllLines(new FileInputStream(resourcesFolder + "pages\\profile\\logged.html"));
                        String loggedResponse = String.format(loggedContents, user.getName(), user.getPassword());

                        return this.Ok(loggedResponse.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

                return this.Ok("<p>I am profile</p>".getBytes());
            default:
                File file = new File(filePath);
                if (!file.exists() || file.isDirectory()) {
                    return this.NotFound(new byte[0]);
                }
                try {
                    if (!file.getCanonicalPath().startsWith(assetsFolder)) {
                        return this.BadRequest(new byte[0]);
                    }
                    byte[] fileContent = Files.readAllBytes(Paths.get(filePath));


                    return this.Ok(fileContent);
                } catch (IOException e) {
                    return this.NotFound(new byte[0]);
                }
        }

    }

    private byte[] Ok(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.Ok);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] BadRequest(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.BadRequest);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] NotFound(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.NotFound);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] Redirect(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.SeeOther);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] InternalServerError(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.InternalServerError);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private User find(String search, int index) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(DB_PATH))) {
            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split("\\|");
                if (userData[index].equals(search)) {
                    User user = new User(userData[0], userData[1], userData[2]);
                    return user;
                }
                line = reader.readLine();
            }
        }
        return null;
    }

    private User findUserDataByEmail(String email) throws IOException {
        return this.find(email, 1);
    }


    private User findUserDataById(String id) throws IOException {
        return this.find(id, 0);
    }

    class User {
        private String id;
        private String name;
        private String password;

        public User(String id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
