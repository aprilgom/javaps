import java.util.*;
import java.io.*;

public class Main{
	static long zcount(long n,long k){
		long dvr = k;
		long ret = 0;
		long q = 0;
		while((q = n/dvr) > 0){
			ret += q;
			dvr *= k;
		}
		return ret;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long N = Long.parseLong(s[0]);
		long M = Long.parseLong(s[1]);
		long f = zcount(N,5)-zcount(N-M,5)-zcount(M,5);
		long t = zcount(N,2)-zcount(N-M,2)-zcount(M,2);
		System.out.println(Math.min(f,t));
	}
}
