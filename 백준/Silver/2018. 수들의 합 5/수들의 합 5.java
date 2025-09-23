import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        
        while(endIndex<=N){
            if(sum==N){
                count++;
                sum = sum-startIndex;
                startIndex++;
            }else if(sum>N){
                sum = sum - startIndex;
                startIndex++;
            }else{
                endIndex++;
                sum = sum+endIndex;
            }
        }
        System.out.println(count);
    }
}