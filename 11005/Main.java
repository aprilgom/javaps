import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		StringBuilder sb = new StringBuilder();
		while(N>0){
			int r = N%B;
			int ch = 0;
			if(r<10){
				ch = '0'+r;
			}else{
				ch = 'A'+r-10;
			}
			sb.insert(0,(char)ch);
			N/=B;
		}
		System.out.println(sb);
	}
}
