import java.util.Scanner;

public class Main{
 public static void main(String[] args){
 Scanner scanner = new Scanner(System.in);
       
        int n = scanner.nextInt();  //3
        int[] numbers = new int[n]; //451 int[3]는 numbers[0]~numbers[2]
        
        // n개의 데이터 입력 받기
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // 선택 정렬 시작
        for (int i =0; i < n; i++) {  
            int minIdx = i;  // 최소값 인덱스
            
            for (int j = i + 1; j < n; j++) {  
                if (numbers[minIdx] > numbers[j]) {  // 최소값보다 더 작은 값을 찾으면
                    minIdx = j;  // 최소값 인덱스를 업데이트
                }
            }
            // 현재 위치 numbers[i]와 최소값 위치 numbers[minIdx]를 교환
            int temp = numbers[i];
            numbers[i] = numbers[minIdx];
            numbers[minIdx] = temp;
        }
        
        // 정렬된 배열 출력
        for (int i = 0; i < n; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
 }
