//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1-Java / 05-if
        int currentAge = 19;
        if (currentAge > 18) {
            System.out.println("currentAge > 18");
        }

        String currentName = "TimMacraesie";
        if (currentName.length() > 10) {
            System.out.println("currentName > 10");
        }

        // Bonus
        int oddOrEven = 23;
        if (oddOrEven % 2 == 0) {
            System.out.println("isEven");
        } else {
            System.out.println("isOdd");
        }


        int grade = 93;

        if (grade <= 100 && grade >= 90) {
            System.out.println("Note A");
        } else if (grade < 90 && grade >= 70) {
            System.out.println("Note B");
        } else if (grade < 70 && grade >= 50) {
            System.out.println("Note C");
        } else if (grade < 50 && grade >= 20) {
            System.out.println("Note D");
        } else {
            System.out.println("Note F");
        }

        int negativeOrPositive = -20;
        if (negativeOrPositive < 0) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }

    }
}