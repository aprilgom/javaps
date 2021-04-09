import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ret = 1;
		if(N>=2){
			ret = 1 + (M-1)/2;
		}
		if(N>=3){
			ret = M;
		}
		if(ret>=4){
			if(M<6 || N<3){
				ret = 4;
			}else{
				ret -= 2;
			}
		}
		System.out.println(ret);
	}
}
