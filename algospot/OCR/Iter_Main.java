import java.util.*;
import java.io.*;

public class Main{
	static int m,q;
	static Map<String,Integer> w_indexes;
	static String[] idx_to_word;
	static double[] B;
	static double[][] T,M;

	static int[] seq;
	static double[][] p_map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());

		w_indexes = new HashMap<>();
		idx_to_word = new String[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++){
			String s = st.nextToken();
			idx_to_word[i] = s;
			w_indexes.put(s,i);
		}

		B = new double[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<m;i++){
			B[i] = Double.parseDouble(st.nextToken());
		}

		T = new double[m][m];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++){
				T[i][j] = Double.parseDouble(st.nextToken());
			}
		}

		M = new double[m][m];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<m;j++){
				M[i][j] = Double.parseDouble(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < q;i++){
			st = new StringTokenizer(br.readLine());
			int seq_n = Integer.parseInt(st.nextToken());
			seq = new int[seq_n];
			p_map = new double[seq_n][m];
			for(int j = 0;j<seq_n;j++){
				String s = st.nextToken();
				seq[j] = w_indexes.get(s);
			}
			for(int j = 0;j<seq_n;j++){
				int word = seq[j];
			}
			for(int di = 0;di<m;di++){
				for(int si = 0;si<m;si++){
					p_map[0][di] += B[di] * M[di][si];
				}
			}
			for(int sqi = 0;sqi<seq_n-1;sqi++){
				double[] tmp = new double[m];
				for(int di = 0;di<m;di++){
					for(int si = 0;si<m;si++){
						tmp[di] += p_map[sqi][si] * T[si][di];
					}
				}
				for(int di = 0;di<m;di++){
					for(int si = 0;si<m;si++){
						p_map[sqi+1][di] += tmp[si] * M[si][di];
					}
				}
			}
			List<Integer> ret = new ArrayList<>();
			for(int sqi = 0;sqi<seq_n;sqi++){
				int idx = 0;
				for(int mi = 0;mi<m;mi++){
					if(p_map[sqi][mi] > p_map[sqi][idx]){
						idx = mi;
					}
				}
				ret.add(idx);
			}
			for(int idx:ret){
				sb.append(idx_to_word[idx])
					.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	static void print(){
		for(int i = 0;i<seq.length;i++){
			for(int j = 0;j<m;j++){
				System.out.print(p_map[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
