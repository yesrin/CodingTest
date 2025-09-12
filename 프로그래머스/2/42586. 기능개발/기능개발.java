import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int day=0;
        List<Integer> dayList = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            day =(int) Math.ceil((double)(100-progresses[i])/speeds[i]);
            dayList.add(day);
        }
        // 7,3 이렇게 있으면 7일뒤에 
        int standard = dayList.get(0); // 기준 배포일
        int count = 1;                 // 같이 배포되는 기능 수

        for (int i = 1; i < dayList.size(); i++) {
            if (dayList.get(i) <= standard) {
                // 기준일보다 빨리 끝나면 같이 배포
                count++;
            } else {
                // 기준일보다 늦게 끝나면 이전까지 배포
                answer.add(count);
                count = 1; // 새로 시작
                standard = dayList.get(i);
            }
        }
        
        answer.add(count); // 마지막 배포 추가
        return answer;
        }
    }