import java.util.*;
import java.io.*;

public class Main{
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		dp = new int[19683];
		for(int tc = 0;tc<TC;tc++){
			int[][] board = new int[3][3];
			Arrays.fill(dp,-2);
			int xcount = 0;
			int ocount = 0;
			for(int i = 0;i<3;i++){
				String line = br.readLine();
				for(int j = 0;j<3;j++){
					char c = line.charAt(j);
					if(c == 'x'){
						board[i][j] = -1;
						xcount++;
					}else if(c == 'o'){
						board[i][j] = 1;
						ocount++;
					}
				}
			}
			int player = 0;
			if(xcount ==  ocount){
				player = -1;
			}else{
				player = 1;
			}
			int winner = play(player,board) * player;
			if(winner == 1){
				System.out.println("o");
			}else if(winner == -1){
				System.out.println("x");
			}else{
				System.out.println("TIE");
			}
		}
	}
	static int serialize(int[][] board){
		int ret = 0;
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				ret *= 3;
				ret += board[i][j]+1;
			}
		}
		return ret;
	}
	static void print(int[][] board){
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				if(board[i][j] == 1){
					System.out.print('o');
				}else if(board[i][j] == -1){
					System.out.print('x');
				}else{
					System.out.print('.');
				}
			}
			System.out.println();
		}
	}
	static int play(int player,int[][] board){
		if(isFinished(-player,board)){
			return -1;
		}
		int board_idx = serialize(board);
		if(dp[board_idx] != -2){
			return dp[board_idx];
		}
		
		int min_value = 2;
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
				if(board[i][j] != 0){
					continue;
				}
				board[i][j] = player;
				min_value = Math.min(min_value,play(-player,board));
				board[i][j] = 0;
			}
		}
		if(min_value == 2 || min_value == 0){
			dp[board_idx] = 0;
			return 0;
		}
		dp[board_idx] = -min_value;
		return -min_value;
	}
	static boolean isFinished(int player,int[][] board){
		//return 1 when player wins
		//return -1 when player loses
		//return 0 when draw
		
		//check rows & columns
		int winner = 0;
		for(int i = 0;i<3;i++){
			int r_sum = 0;
			int c_sum = 0;
			for(int j = 0;j<3;j++){
				r_sum += board[i][j];
				c_sum += board[j][i];
			}
			if(r_sum == 3 || c_sum == 3){
				winner = 1;
				break;
			}else if(r_sum == -3 || c_sum == -3){
				winner = -1;
				break;
			}
		}
		//check diagonal
		int diag_a = board[0][0] + board[1][1] + board[2][2];
		int diag_b = board[0][2] + board[1][1] + board[2][0];
		if(diag_a == 3 || diag_b == 3){
			winner = 1;
		}
		if(diag_a == -3 || diag_b == -3){
			winner = -1;
		}

		if(winner == player){
			return true;
		}
		return false;
	}
}
