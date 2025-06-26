import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
         String[] MONTH = {
                "Januar", "Februar", "März", "April", "Mai", "Juni",
                "Juli", "August", "September", "Oktober", "November", "Dezember"
        };

         int[] DAYS_IN_MONTH = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

         int startDay = 0;

         for (int i = 0; i < MONTH.length; i++) {
             System.out.println(MONTH[i]);
             System.out.println("Mo Di Mi Do Fr Sa So");

             int days = DAYS_IN_MONTH[i];
             String week = "";
             for (int day = 1; day <= days; day++) {
                 if(day < 10){
                     week = week.concat(" ").concat(Integer.toString(day));
                 } else{
                     week = week.concat(" ").concat(String.valueOf(day));
                 }
                 startDay++;

                 if(startDay == 7){
                     System.out.println(week);
                     startDay = 0;
                     week = "";
                 }
             }

         }

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }
}