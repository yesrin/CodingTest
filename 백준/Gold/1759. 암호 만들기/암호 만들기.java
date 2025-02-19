import java.io.*;
import java.util.*;

public class Main {

    public static int L, C;
    public static char[] alphabetList;
    public static char[] code;

    public static void main(String[] args){
    
		    Scanner sc = new Scanner(System.in);
		    L = sc.nextInt(); //길이
		    C = sc.nextInt(); //주어진 문자 개수;

        alphabetList = new char[C]; //입력받은 문자 저장
        code = new char[L]; //선택된 L개의 문자 저장

				//입력받기
        for (int x = 0; x < C; x++) {
            alphabetList[x] = sc.next().charAt(0);
        }


        //입력받은 문자를 정렬..
        Arrays.sort(alphabetList);

        backTrack(0,0);

    }

    public static void backTrack(int start, int dept) {
        if (dept == L) { //L개의 문자 선택 완료
            if (isValid()) { // 유요하면
                System.out.println(code); // 출력
            }
            return;
        }

    
        // 지금위치부터 C 까지 탐색
        for (int i = start; i < C; i++) { 
            code[dept] = alphabetList[i]; //지금문자
            backTrack(i+1, dept + 1); //다음문자
        }
    }

    // 최소 모음 1개, 최소 자음 2개인지 확인
    public static boolean isValid() {
        int mo= 0;
        int ja = 0;

        for (char x : code) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo >= 1 && ja >= 2) {
            return true;
        }
        return false;
    }

}