import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] sq = new int[N];
		for(int i = 0;i < N;i++){
			sq[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sq);
		int sum = 0;
		int ret = 0;
		for(int i:sq){
			sum = sum + i;
			ret += sum;
		}
		System.out.println(ret);
	}
}
