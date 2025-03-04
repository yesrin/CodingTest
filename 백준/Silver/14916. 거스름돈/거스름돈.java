import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pay = sc.nextInt();

        int minCoins = Integer.MAX_VALUE; //큰 값

        for (int a = 0; a * 5 <= pay; a++) { // 5원 개수 바꿔가며 최소 개수 찾기
            int remaining = pay - (a * 5);
            if (remaining % 2 == 0) { // 2원으로 나눠질 때만 유효
                int b = remaining / 2;
                minCoins = Math.min(minCoins, a + b); // 작은값으로 최소 개수 갱신
            }
        }

        System.out.println(minCoins == Integer.MAX_VALUE ? -1 : minCoins);
    }
}
