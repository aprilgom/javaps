import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c_arr = br.readLine().toCharArray();
		int sum = 0;
		Arrays.sort(c_arr);
		for(char c:c_arr){
			sum += c - '0';
		}
		if(sum%3 != 0 || c_arr[0] != '0'){
			System.out.println(-1);
		}else{
			StringBuilder sb = new StringBuilder(new String(c_arr));
			System.out.println(sb.reverse());
		}
	}
}
