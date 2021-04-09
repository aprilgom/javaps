import java.util.*;
import java.io.*;

public class Main{
	static int[][] map;
	static int N;
	static boolean[][] searched;
	static int probe(int x,int y){
		if(x<0 || y<0 || x>=N || y>=N){
			return 0;
		}
		if(map[x][y] == 0){
			return 0;
		}
		if(searched[x][y]){
			return 0;
		}
		searched[x][y] = true;
		int ret = 1;
		ret += probe(x+1,y);
		ret += probe(x-1,y);
		ret += probe(x,y+1);
		ret += probe(x,y-1);
		return ret;
	}
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		searched = new boolean[N][N];
		for(int i = 0;i<N;i++){
			map[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(x->Integer.parseInt(x))
				.toArray();
		}
		int count = 0;
		List<Integer> ret = new ArrayList<>();
		for(int x = 0;x<N;x++){
			for(int y = 0;y<N;y++){
				int h_n = probe(x,y);
				if(h_n > 0){
					ret.add(h_n);
				}
			}
		}
		Collections.sort(ret);
		System.out.println(ret.size());
		for(int i:ret){
			System.out.println(i);
		}
	}
}
