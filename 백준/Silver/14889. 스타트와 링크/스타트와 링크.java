import java.util.*;

public class Main {
    static int N; // 전체 사람 수
    static boolean[] check; // 각 사람(1~N)이 스타트 팀인지 여부
    static int[][] board; // 능력치 표
    static int MIN_RESULT = Integer.MAX_VALUE; // 최소 점수 차이 저장

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        N = scanner.nextInt();
        check = new boolean[N + 1]; 
        board = new int[N + 1][N + 1];
        
        // 능력치 입력받기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        // 팀 조합
        combination(0, 1);

        // 최소 점수 차이 출력
        System.out.println(MIN_RESULT);
    }


    static void combination(int dep, int start) {
       
        if (dep == N / 2) {
            MIN_RESULT = Math.min(MIN_RESULT, getResult()); //더 작은값 저장
            return;
        }

        for (int i = start; i <= N; i++) {
            check[i] = true; // i번 사람을 스타트 팀으로 선택
            combination(dep + 1, i + 1); // 다음 사람 선택
            check[i] = false; // 선택 해제 (백트래킹)
        }
    }

    static int getResult() {
        int start = 0, link = 0;

        // 두 팀의 능력치 합산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue; // 같은 사람끼리는 계산 안 함
                if (check[i] && check[j]) start += board[i][j]; // 스타트 팀 능력치 합산
                if (!check[i] && !check[j]) link += board[i][j]; // 링크 팀 능력치 합산
            }
        }
        return Math.abs(start - link); // 능력치 차이 반환
    }
}
