import java.util.*;
import java.io.*;

public class Main{
	static int[][] sudoku; 
	static List<int[]> blanks;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sudoku = new int[9][9];
		blanks = new ArrayList<>();
		for(int y = 0;y<9;y++){
			st = new StringTokenizer(br.readLine());
			for(int x = 0;x<9;x++){
				sudoku[y][x] = Integer.parseInt(st.nextToken());
				if(sudoku[y][x] == 0){
					blanks.add(new int[]{y,x});
				}
			}
		}
		sol(0);
		StringBuilder sb = new StringBuilder();
		for(int y = 0;y<9;y++){
			for(int x = 0;x<9;x++){
				sb.append(sudoku[y][x]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static boolean sol(int idx){
		if(idx == blanks.size()){
			return true;
		}
		int[] blank = blanks.get(idx);
		int b_y = blank[0];
		int b_x = blank[1];
		boolean[] used = new boolean[10];
		for(int i = 0;i<9;i++){
			used[sudoku[i][b_x]] = true;
			used[sudoku[b_y][i]] = true;
		}
		int sq_y = b_y-b_y%3;
		int sq_x = b_x-b_x%3;
		for(int y = 0;y<3;y++){
			for(int x=0;x<3;x++){
				used[sudoku[sq_y+y][sq_x+x]] = true;
			}
		}
		for(int i = 1;i<=9;i++){
			if(!used[i]){
				sudoku[b_y][b_x] = i;
				if(sol(idx+1)){
					return true;
				}
				sudoku[b_y][b_x] = 0;
			}
		}
		return false;
	}
}
