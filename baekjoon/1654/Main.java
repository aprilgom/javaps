import java.util.*;
import java.io.*;

public class Main{
	static int K;
	static int N;
	static long[] wires;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		K = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		wires = new long[K];
		long l = 1;
		long r = 0; 
		for(int i = 0;i<K;i++){
			wires[i] = Long.parseLong(br.readLine());
			r = Math.max(r,wires[i]);
		}
		long mid = 0;
		long cut_n = 0;
		while(l<=r){
			mid = (l+r)/2;
			cut_n = getCutNumber(mid);
			if(cut_n>=N){
				l = mid+1;
			}else{
				r = mid-1;
			}
		}
		System.out.println(r);
	}
	static long getCutNumber(long cut_len){
		long ret = 0;
		for(int i = 0;i<K;i++){
			ret += wires[i]/cut_len;
		}
		return ret;
	}
}
