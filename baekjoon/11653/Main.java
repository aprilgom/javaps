import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] prime = new int[N+1];
		Arrays.fill(prime,1);
		prime[0] = 0;
		prime[1] = 0;
		for(int i = 2;i*i<=N;i++){
			if(prime[i]!=0){
				for(int j = i*i;j<=N;j+=i){
					prime[j] = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(N>1){
			for(int i = 2;i<=N;i++){
				if(prime[i] == 1 && N%i == 0){
					sb.append(i).append("\n");
					N /= i;
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
