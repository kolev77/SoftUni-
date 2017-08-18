package Exercises;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CountWorkingDays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String input2 = br.readLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
        LocalDate start = LocalDate.parse(input, formatter);
        LocalDate end = LocalDate.parse(input2, formatter);
        int counter = 0;

        LocalDate[] holidays = new LocalDate[11];
        holidays[0] = LocalDate.parse("01-01-2017", formatter);
        holidays[1] = LocalDate.parse("03-03-2017", formatter);
        holidays[2] = LocalDate.parse("01-05-2017", formatter);
        holidays[3] = LocalDate.parse("06-05-2017", formatter);
        holidays[4] = LocalDate.parse("24-05-2017", formatter);
        holidays[5] = LocalDate.parse("06-09-2017", formatter);
        holidays[6] = LocalDate.parse("22-09-2017", formatter);
        holidays[7] = LocalDate.parse("01-11-2017", formatter);
        holidays[8] = LocalDate.parse("24-12-2017", formatter);
        holidays[9] = LocalDate.parse("25-12-2017", formatter);
        holidays[10] = LocalDate.parse("26-12-2017", formatter);

        for (LocalDate date = start; date.isBefore(end) || date.isEqual(end); date = date.plusDays(1)) {
            String dayOfWeek = date.getDayOfWeek().toString();
            if (!isHoliday(holidays, date) && !dayOfWeek.equals("SATURDAY")&& !dayOfWeek.equals("SUNDAY")){
                counter++;
            }
        }
        System.out.println(counter);
    }
    private static boolean isHoliday(LocalDate[] holidays, LocalDate date) {
        boolean isHoliday = false;

        for (int i = 0; i < holidays.length; i++) {
            if (holidays[i].getMonth().equals(date.getMonth()) && holidays[i].getDayOfMonth() == date.getDayOfMonth()) {
                isHoliday = true;
                break;
            }
        }
        return isHoliday;
    }

}
