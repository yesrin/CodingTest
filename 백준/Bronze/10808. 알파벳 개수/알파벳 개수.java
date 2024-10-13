import java.util.Scanner;

//알파벳 개수
public class Main {

     public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
        String inputWord = sc.nextLine();

        int[] alphabetPresence = new int[26];

        for (char c : inputWord.toCharArray()) {
            alphabetPresence[c - 'a']++;
        }

        for (int presence : alphabetPresence) {
            System.out.print(presence + " ");
        }
    }
}