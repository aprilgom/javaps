import java.util.*;
import java.io.*;

public class Main{
	static boolean[] broken;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		StringTokenizer st;
		if(M!=0){
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<M;i++){
				int idx = Integer.parseInt(st.nextToken());
				broken[idx] = true;
			}
		}
		int ret = Math.abs(N-100);
		for(int i = 0;i<1000000;i++){
			int j = i;
			boolean able = true;
			int len = 0;
			if(j == 0){
				if(broken[0]){
					able = false;
				}else{
					len = 1;
				}
			}
			while(j>0){
				int r = j%10;
				if(broken[r]){
					able = false;
					break;
				}
				j /= 10;
				len++;
			}
			if(able){
				ret = Math.min(ret,len + Math.abs(N-i));
			}
		}
		System.out.println(ret);
	}
}
