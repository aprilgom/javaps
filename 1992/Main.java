import java.io.*;
import java.util.*;

public class Main{
	static int[][] image;
	static StringBuilder sb;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		image = new int[N][N];
		StringTokenizer st; 
		for(int y = 0;y<N;y++){
			for(int x = 0;x<N;x++){
				image[x][y] = br.read()-'0';
			}
			br.read();
		}
		sb = new StringBuilder();
		qtree(0,0,N);
		System.out.println(sb);
	}
	static boolean check(int x_b,int y_b,int n){
		int tmp = image[x_b][y_b];
		for(int x = 0;x<n;x++){
			for(int y = 0;y<n;y++){
				if(image[x+x_b][y+y_b] != tmp){
					return false;
				}
			}
		}
		return true;
	}
	static void qtree(int x_b,int y_b,int n){
		int tmp = image[x_b][y_b];
		if(check(x_b,y_b,n)){
			sb.append(tmp);
		}else{
			sb.append('(');
			qtree(x_b,y_b,n/2);
			qtree(x_b+n/2,y_b,n/2);
			qtree(x_b,y_b+n/2,n/2);
			qtree(x_b+n/2,y_b+n/2,n/2);
			sb.append(')');
		}
	}
}
