import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		String N = s[0];
		int B = Integer.parseInt(s[1]);
		int mul = 1;
		int sum = 0;
		for(int i = N.length()-1;i>=0;i--){
			int ch = N.charAt(i);
			int c = 0;
			if(ch>='0' && ch <= '9'){
				c = ch - '0';
			}else{
				c = ch - 'A'+10;
			}
			sum += c*mul;
			mul *= B;
		}
		System.out.println(sum);
	}
}
