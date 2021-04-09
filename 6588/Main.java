import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] prime = new int[1000001];
		Arrays.fill(prime,1);
		prime[0] = 0;
		prime[1] = 0;
		for(int i = 2;i*i<=1000000;i++){
			if(prime[i]!=0){
				for(int j = i*i;j<=1000000;j+=i){
					prime[j] = 0;
				}
			}
		}
		int n = -1;
		StringBuilder sb = new StringBuilder();
		while((n = Integer.parseInt(br.readLine())) != 0){
			for(int i = 3;i<=n;i++){
				if(prime[i] == 1 && prime[n-i] == 1){
					sb.append(n)
						.append(" = ")
						.append(i)
						.append(" + ")
						.append(n-i)
						.append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
