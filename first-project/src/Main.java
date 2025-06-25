//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Java is cool!");
        System.out.println("I learn Java");

        // 1-Java / 03-Datatypes
        String name = "Tim";
        int age = 30;
        double height = 1.85;
        boolean student = true;


        // 1-Java / 04 Operator
        int num1 = 12;
        int num2 = 40;
        int sum = num1 + num2;
        System.out.println("The sum is " + sum);

        int num3 = 10;
        int num4 = 20;
        int multiply = num3 * num4;
        int plus = num3 + num4;
        int minus = num3 - num4;
        int divided = num4 / num3;

        System.out.println("+ :" + minus);
        System.out.println("* :" + multiply);
        System.out.println("/ :" + divided);
        System.out.println("- :" + plus);

        boolean isBigger = num3 > num4;
        boolean isSmaller = num3 < num4;
        boolean isEqual = num3 == num4;
        System.out.println("isBigger" + isBigger);
        System.out.println("isSmaller" + isSmaller);
        System.out.println("isEqual" + isEqual);

        float floatNumber = 2.5f;
        double doubleNumber = 5.5;

        double doubleMulti = 5.5 * 4.5;
        double doubleDiv = 5.5 / 4.5;
        double doubleAdd = 5.5 + 4.5;
        double doubleSub = 5.5 - 4.5;
        System.out.println("double multi:" + doubleMulti);
        System.out.println("double div:" + doubleDiv);
        System.out.println("doubleAdd:" + doubleAdd);
        System.out.println("doubleSub:" + doubleSub);

        boolean isBiggerFloatOrDouble = floatNumber > doubleMulti;
        boolean isSmallerFloatOrDouble = floatNumber < doubleMulti;
        boolean isEqualFloat = floatNumber == doubleMulti;
        System.out.println("isBiggerFloatOrDouble: " + isBiggerFloatOrDouble);
        System.out.println("isSmallerFloatOrDouble: " + isSmallerFloatOrDouble);
        System.out.println("isEqualFloat: " + isEqualFloat);

        String str1 = "Hello";
        String str2 = "World";

        System.out.println("Hello == World " + str1.equals(str2));

        String A = "A";
        String B = "B";
        System.out.println("A == B " + A.equals(B));

        String a = "a";
        System.out.println("a == B " + a.equals(B));


    }
}