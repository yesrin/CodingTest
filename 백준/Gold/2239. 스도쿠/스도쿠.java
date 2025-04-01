import java.util.*;


public class Main{
	public static int[][] map = new int[9][9];

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		   // 입력 받기 (각 줄마다 9개의 숫자를 입력받음)
        for (int i = 0; i < 9; i++) {
            String input = sc.nextLine(); // 한 줄을 입력받음
            for (int j = 0; j < 9; j++) {
                // 각 문자를 정수로 변환하여 map 배열에 저장
                map[i][j] = input.charAt(j) - '0';
            }
        }
		
		dfs(0,0);
		
	}
	
	public static void dfs(int row, int col){
		if(col==9){
			col=0;
			row++;
		}
		
		if(row==9){
			row=0;
				
			// 출력
			for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
			System.exit(0); //끝내기
		}
		
		if(map[row][col]!=0){
			dfs(row, col+1);
		}else{
			//0 일때는 1~9 중에 없는 거 넣기..			
			for(int num=1; num<=9; num++){ 
					// 여기서 범위내에 같은 숫자 있는지 체크하고 없으면 넣기
					if(checkNum(row, col, num)){
							map[row][col]=num;
							dfs(row, col+1);
							map[row][col] = 0;   // 백트래킹: 이후 진행이 안 되면 숫자를 되돌림
					 }
			}
			
		}
	}
	
	public static boolean checkNum(int row, int col , int num){
		//범위 체크 범위 내에 없으면 true
		
		//같은 행/열 에 값있으면 false
		for(int i=0; i< 9; i++){
			if(map[i][col] ==num || map[row][i] ==num){
				return false;
			}
		}
		
		//3*3에 있는지
		int rowPoint = row/3;
		int colPoint = col/3;	
		
		int startRow = rowPoint*3;
		int startCol = colPoint*3;
		
		for(int x=0; x<3; x++){
				for(int y =0; y<3; y++){


				if(map[startRow+x][startCol+y] == num){
					 return false;
				};
			}
		}
		
		return true;
	}
}