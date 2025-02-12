import java.util.*;

public class Main {
    public static int N, M;
    public static int[] array;
    public static boolean[] visited;

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  
        M = sc.nextInt();  

        array = new int[M]; 
        visited = new boolean[N + 1];

        dfs(0);     
    }

    public static void dfs(int depth) {
        if (depth == M) { // depth 가  M이 되면 출력
            for (int i = 0; i < M; i++) { // 길이가 M인 수열 출력
                System.out.print(array[i] + " "); // 출력
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {  // 아직 사용하지 않은 숫자인 경우
                visited[i] = true;  // 방문 체크
                array[depth] = i;  // 현재 위치에 숫자 저장

                dfs(depth + 1);  // 다음 숫자 선택 (재귀 호출)

                visited[i] = false; 
            }
        }
    }
}
