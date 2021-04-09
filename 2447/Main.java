import java.util.*;
import java.io.*;

public class Main{
	static StringBuilder sb;
	static int[][] image;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		image = new int[N][N];
		sb = new StringBuilder();
		mark(0,0,N);
		for(int x = 0;x<N;x++){
			for(int y = 0;y<N;y++){
				if(image[x][y] == 1){
					sb.append("*");
				}else{
					sb.append(" ");
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void mark(int x_b,int y_b,int n){
		if(n == 1){
			image[x_b][y_b] = 1;
			return;
		}
		for(int x = 0;x<3;x++){
			for(int y = 0;y<3;y++){
				if(x == 1 && y == 1){
					continue;
				}
				mark(x_b + x*n/3,y_b + y*n/3,n/3);
			}
		}
	}
}
