import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] cnt = new int[26];
		for(int i = 0;i<s.length();i++){
			cnt[s.charAt(i)-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<26;i++){
			sb.append(cnt[i]);
			sb.append(' ');
		}
		System.out.println(sb);
	}
}
