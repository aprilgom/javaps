import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] ls = new int[n];
			for(int j = 0;j<n;j++){
				ls[j] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			for(int x = 0;x<n-1;x++){
				for(int y = x+1;y<n;y++){
					sum += gcd(ls[x],ls[y]);
				}
			}
			System.out.println(sum);
		}
	}
	static int gcd(int a,int b){
		if(b>a){
			return gcd(b,a);
		}
		int r = a%b;
		if(r == 0){
			return b;
		}
		return gcd(b,r);
	}
}
