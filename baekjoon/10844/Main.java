import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] s = new long[10][101];
		for(int j = 0;j<10;j++){
			s[j][0] = 1;
		}
		for(int i = 1;i<N;i++){
				s[0][i] = s[1][i-1];
				s[9][i] = s[8][i-1];
			for(int j = 1;j<9;j++){
				s[j][i] = (s[j-1][i-1] + s[j+1][i-1])%1000000000;
			}
		}
		long ret = 0;
		for(int j = 1;j<10;j++){
			ret += s[j][N-1];
		}
		System.out.println(ret%1000000000);
	}
}
