import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] baseArray = new int[10];

        int sumResult = a * b * c;
        String sumResultToString = Integer.toString(sumResult);

        for (char i : sumResultToString.toCharArray()) {
            baseArray[i - '0']++;
        }

        for (int j : baseArray) {
            System.out.println(j);
        }

    }
}