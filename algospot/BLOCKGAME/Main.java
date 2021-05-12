import java.util.*;
import java.io.*;

public class Main{
	static byte[] dp;
	static int[] moves;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		moves = new int[104];
		precalc();

		dp = new byte[1<<25];
		for(int tc = 0;tc<TC;tc++){
			Arrays.fill(dp,(byte)-1);
			int board = 0;
			for(int i = 0;i<5;i++){
				for(int j = 0;j<5;j++){
					char c = (char)(br.read());
					if(c == '#'){
						board |= 1<<(5*i + j);
					}
				}
				br.read();
			}
			if(play(board)>0){
				System.out.println("WINNING");
			}else{
				System.out.println("LOSING");
			}
		}
	}
	static int cell(int y,int x){
		return 1<<(y*5 + x);
	}
	static void precalc(){
		int m_i = 0;
		for(int y = 0;y<4;y++){
			for(int x = 0;x<4;x++){
				List<Integer> cells = new ArrayList<>();
				for(int dy = 0;dy<2;dy++){
					for(int dx = 0;dx<2;dx++){
						cells.add(cell(y+dy,x+dx));
					}
				}
				int square = cells.get(0)+
							cells.get(1)+
							cells.get(2)+
							cells.get(3);
				for(int i = 0;i<4;i++){
					moves[m_i] = square - cells.get(i);
					m_i++;
				}
			}
		}
		for(int i = 0;i<5;i++){
			for(int j = 0;j<4;j++){
				moves[m_i] = cell(i,j) + cell(i,j+1);
				m_i++;
				moves[m_i] = cell(j,i) + cell(j+1,i);
				m_i++;
			}
		}
	}
	static byte play(int board){
		if(dp[board] != -1){
			return dp[board];
		}
		byte ret = 0;
		for(int i = 0;i<moves.length;i++){
			if((moves[i]&board) == 0){
				if(play(board | moves[i])==0){
					ret = 1;
					break;
				}
			}
		}
		dp[board] = ret;
		return ret;
	}
}
