import java.util.*;
import java.io.*;

public class Main{
	static String pattern;
	static String str;
	static int[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<TC; tc++){
			pattern = br.readLine();
			int N = Integer.parseInt(br.readLine());
			List<String> ret = new ArrayList<>();
			for(int n = 0;n<N;n++){
				str = br.readLine();
				visited = new int[pattern.length()+1][str.length()+1];
				if(match(0,0) == 1){
					ret.add(str);
				}
			}
			Collections.sort(ret);
			for(String s:ret){
				System.out.println(s);
			}
		}
	}
	static int match(int p_idx,int s_idx){
		if(visited[p_idx][s_idx] != 0){
			return visited[p_idx][s_idx];
		}
		if(
			p_idx < pattern.length() && 
			s_idx < str.length() && 
			(
				pattern.charAt(p_idx) == str.charAt(s_idx) || 
				pattern.charAt(p_idx) == '?'
			)
		){
			visited[p_idx][s_idx] = match(p_idx+1,s_idx+1);
			return visited[p_idx][s_idx];
		}
		if(p_idx == pattern.length()){
			if(s_idx == str.length()){
				return 1;
			}else{
				return -1;
			}
		}
		if(pattern.charAt(p_idx) == '*'){
			if(
				match(p_idx+1,s_idx) == 1||
				(s_idx<str.length() && match(p_idx,s_idx+1) == 1)
			){
				visited[p_idx][s_idx] = 1;
				return 1;	
			}
		}
		return -1;
	}
}
