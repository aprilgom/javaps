import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] prime = new int[N+1];
		Arrays.fill(prime,1);
		prime[0] = 0;
		prime[1] = 0;
		for(int i = 2;i*i<=N;i++){
			if(prime[i] != 0){
				for(int j = i*i;j<=N;j+=i){
					prime[j] = 0;
				}
			}
		}
		for(int i = M;i<=N;i++){
			if(prime[i]==1){
				System.out.println(i);
			}
		}
	}
}
