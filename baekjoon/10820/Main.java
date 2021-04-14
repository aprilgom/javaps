import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while((s = br.readLine()) != null){
			int[] ret = new int[4];
			for(int i = 0;i<s.length();i++){
				int c = s.charAt(i);
				if(c>='a' && c<='z'){
					ret[0]++;
				}
				if(c>='A' && c<='Z'){
					ret[1]++;
				}
				if(c>='0' && c<='9'){
					ret[2]++;
				}
				if(c==' '){
					ret[3]++;
				}
			}
			for(int i:ret){
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
