import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Rostislav Kolev on 03-Jul-17.
 */
public class URLparser {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] url = br.readLine().split("://");
        String protocol = "";
        String server = "";
        String resource = "";

        if (url.length > 1) {
            protocol = url[0];
            String[] secondPart = url[1].split("/");
            server = secondPart[0];
            if (secondPart.length > 1 && secondPart[1].length() > 0) {
                resource = url[1].substring(url[1].indexOf("/") + 1, url[1].length());
            }
        } else
            server = url[0];

        System.out.println("[protocol] = \"" + protocol + "\"");
        System.out.println("[server] = \"" + server + "\"");
        System.out.println("[resource] = \"" + resource.trim() + "\"");
    }

}
