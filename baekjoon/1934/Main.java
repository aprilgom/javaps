import java.io.*;
import java.util.*;

public class Main{
	static int gcd(int a,int b){
		if(b>a){
			return gcd(b,a);
		}
		int r = a%b;
		if(r == 0){
			return b;
		}
		return gcd(b,r);
	}
	static int lcm(int a,int b){
		return a*b/gcd(a,b);
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i<T;i++){
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			System.out.println(lcm(a,b));
		}
	}
}
