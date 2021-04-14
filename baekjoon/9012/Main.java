import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0;i<T;i++){
			String s = br.readLine();
			int corr = 0;
			for(int j = 0;j<s.length();j++){
				if(s.charAt(j)=='('){
					corr++;
				}else{
					corr--;
				}
				if(corr<0){
					break;
				}
			}
			if(corr != 0){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}
}
