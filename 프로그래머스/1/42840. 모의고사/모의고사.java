import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] answer = {};
        int[] pattern1= new int[]{1, 2, 3, 4, 5}; //5
        int[] pattern2= new int[]{2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] pattern3= new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10
        
        int[] score = new int[3]; //수포자의 점수
        
        // 정답 같으면 +1
        for(int i=0; i<answers.length; i++){
            if(answers[i]== pattern1[i % pattern1.length]) score[0]++;
            if(answers[i]== pattern2[i % pattern2.length]) score[1]++;
            if(answers[i]== pattern3[i % pattern3.length]) score[2]++;
        };
        
        int maxScore = Math.max(score[2],Math.max(score[0],score[1]));
        
        //최대 점수와 같은 사람 찾기
        List<Integer> list = new ArrayList<>();
        for(int j = 0; j < 3; j++) {
            if (score[j] == maxScore) list.add(j + 1); // 수포자 번호 1,2,3
        }
    
        return list;
    }
}