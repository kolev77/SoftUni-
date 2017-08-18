package Exercises.Telephony;


public class SmartPhone implements Calling, Browsing {

    @Override
    public String call(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return "Invalid number!";
            }
        }
        return callMsg + number;
    }

    @Override
    public String browse(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return "Invalid URL!";
            }
        }
        return browsingMsg + url+"!";
    }
}
