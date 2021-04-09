import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[N+1];
		Arrays.fill(isPrime,true);
		List<Integer> prime_l = new ArrayList<>();
		for(int i = 2;i<=N;i++){
			if(!isPrime[i]){
				continue;
			}
			prime_l.add(i);
			for(int j = i*2;j<=N;j+=i){
				isPrime[j] = false;
			}
		}
		 
		int[] prime_arr = prime_l.stream()
			.mapToInt(i->i)
			.toArray();
		int l = 0;
		int r = 0;
		int sum = 0;
		int ret = 0;
		while(true){
			if(sum>=N){
				if(sum == N){
					ret++;
				}
				sum -= prime_arr[l++];
			}else if(r == prime_arr.length){
				break;
			}else{
				sum += prime_arr[r++];
			}
		}
		System.out.println(ret);
	}
}
