import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		int[] nl = Arrays.stream(br.readLine().split(" "))
			.mapToInt(i->Integer.parseInt(i))
			.toArray();
		int[] primes = new int[1001];
		Arrays.fill(primes,1);
		primes[1] = 0;
		for(int i = 2;i<=1000;i++){
			for(int j = i*2;j<=1000;j+=i){
				primes[j] = 0;
			}
		}
		int count = 0;
		for(int i:nl){
			if(primes[i] == 1){
				count++;
			}
		}
		System.out.println(count);
	}
}
