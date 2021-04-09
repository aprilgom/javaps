import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int mul = 1;
		int k = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = s.length();i>=3;i-=3){
			k = Integer.parseInt(s.substring(i-3,i),2);
			sb.append(k);
		}
		int r = s.length()%3;
		if(r != 0){
			k = Integer.parseInt(s.substring(0,r),2);
			sb.append(k);
		}
		System.out.println(sb.reverse());
	}
}
