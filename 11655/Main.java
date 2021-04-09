import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = 0;
		while((c = br.read()) != -1){
			if(c>='a'&&c<='z'){
				c = (c-'a'+13)%26+'a';
			}
			if(c>='A'&&c<='Z'){
				c = (c-'A'+13)%26+'A';
			}
			sb.append((char)c);
		}
		System.out.println(sb);
	}
}
