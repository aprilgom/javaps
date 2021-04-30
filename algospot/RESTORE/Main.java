import java.util.*;
import java.io.*;

public class Main{
	static StringBuilder sb;
	static int k = 0;
	static List<String> pieces;
	static int[][] overlap;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			sb = new StringBuilder();
			k = Integer.parseInt(br.readLine());
			pieces = new ArrayList<>();
			for(int i = 0;i<k;i++){
				pieces.add(br.readLine());
			}

			/*
			 * 포함단어 제거.
			 *
			 * 왜 이것을 제거해야 하나?
			 * 최대한 겹치는 문자를 늘리는 것이 목적.
			 * 단어를 좌우로 붙여가며 해결하려 한다.
			 * 예: abcde / cdefg : abcdefg
			 * 하지만 좌우가 겹치는것이 아닌 포함되는 문자가 등장한다면 어떨까?
			 * 예: cadabra / dabr
			 * 최대한 겹치는 문자는 cadabra가 맞으나
			 * 좌우에 아무리 붙여봐야.. cadabradabr, dabrcadabra
			*/
			Collections.sort(pieces,(a,b)->b.length()-a.length());
			for(int i = 0;i<pieces.size();i++){
				String a = pieces.get(i);
				int j = i+1;
				while(j<pieces.size()){
					String b = pieces.get(j);
					if(a.contains(b)){
						pieces.remove(j);
					}else{
						j++;
					}
				}
			}

			k = pieces.size();
			dp = new int[k][1<<15];
			for(int i = 0;i<k;i++){
				Arrays.fill(dp[i],-1);
			}
			overlap = new int[k][k];
			for(int i = 0;i<k;i++){
				for(int j = 0;j<k;j++){
					if(i == j){
						continue;
					}
					overlap[i][j] = get_overlap(pieces.get(i),pieces.get(j));
				}
			}
			int last = 0;
			int res_max = 0;
			//overlap이 최대가 되게 하는 last 단어를 구합니다.
			for(int i = 0;i<k;i++){
				if(res_max < sol(i,1<<i)){
					res_max = sol(i,1<<i);
					last = i;
				}
			}
			sb.append(pieces.get(last));
			reconstruct(last,1<<last);
			System.out.println(sb);
		}
	}
	static int get_overlap(String a,String b){
		int a_idx = a.length()-1;
		int b_idx = 1;
		int ret = 0;
		int cnt = 1;
		while(a_idx >= 0 && b_idx < b.length()){
			String a_sub = a.substring(a_idx,a.length());
			String b_sub = b.substring(0,b_idx);
			if(a_sub.equals(b_sub)){
				ret = cnt;
			}
			cnt++;
			a_idx--;
			b_idx++;
		}
		return ret;
	}
	static int sol(int last,int used){
		if(used == (1<<k)-1){
			return 0;
		}
		if(dp[last][used] != -1){
			return dp[last][used];
		}
		int ret = 0;
		for(int i = 0;i<k;i++){
			if((used & (1<<i)) > 0){
				continue;
			}
			int cond = overlap[last][i] + sol(i,used|(1<<i));
			ret = Math.max(ret,cond);
		}
		dp[last][used] = ret;
		return ret;
	}
	static void reconstruct(int last,int used){
		if(used == (1<<k)-1){
			return;
		}
		for(int i = 0;i<k;i++){
			if((used & (1<<i)) > 0){
				continue;
			}
			int ifUsed = sol(i,used | (1<<i)) + overlap[last][i];
			if(sol(last,used) == ifUsed){
				String s = pieces.get(i);
				sb.append(s.substring(overlap[last][i],s.length()));
				//sb.append("/");
				//sb.append(overlap[last][i]);
				//sb.append("/");
				reconstruct(i,used|(1<<i));
				return;
			}
		}
	}
}
