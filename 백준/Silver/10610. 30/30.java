import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); // 입력 받은 숫자

        char[] arr = input.toCharArray();
        Arrays.sort(arr); // 오름차순 정렬

        int sum = 0;
        StringBuilder sb = new StringBuilder();

        // 숫자의 합 계산과 결과 문자열 생성
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - '0'; // 숫자 변환
            sum += num;
            sb.append(num); // 결과 문자열에 숫자 추가
        }

        // 3의 배수 조건 확인: 숫자의 합이 3의 배수여야 하고, 0이 포함되어 있어야 한다
        if (sum % 3 != 0 || arr[0] != '0') {
            System.out.println(-1); // 조건에 맞지 않으면 -1 출력
        } else {
            System.out.println(sb); // 조건에 맞으면 결과 출력
        }

        sc.close();
    }
}
