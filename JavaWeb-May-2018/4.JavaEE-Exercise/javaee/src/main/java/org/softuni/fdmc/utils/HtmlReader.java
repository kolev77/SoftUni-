package org.softuni.fdmc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public final class HtmlReader {
    public static String readHtml(String route) {
        StringBuilder contentBuilder = new StringBuilder();
        String s = Paths.get("").toAbsolutePath().toString();
        System.out.println(s);
        try {
            BufferedReader in = new BufferedReader(new FileReader(route + ".html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        return contentBuilder.toString();
    }
}
