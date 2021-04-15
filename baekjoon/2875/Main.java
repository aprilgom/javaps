import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int ret = 0;
		while(N-2>=0 && M-1>=0 && K <= N+M-3){
			N-=2;
			M-=1;
			ret++;
		}
		System.out.println(ret);
	}
}