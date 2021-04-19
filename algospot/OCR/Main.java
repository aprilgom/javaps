import java.util.*;
import java.io.*;

public class Main{
	static int m,q,seq_n;
	static Map<String,Integer> w_indexes;
	static String[] idx_to_word;
	static double[] B;
	static double[][] T,M;

	static int[] seq;
	static double[][] p_map;
	static int[][] max_words;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		w_indexes = new HashMap<>();
		idx_to_word = new String[m+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1;i<m+1;i++){
			String s = st.nextToken();
			idx_to_word[i] = s;
			w_indexes.put(s,i);
		}

		T = new double[m+1][m+1];
		for(int i = 0;i<m+1;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<m+1;j++){
				T[i][j] = Math.log(Double.parseDouble(st.nextToken()));
			}
		}

		M = new double[m+1][m+1];
		for(int i = 1;i<m+1;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 1;j<m+1;j++){
				M[i][j] = Math.log(Double.parseDouble(st.nextToken()));
			}
		}

		for(int qi = 0;qi < q;qi++){
			st = new StringTokenizer(br.readLine());
			seq_n = Integer.parseInt(st.nextToken());
			seq = new int[seq_n];
			p_map = new double[seq_n][m+1];
			max_words = new int[seq_n][m+1];
			for(int i = 0;i<seq_n;i++){
				Arrays.fill(p_map[i],1);
			}
			for(int i = 0;i<seq_n;i++){
				String s = st.nextToken();
				seq[i] = w_indexes.get(s);
			}
			sol(0,0);
			int next = 0;
			for(int i = 0;i<seq_n;i++){
				next = max_words[i][next];
				sb.append(idx_to_word[next])
					.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	static double sol(int idx,int word){
		if(idx==seq_n){
			return 0;
		}
		if(p_map[idx][word] != 1){
			return p_map[idx][word];
		}
		double ret = Double.NEGATIVE_INFINITY;
		for(int i = 1;i<=m;i++){
			double prob = sol(idx+1,i)+ M[i][seq[idx]] + T[word][i];
			if(prob > ret){
				ret = prob;
				max_words[idx][word] = i;
			}
		}
		p_map[idx][word] = ret;
		return ret;
	}
}
