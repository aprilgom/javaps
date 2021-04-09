import java.util.*;
import java.io.*;

public class Main{
	static int[][] map;
	static int neg_n = 0;
	static int zero_n = 0;
	static int pos_n = 0;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int y = 0;y<N;y++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x = 0;x<N;x++){
				map[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		count(0,0,N);
		System.out.println(neg_n);
		System.out.println(zero_n);
		System.out.println(pos_n);
	}
	static void count(int x,int y,int n){
		
		int tmp = map[x][y];
		if(checkSame(x,y,n)){
			if(tmp == -1){
				neg_n++;
			}
			if(tmp == 0){
				zero_n++;
			}
			if(tmp == 1){
				pos_n++;
			}
		}else{
			for(int y_i = y; y_i<y+n; y_i+=n/3){
				for(int x_i = x; x_i<x+n; x_i+=n/3){
					count(x_i,y_i,n/3);
				}
			}
		}
	}
	static boolean checkSame(int x,int y,int n){
		if(n == 1){
			return true;
		}
		int tmp = map[x][y];
		for(int i = x;i<x+n;i++){
			for(int j = y;j<y+n;j++){
				if(map[i][j] != tmp){
					return false;
				}
			}
		}
		return true;
	}
}
