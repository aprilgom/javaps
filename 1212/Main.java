import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder ret_sb = new StringBuilder();
		int c = s.charAt(0) - '0';
		String si = Integer.toBinaryString(c);
		ret_sb.append(si);
		for(int i = 1;i<s.length();i++){
			c = s.charAt(i) - '0';
			si = Integer.toBinaryString(c);
			StringBuilder sb = new StringBuilder(si);
			for(int j = si.length();j<3;j++){
				sb.insert(0,'0');
			}
			ret_sb.append(sb.toString());
		}
		System.out.println(ret_sb);
	}
}
