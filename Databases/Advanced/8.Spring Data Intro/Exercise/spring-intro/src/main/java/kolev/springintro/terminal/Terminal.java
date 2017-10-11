package kolev.springintro.terminal;

import kolev.springintro.entities.Town;
import kolev.springintro.entities.User;
import kolev.springintro.services.TownService;
import kolev.springintro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner {
    private final UserService userService;
    private TownService townService;
    @Autowired
    public Terminal(UserService userService, TownService townService) {
        this.userService = userService;
        this.townService = townService;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("Vankata");
        user.setPassword("paS123");
        user.setEmail("gosho@gmail.com");
        user.setAge(33);
        Town town = new Town("Varna");
        Town town2 = new Town("Sofia");
        user.setBornTown(town);
        user.setCurrentTown(town2);
        townService.persist(town);
        townService.persist(town2);


        System.out.println("YEAh");
    }
}
