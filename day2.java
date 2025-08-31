//Day of the Year
import java.time.LocalDate;
class Solution {
    public static int dayOfYear(String date) {
        LocalDate localDate=LocalDate.parse(date);
        return localDate.getDayOfYear();
        

    }
    public static void main(String args[])
    {
        System.out.println(dayOfYear("2019-01-09"));
    }
}
