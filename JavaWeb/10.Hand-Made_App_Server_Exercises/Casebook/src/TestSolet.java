import org.softuni.broccolina.solet.BaseHttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.broccolina.solet.WebSolet;

@WebSolet(route = "/test")
public class TestSolet extends BaseHttpSolet {
    @Override
    public void doPost(HttpSoletRequest request, HttpSoletResponse response) {
        response.setContent("Hi mate".getBytes());
    }
}
