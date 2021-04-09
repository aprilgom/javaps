import java.util.*;
import java.io.*;

public class Main{
	static char[] cs;
	static boolean[] visited;
	static int L,C;
	static StringBuilder sb;
	static char[] vowels = {'a','e','i','o','u'};
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cs = new char[C];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<C;i++){
			cs[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(cs);
		sb = new StringBuilder();
		sol(0,0);
	}
	static void sol(int idx,int len){
		if(len == L){
			int vowel_n = 0;
			int cons_n = 0;
			for(char c:sb.toString().toCharArray()){
				boolean isVowel = false;
				for(char vowel:vowels){
					if(c == vowel){
						isVowel = true;
					}
				}
				if(isVowel){
					vowel_n++;
				}else{
					cons_n++;
				}
			}
			if(vowel_n>=1 && cons_n>=2){
				System.out.println(sb);
			}
			return;
		}
		for(int i = idx;i<C;i++){
			if(visited[i]){
				continue;
			}
			visited[i] = true;
			sb.append(cs[i]);
			sol(i,len+1);
			visited[i] = false;
			sb.deleteCharAt(sb.length()-1);
		}
	}
}
