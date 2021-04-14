import java.io.*;
import java.util.*;

public class Main{
	static long gcd(long a,long b){
		if(b>a){
			return gcd(b,a);
		}
		long r = a%b;
		if(r == 0){
			return b;
		}
		return gcd(b,r);
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		long a = Long.parseLong(s[0]);
		long b = Long.parseLong(s[1]);
		long c = gcd(a,b);
		for(int i = 0;i<c;i++){
			bw.write('1');
		}
		bw.flush();
		bw.close();
	}
}
