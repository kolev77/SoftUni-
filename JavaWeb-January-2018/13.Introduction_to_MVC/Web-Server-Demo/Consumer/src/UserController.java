import org.softuni.summerframework.stereotype.Controller;
import org.softuni.summerframework.stereotype.GetMapping;
import org.softuni.summerframework.stereotype.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/login")
    public String login() {
        return "<h1>LOGIN HERE</h1>";
    }

    @GetMapping("/users/register")
    public String register() {
        return "<h1>REGISTER HERE</h1>";
    }

    @PostMapping("/users/register")
    public String registerPost() {
        return "<h1>REGISTER POST HERE</h1>";
    }


    public String fake() {
        return "asdasdas";
    }

}
