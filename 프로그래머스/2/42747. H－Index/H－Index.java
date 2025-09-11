import java.util.*;
class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        Arrays.sort(citations); //12345
        int n =citations.length;
        for(int i=0; i<n; i++){
            int citation = citations[n - 1 - i]; // 큰 값부터 확인
            if(citation>= i+1) 
                 answer= i+1;
            else break;
        }
        return answer;
    }
}