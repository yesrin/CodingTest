import java.util.*;
class Solution {
   public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            // n번째 문자 비교
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2); // 같으면 전체 문자열 기준
            } else {
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        });
        return strings;
    }
}