import java.util.*;
class Solution
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B); // 반대로 읽을 거임
    
        for(int i=0; i< A.length; i++){
           answer += A[i]*B[A.length-i-1];
        }
        
        return answer;
    }
}