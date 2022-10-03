import java.util.Random;
import java.util.Scanner;
public class Main {
    // Part1
    //Array output
    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    //Creation of an array of given length with random values
    public static int[] randomArray(int lengthOfArray) {
        Random random = new Random();
        int[] randArray = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            randArray[i] = random.nextInt(100);
        }
        return randArray;
    }

    //Creation of an array of given length with values from user input
    public static int[] newArray(int lengthOfArray) {
        Scanner scanner = new Scanner(System.in);
        int[] userArray = new int[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            userArray[i] = scanner.nextInt();
        }
        return userArray;
    }

    //Bubble sort method + Project7.Part3(optimisation for outer loop) + Project7.Part4(optimisation for inner loop)
    public static int[] BubbleSort(int[] array) {
        boolean swapped = true;
        int n = array.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < n; i++) {
                if (array[i] > array[i + 1]) {
                    swapped = true;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            n--;
        }
        return array;
    }

    //Part2
    public static boolean isContinue() {
        System.out.println("Do you want to repeat? Y/N");
        Scanner scanner = new Scanner(System.in);
        String yesOrNo = scanner.nextLine();
        if (yesOrNo.equalsIgnoreCase("Y")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        do {
            System.out.println("Please enter number of elements");
            Scanner scanner = new Scanner(System.in);
            int lengthOfArray = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Do you want to generate values or input by yourself? Please write generate or by myself");
            String typeOfArray = scanner.nextLine();
            if (typeOfArray.equalsIgnoreCase("generate")) {
                int[] unsortedArray = randomArray(lengthOfArray);
                System.out.println("Unsorted array:");
                printArray(unsortedArray);
                System.out.println("Sorted array:");
                printArray(BubbleSort(unsortedArray));

            } else {
                System.out.println("Please enter numbers for your array");
                int[] unsortedArray = newArray(lengthOfArray);
                System.out.println("Unsorted array:");
                printArray(unsortedArray);
                System.out.println("Sorted array:");
                printArray(BubbleSort(unsortedArray));
            }
        } while (isContinue());
        System.out.println("Bye, see you later!");
    }
}