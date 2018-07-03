package Exercises.Telephony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Smartphone implements BrowseFunction, CallFunction {
    private List<String> phoneNumbers;
    private List<String> webSites;

    Smartphone() {
        this.phoneNumbers = new ArrayList<>();
        this.webSites = new ArrayList<>();
    }

    void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    void addWebsiteUrl(String url) {
        this.webSites.add(url);
    }


    List<String> getPhoneNumbers() {
        return Collections.unmodifiableList(this.phoneNumbers);
    }

    List<String> getWebSites() {
        return Collections.unmodifiableList(this.webSites);
    }

    @Override
    public void call(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                System.out.println("Invalid number!");
                return;
            }
        }
        System.out.printf("Calling... %s\n", phoneNumber);
    }

    @Override
    public void browse(String webSite) {
        for (int i = 0; i < webSite.length(); i++) {
            if (Character.isDigit(webSite.charAt(i))) {
                System.out.println("Invalid URL!");
                return;
            }
        }
        System.out.printf("Browsing: %s!\n", webSite);
    }
}
