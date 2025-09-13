import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
    Map<String, Boolean> map = new HashMap<>();
        
       // 1. 모든 번호 map에 저장
        for (String num : phone_book) {
            map.put(num, true);
        }
        
        // 2. 각 번호의 접두사 확인
        for (String num : phone_book) {
            for (int i = 1; i < num.length(); i++) { // 1글자 ~ n-1글자까지
                if (map.containsKey(num.substring(0, i))) {
                    return false; // 접두사 발견
                }
            }
        }
        
        return true; // 접두사 없음
    }
}