import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		if(N==0){
			System.out.println(0);
			return;
		}
		while(N!=0){
			int r = N%(-2);
			N = r<0?N/(-2)+1:N/(-2);
			r = r<0?r+2:r;
			sb.append(r);
		}
		System.out.println(sb.reverse());
	}
}
