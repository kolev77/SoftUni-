package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.annotations.ApplicationRequestHandler;
import org.softuni.main.casebook.annotations.Get;
import org.softuni.main.casebook.annotations.Post;
import org.softuni.main.database.models.User;
import org.softuni.main.database.repositories.UserRepository;
import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;
import org.softuni.main.javache.http.HttpStatus;


@ApplicationRequestHandler
public class UsersHandler extends BaseDynamicHandler {

    protected UsersHandler(HttpSessionStorage sessionStorage) {
        super(sessionStorage);
    }

    @Get(route = "/register")
    public HttpResponse register(HttpRequest request, HttpResponse response) {
        return this.view("register", request, response);
    }

    @Post(route = "/register")
    public HttpResponse registerConfirm(HttpRequest request, HttpResponse response) {
        UserRepository userRepository = new UserRepository();

        String username = request.getBodyParameters().get("username");
        String password = request.getBodyParameters().get("password");

        userRepository.doAction("create", username, password);

        userRepository.dismiss();
        return this.redirect("/",request,response);
    }

    @Get(route = "/login")
    public HttpResponse login(HttpRequest request, HttpResponse response) {
        return this.view("login", request, response);
    }


    @Post(route = "/login")
    public HttpResponse loginConfirm(HttpRequest request, HttpResponse response) {
        UserRepository userRepository = new UserRepository();
        String username = request.getBodyParameters().get("username");
        String password = request.getBodyParameters().get("password");
        User user = (User) userRepository.doAction("findByUsername",username);

        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type","text/html");

        response.setContent(("<h1>" + user.getPassword() +"<h1/>").getBytes()) ;

        return response;
    }
}
