import java.util.*;
import java.io.*;

public class Main{
	static int[] S;
	static List<Integer> lotto;
	static boolean[] used;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lotto = new ArrayList<>();
		used = new boolean[50];
		sb = new StringBuilder();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0){
				break;
			}
			S = new int[k];
			for(int i = 0;i<k;i++){
				S[i] = Integer.parseInt(st.nextToken()); 
			}
			pickLotto(0,0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void pickLotto(int idx, int cnt){
		if(cnt == 6){
			for(int i:lotto){
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = idx;i<S.length;i++){
			if(used[i]){
				continue;
			}
			lotto.add(S[i]);
			used[i] = true;
			pickLotto(i,cnt+1);
			lotto.remove(lotto.size()-1);
			used[i] = false;
		}
	}
}
