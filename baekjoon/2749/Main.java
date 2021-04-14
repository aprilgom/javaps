import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long a = 0;
		long b = 1;
		long c = 1;
		n %= 1500000;
		for(long i = 1;i<=n-1;i++){
			c = (a+b)%1000000;
			a = b;
			b = c;
		}
		System.out.print(c);
	}
}
