import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
	static long max_n = 0;
	static int usable = 0;
	static void dfs(int char_n,int start,int count){
		if(char_n<0){
			return;
		}
		for(int i = start;i<26;i++){
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] fl = br.readLine().split(" ");
		int K = Integer.parseInt(fl[1])-5;
		int ret = 0;
		List<String> wl = br.lines()
			.map(word->word.replaceAll("[antic]",""))
			.map(word->word.replaceAll("(.)(?=.*\\1)",""))
			.collect(Collectors.toList());
		br.close();
		var chars = wl.stream()
			.reduce((a,b)->a+b)
			.get()
			.replaceAll("(.)(?=.*\\1)","")
			.toCharArray();
		for(var c:chars){
			System.out.println(c-'a');
			usable |= 1<<(c-'a'-1);
		}
		System.out.println(Integer.toBinaryString(usable));
		

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Long.toString(max_n));
		bw.close();
	}
}
