import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        int[] answer = {};
        List<Integer> listArray = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(listArray.isEmpty() || arr[i] != listArray.get(listArray.size() - 1)){ //지금 값과 마지막으로 넣은 값이 다르면 추가
                listArray.add(arr[i]);
            }
        }
     return listArray;
    }
}