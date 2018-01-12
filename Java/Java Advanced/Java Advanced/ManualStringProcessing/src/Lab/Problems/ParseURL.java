package Lab.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("://");
        if (input.length!=2){
            System.out.println("Invalid URL");
        }else {
            String protocol = input[0];
            String[] reminder = input[1].split("/");
            String server = reminder[0];
            int index =  server.length()+1;
            String resource = input[1].substring(index);
            System.out.println(String.format("Protocol = %s", protocol));
            System.out.println(String.format("Server = %s", server));
            System.out.println(String.format("Resources = %s", resource));
        }
    }
}
