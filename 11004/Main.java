import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] snk = br.readLine().split(" ");
		int N = Integer.parseInt(snk[0]);
		int K = Integer.parseInt(snk[1]);
		long[] sq = new long[N];
		long n = 0;
		long pn = 1;
		int c = 0;
		int i = 0;
		while(true){
			c = br.read();
			if(c == '\n'){
				sq[i] = n;
				break;
			}
			if(c == ' '){
				sq[i] = n;
				n = 0;
				pn = 1;
				i++;
				continue;
			}
			if(c == '-'){
				pn = -1;
				continue;
			}
			n = n*10+pn*(c-'0');
		}
		Arrays.sort(sq);
		System.out.println(sq[K-1]);
	}
}
