import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean first = true; //단어의 첫 글자인지 여부 체크
        
        for(char a : s.toCharArray()){
            if(first){
                if(Character.isDigit(a)){
                   // 숫자일 때는 그대로 추가
                    sb.append(a);
                }else{
                    // 알파벳일 경우 대문자로 변환
                    sb.append(Character.toUpperCase(a));
                }
                first = false; // 첫 글자 처리 완료
            }else{
                if (Character.isLetter(a)) {
                    // 알파벳이면 소문자로
                    sb.append(Character.toLowerCase(a));
                } else {
                    // 알파벳이 아니면 그대로 추가
                    sb.append(a);
                }
            }
            
            // 공백 만나면 다음 글자는 단어의 첫 글자
            if (a == ' ') {
                first = true;
            }
        }
        return sb.toString();
    }
}