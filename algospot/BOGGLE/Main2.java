import java.util.*;
import java.io.*;

public class Main{
	static char[][] map;
	static boolean[][][] visited;
	static String word;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new char[5][5];

		for(int c = 0;c<C;c++){

			for(int i = 0;i<5;i++){
				String tmp = br.readLine();
				for(int j = 0;j<5;j++){
					map[i][j] = tmp.charAt(j);
				}
			}

			int N = Integer.parseInt(br.readLine());
			for(int i = 0;i<N;i++){
				word = br.readLine();
				sb.append(word).append(" ");
				if(isAvailable()){
					sb.append("YES\n");
				}else{
					sb.append("NO\n");
				}
			}
		}
		System.out.print(sb);
	}
	static boolean isAvailable(){
		visited = new boolean[5][5][word.length()];
		for(int y = 0;y<5;y++){
			for(int x = 0;x<5;x++){
				if(word.charAt(0) == map[y][x]){
					if(sol(y,x,0)){
						return true;
					}
				}
			}
		}
		return false;
	}
	static boolean sol(int y,int x,int n){
		for(int i = 0;i<8;i++){
			int ty = y + dy[i];
			int tx = x + dx[i];
			if(ty<0 || ty>=5 || tx<0 || tx>=5){
				continue;
			}
			if(visited[ty][tx][n+1]){
				continue;
			}
			if(map[ty][tx] != word.charAt(n+1)){
				continue;
			}
			if(n+1 == word.length()-1){
				return true;
			}
			visited[ty][tx][n+1] = true;
			if(sol(ty,tx,n+1)){
				return true;
			}
		}
		return false;
	}
}
