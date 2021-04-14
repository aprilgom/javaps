import java.util.*;
import java.io.*;

public class Main{
	static int[] fences;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			int n = Integer.parseInt(br.readLine());
			fences = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<n;i++){
				fences[i] = Integer.parseInt(st.nextToken());
			}
			System.out.println(getMaxFence(0,n-1));
		}
	}
	static int getMaxFence(int l,int r){
		if(r == l){
			return fences[l];
		}
		int mid = (l+r)/2;
		int l_max = getMaxFence(l,mid);
		int r_max = getMaxFence(mid+1,r);
		int ret = Math.max(l_max,r_max);
		
		int l_mid = mid;
		int r_mid = mid+1;
		int mid_h = Math.min(fences[l_mid],fences[r_mid]);
		ret = Math.max(ret,2*mid_h);

		while(l < l_mid || r_mid < r){
			if(r_mid < r && (l_mid == l || fences[r_mid+1] > fences[l_mid-1])){
				r_mid++;
				mid_h = Math.min(mid_h,fences[r_mid]);
			}else{
				l_mid--;
				mid_h = Math.min(mid_h,fences[l_mid]);
			}
			ret = Math.max(ret,mid_h * (r_mid - l_mid +1));
		}
		return ret;
	}
}
