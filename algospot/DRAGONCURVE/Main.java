import java.util.*;
import java.io.*;

public class Main{
	static int n,p,l;
	static long[] cnt;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = new long[51];
		cnt[0] = 1;
		for(int i = 1;i<=50;i++){
			cnt[i] = 2*cnt[i-1]+2;
		}
		sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		while(TC>0){
			TC--;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			for(int i = 0;i<l;i++){
				sb.append(curve("FX",n,p-1+i));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static char curve(String s,int gen,int skip){
		if(gen == 0){
			return s.charAt(skip);
		}
		for(char c:s.toCharArray()){
			if(c == 'X' || c == 'Y'){
				if(skip >= cnt[gen]){
					skip -= cnt[gen];
				}else if(c == 'X'){
					return curve("X+YF",gen-1,skip);
				}else{
					return curve("FX-Y",gen-1,skip);
				}
			}else if(skip>0){
				skip--;
			}else{
				return c;
			}
		}
		return '!';
	}
}
