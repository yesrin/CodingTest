import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        // 1. 숫자를 char 배열로 변환
        char[] arr = numbers.toCharArray();
        boolean[] visited = new boolean[arr.length];
        
        // 2. DFS로 모든 순열 생성
        dfs(arr, visited, "");
        
        // 3. 소수 개수 세기
        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }
        
        return count;
    }
    
    // 순열 DFS
    private void dfs(char[] arr, boolean[] visited, String current) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current)); // 숫자 추가
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(arr, visited, current + arr[i]); // 다음 숫자 붙이기
                visited[i] = false; // backtracking
            }
        }
    }
    
    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}