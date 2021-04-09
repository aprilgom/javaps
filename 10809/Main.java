import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] fa = new int[26];
		Arrays.fill(fa,-1);
		for(int i = 0;i<s.length();i++){
			if(fa[s.charAt(i)-'a']==-1){
				fa[s.charAt(i)-'a'] = i;
			}		
		}
		StringBuilder sb = new StringBuilder();
		for(int i:fa){
			sb.append(i).append(' ');
		}
		System.out.println(sb);
	}
}
