package Exercises.Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] phoneNumbers = br.readLine().split("\\s+");
        String[] webSites = br.readLine().split("\\s+");
        Smartphone smartphone = new Smartphone();

        Arrays.stream(phoneNumbers).forEach(p-> smartphone.addPhoneNumber(p));
        Arrays.stream(webSites).forEach(w->smartphone.addWebsiteUrl(w));

        smartphone.getPhoneNumbers().forEach(phoneNumber-> smartphone.call(phoneNumber));
        smartphone.getWebSites().forEach(url-> smartphone.browse(url));
    }
}
