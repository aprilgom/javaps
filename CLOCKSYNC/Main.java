import java.util.*;
import java.io.*;

public class Main{
	static int[][] btns = {
		{0,1,2},
		{3,7,9,11},
		{4,10,14,15},
		{0,4,5,6,7},
		{6,7,8,10,12},
		{0,2,14,15},
		{3,14,15},
		{4,5,7,14,15},
		{1,2,3,4,5},
		{3,4,5,9,13}
	};
	static int[] clocks = new int[16];
	static int ret;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0;i<16;i++){
				clocks[i] = Integer.parseInt(st.nextToken());
			}
			ret = Integer.MAX_VALUE;
			sol(0,0);
			if(ret == Integer.MAX_VALUE){
				System.out.println(-1);
			}else{
				System.out.println(ret);
			}
		}
	}
	static void push(int idx){
		for(int clki:btns[idx]){
			clocks[clki] += 3;
			if(clocks[clki] > 12){
				clocks[clki] -= 12;
			}
		}
	}
	static void sol(int idx,int n){
		boolean all_twelve = true;
		for(int i = 0;i<16;i++){
			if(clocks[i] != 12){
				all_twelve = false;
				break;
			}
		}
		if(all_twelve){
			ret = Math.min(ret,n);
			return;
		}
		if(idx > 9){
			return;
		}
		for(int push_cnt = 0;push_cnt<4;push_cnt++){
			sol(idx+1,n+push_cnt);
			push(idx);
		}
	}
}
