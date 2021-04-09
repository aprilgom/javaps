import java.util.*;
import java.io.*;

public class Main{
	static StringBuilder sb;
	static int K;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(1,2,3,N);
		System.out.println(K);
		System.out.println(sb);
	}
	static void hanoi(int from,int buf,int to,int n){
		if(n == 1){
			K++;
			sb.append(from).append(" ").append(to).append("\n");
			return;
		}
		hanoi(from,to,buf,n-1);
		hanoi(from,buf,to,1);
		hanoi(buf,from,to,n-1);
	}
}
