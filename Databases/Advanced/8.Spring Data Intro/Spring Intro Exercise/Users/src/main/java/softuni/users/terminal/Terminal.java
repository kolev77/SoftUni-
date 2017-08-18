package softuni.users.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.users.dto.UserDto;
import softuni.users.entities.Album;
import softuni.users.entities.Picture;
import softuni.users.entities.Town;
import softuni.users.entities.User;
import softuni.users.services.TownService;
import softuni.users.services.UserService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner{

    private final UserService userService;
    private final TownService townService;
    @Autowired
    public Terminal(UserService userService, TownService townService) {
        this.userService = userService;
        this.townService = townService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        User gosho = new User();
//        gosho.setUsername("Gosho");
//        gosho.setEmail("gsho@gmail.com");
//        gosho.setPassword("123uU?!?");
//        gosho.setFirstName("Smeshniqt");
//        gosho.setLastName("Smeshen");
//
//        User pesho = new User();
//        pesho.setUsername("Pesho");
//        pesho.setEmail("Pesho@gmail.com");
//        pesho.setPassword("123uU?!?");
//        pesho.setFirstName("Pesho");
//        pesho.setLastName("Peshoviq");
//
//        User zdravko = new User();
//        zdravko.setUsername("zdravko");
//        zdravko.setEmail("zdravko@gmail.com");
//        zdravko.setFirstName("zdravko");
//        zdravko.setLastName("Peshoviq");
//        zdravko.setPassword("123uU?!?");
//
//        Set<User> friends = new HashSet<>();
//        friends.add(gosho);
//        friends.add(pesho);
//        Picture picture1 = new Picture();
//        Picture picture2 = new Picture();
//
//        Album album = new Album();
//        album.setOwner(zdravko);
//
//        Set<Picture> pictures = new HashSet<>();
//        pictures.add(picture1);
//        pictures.add(picture2);
//
//        Set<Album> albums = new HashSet<>();
//        albums.add(album);
//        album.setPictures(pictures);
//        zdravko.setAlbums(albums);
//
//        zdravko.setFriends(friends);
//        userService.persist(zdravko);



//         Problem 16.	Get Users by Email Provider
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String emailProvider = br.readLine();
        List<Object[]> usernamesByEmailProvider = this.userService.findUsersByEmailProvider(emailProvider);
        if (usernamesByEmailProvider.isEmpty()) {
            System.out.println("No users found with email domain " + emailProvider);
        } else {
            usernamesByEmailProvider.forEach(u -> {
                System.out.println(u[0] + " " + u[1]);
            });
        }
    }
}
