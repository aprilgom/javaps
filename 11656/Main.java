import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] sff = new String[s.length()];
		for(int i = 0;i<s.length();i++){
			sff[i] = s.substring(i,s.length());
		}
		Arrays.sort(sff);
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s.length();i++){
			sb.append(sff[i]).append("\n");
		}
		System.out.println(sb);
	}
}
