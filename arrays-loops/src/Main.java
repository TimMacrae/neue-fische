import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1-Java / 09-Array
        String[] names = new String[4];
        names[0] = "Florian";
        names[1] = "Martin";
        names[2] = "Dominic";
        names[3] = "Sara";
        System.out.println("Array names: " + Arrays.toString(names));

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] numbersTwo = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        System.out.println("Array numbers: " + Arrays.toString(numbers));

        System.out.println("Calculate all numbers: " + calculateAllNumbers(numbers));
        System.out.println("Find the biggest number: " + findBiggestNumber(numbers));
        System.out.println("Element wise addition: " + elementWiseAddition(numbers, numbersTwo));
    }

    public static int calculateAllNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static int findBiggestNumber(int[] numbers) {
        int biggestNumber = numbers[0];
        for (int number : numbers) {
            if (number > biggestNumber) {
                biggestNumber = number;
            }
        }
        return biggestNumber;
    }

    public static String elementWiseAddition(int[] arr1, int[] arr2) {
        int maxLength = Math.max(arr1.length, arr2.length);
        int[] result = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            int val1 = i < arr1.length ? arr1[i] : 0;
            int val2 = i < arr2.length ? arr2[i] : 0;
            result[i] = val1 + val2;
        }
        return Arrays.toString(result);
    }
}