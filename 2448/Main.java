import java.util.*;
import java.io.*;

public class Main{
	static StringBuilder sb;
	static int[][] image;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int width = 2*N-1;
		sb = new StringBuilder();
		image = new int[width][N];
		mark(0,0,N);
		for(int y = 0;y<N;y++){
			for(int x = 0;x<width;x++){
				if(image[x][y] == 1){
					sb.append('*');
				}else{
					sb.append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	static void mark(int x_b,int y_b,int n){
		if(n == 3){
			image[x_b+2][y_b] = 1;
			image[x_b+1][y_b+1] = 1;
			image[x_b+3][y_b+1] = 1;
			image[x_b][y_b+2] = 1;
			image[x_b+1][y_b+2] = 1;
			image[x_b+2][y_b+2] = 1;
			image[x_b+3][y_b+2] = 1;
			image[x_b+4][y_b+2] = 1;
			return;
		}
		mark(x_b+n/2,y_b,n/2);
		mark(x_b,y_b+n/2,n/2);
		mark(x_b+n,y_b+n/2,n/2);
	}
}
