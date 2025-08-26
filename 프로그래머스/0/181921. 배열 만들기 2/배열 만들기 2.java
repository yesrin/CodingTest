
import java.util.*;

class Solution {
    public List<Integer> solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        for(int i=l; i<=r; i++){
            if (String.valueOf(i).matches("[05]+")) { // ✅ 0과 5만으로 이루어진 숫자인지
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
                answer.add(-1);
            }
        return answer;
    }
}