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

        // Bonus if else
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

        // 1-Java / 06.Methods
        sayHello("Tim");

        // Log int num
        add(5, 5);

        // Log double num
        add(5.5, 5.5);

        // Log subtract int
        subtract(10, 5);

        // Return positive num
        makePositive(5);

        // Return converted positive num
        makePositive(-5);

        // Bonus
        addOrSubtract(5, 4);
        addOrSubtract(4, 10);

        doubleOddNumbersOrReturnEven(4);
        doubleOddNumbersOrReturnEven(5);

        isPalindrom("Timmit");
        isPalindrom("Timmitt");

    }

    public static void sayHello(String name){
        System.out.println("Hello "+name);
    }

    public static void add(int num1, int num2){
        int sum = num1 + num2;
        System.out.println("Sum int: "+ sum);
    }

    public static void add(double num1, double num2){
        double sum = num1 + num2;
        System.out.println("Sum double: "+ sum);
    }

    public static void subtract(int num1, int num2){
        int sum = num1 - num2;
        System.out.println("Sum subtract: "+ sum);
    }

    public static int makePositive(int num){
        if(num > 0) {
            System.out.println("Positive num: " + num);
            return num;
        };

        int convertedNum = Math.abs(num);
        System.out.println("Negative converted to positive num: " + convertedNum);
        return convertedNum;
    }

    // Bonus
    public static void addOrSubtract(int num1, int num2){
        if(num1 > num2) {
            subtract(num1, num2);
        }
        add(num1, num2);
    }

    public static int doubleOddNumbersOrReturnEven(int num){
        if(num % 2 != 0) {
            int doubleNumber = num *2;
            System.out.println("Odd doubled number: " + doubleNumber);
            return doubleNumber;
        }
        System.out.println("Even not doubled number: " + num);
        return num;
    }

    public static boolean isPalindrom(String string){
        String convertedString = string.toLowerCase();
        StringBuilder palindrome = new StringBuilder(convertedString);
        palindrome.reverse();

        if(palindrome.toString().equals(convertedString)) {
            System.out.println("Palindrome string");
            return true;
        }

        System.out.println("Not a palindrome string");
        return false;
    }


}