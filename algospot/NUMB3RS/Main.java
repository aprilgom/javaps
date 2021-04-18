import java.util.*;
import java.io.*;

public class Main{
	static int[][] map;
	static double[][] prob;
	static int n,d,p,t;
	static int[] q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			prob = new double[2][n];
			for(int i = 0;i<n;i++){
				st = new StringTokenizer(br.readLine());
				for(int j = 0;j<n;j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			t = Integer.parseInt(br.readLine());
			q = new int[t];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<t;i++){
				q[i] = Integer.parseInt(st.nextToken());
			}
			prob[0][p] = 1;
			for(int day = 0;day<d;day++){
				prob[(day+1)%2] = prob[day%2].clone();
				for(int idx = 0;idx<n;idx++){
					sneak(idx,day);
				}
			}
			for(int i:q){
				System.out.print(String.format("%.8f",prob[d%2][i]));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	static void sneak(int idx,int day){
		if(day == d){
			return;
		}
		double p_prob = prob[day%2][idx];
		int conn_n = 0;
		for(int i = 0;i<n;i++){
			if(map[i][idx] == 1){
				conn_n++;
			}
		}
		//주변 마을로 도망쳤을 확률.
		//기존에 가지고있던 확률을 주변에 뿌려준다.
		prob[(day+1)%2][idx] -= p_prob;
		double now_prob = p_prob/conn_n;
		for(int i = 0;i<n;i++){
			if(map[i][idx] == 1){
				prob[(day+1)%2][i] += now_prob;		
				//sneak(i,day+1,now_prob);
			}
		}
	}
}
