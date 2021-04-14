import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> cards = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N;i++){
			int card_idx = Integer.parseInt(st.nextToken());
			if(!cards.containsKey(card_idx)){
				cards.put(card_idx,1);
			}else{
				int card_n = cards.get(card_idx)+1;
				cards.put(card_idx,card_n);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<M;i++){
			int card_idx = Integer.parseInt(st.nextToken());
			if(!cards.containsKey(card_idx)){
				sb.append(0);
			}else{
				sb.append(cards.get(card_idx));
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
