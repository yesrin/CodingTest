import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberStrings = Arrays
            .stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        Arrays.sort(numberStrings, (a, b)-> (b + a).compareTo(a + b));
        
        if(numberStrings[0].equals("0")) return "0";
    
        return String.join("",numberStrings);
    }
}