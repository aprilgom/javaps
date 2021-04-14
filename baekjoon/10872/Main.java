import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mul = 1;
		while(N>0){
			mul *= N;
			N--;
		}
		System.out.println(mul);
	}
}
