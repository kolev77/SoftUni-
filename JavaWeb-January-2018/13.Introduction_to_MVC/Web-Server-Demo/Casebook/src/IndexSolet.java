import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.broccolina.solet.WebSolet;
import org.softuni.javache.http.HttpStatus;
import org.softuni.summerframework.GenericSolet;

@WebSolet(route = "/index")
public class IndexSolet extends GenericSolet {
    @Override
    public void doGet(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.OK);

        response.addHeader("Content-Type", "text/html");

        response.setContent(("<h1>Hi, you in index, bro</h1>").getBytes());
    }
}
