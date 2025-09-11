import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> arrayList = Arrays.stream(array).boxed().collect(Collectors.toList());

        for (int x = 0; x < commands.length; x++) {
            int[] command = commands[x];
            int i = command[0];
            int j = command[1];
            int k = command[2];

            List<Integer> range = new ArrayList<>(arrayList.subList(i - 1, j));
            Collections.sort(range);
            answer.add(range.get(k - 1));
        }
        
        return answer;
    }
}