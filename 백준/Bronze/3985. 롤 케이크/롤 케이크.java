import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int cakeSize = sn.nextInt(); // 롤 케이크의 길이
        int personNumber = sn.nextInt(); // 방청객의 수
        int[] cakeArray = new int[cakeSize + 1]; // 케이크 조각 배열
        int[] expectedPieces = new int[personNumber + 1]; // 기대하는 조각 수 배열
        int[] actualPieces = new int[personNumber + 1]; // 실제 받은 조각 수 배열

        int maxExpectedPieces = 0;
        int maxExpectedPerson = 0;

        for (int j = 1; j <= personNumber; j++) {
            int start = sn.nextInt(); // 시작 위치
            int end = sn.nextInt(); // 끝 위치
            expectedPieces[j] = end - start + 1; // 기대하는 조각 수 계산

            if (expectedPieces[j] > maxExpectedPieces) {
                maxExpectedPieces = expectedPieces[j];
                maxExpectedPerson = j; // 가장 많은 조각을 기대한 방청객의 번호
            }

            for (int i = start; i <= end; i++) {
                if (cakeArray[i] == 0) {
                    cakeArray[i] = j;
                    actualPieces[j]++; // 실제 받은 조각 수 증가
                }
            }
        }

        int maxActualPieces = 0;
        int maxActualPerson = 0;

        for (int j = 1; j <= personNumber; j++) {
            if (actualPieces[j] > maxActualPieces) {
                maxActualPieces = actualPieces[j];
                maxActualPerson = j; // 실제로 가장 많은 조각을 받은 방청객의 번호
            }
        }

        System.out.println(maxExpectedPerson); // 가장 많은 조각을 기대한 방청객의 번호 출력
        System.out.println(maxActualPerson); // 실제로 가장 많은 조각을 받은 방청객의 번호 출력
    }
}