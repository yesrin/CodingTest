import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String stringNum = sc.next();
        
        int result = 0;
        char[] charNum = stringNum.toCharArray();
        for(int i=0; i<charNum.length; i++){
           result += charNum[i]-'0';
        }
        
        System.out.println(result);
    }
}