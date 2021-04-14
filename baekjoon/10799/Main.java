import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int cnt = 0;
		int ans = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == '('){
				if(s.charAt(i+1)==')'){
					ans += cnt;
				}
				cnt++;
			}else{
				cnt--;
				if(s.charAt(i-1)!='('){
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
