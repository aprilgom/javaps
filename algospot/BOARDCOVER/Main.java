import java.util.*;
import java.io.*;

public class Main{
	static int W,H;
	static boolean[][] map;
	static int[][][] blocks = {
		{
			{0,0},
			{1,0},
			{1,-1}
		},
		{
			{0,0},
			{1,0},
			{0,1}

		},
		{
			{0,0},
			{1,0},
			{1,1}
		},
		{
			{0,0},
			{0,1},
			{1,1}
		}
	};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc < TC;tc++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new boolean[H][W];
			for(int h = 0;h<H;h++){
				String s = br.readLine();
				for(int w = 0;w<W;w++){
					if(s.charAt(w) == '#'){
						map[h][w] = true;
					}
				}
			}
			System.out.println(cover());
		}
	}
	static int cover(){
		boolean tmp = true;
		int sy = -1;
		int sx = -1;
		for(int y = 0;y<H;y++){
			for(int x = 0;x<W;x++){
				if(!map[y][x]){
					sy = y;
					sx = x;
					break;
				}
			}
			if(sy != -1){
				break;
			}
		}
		if(sy == -1){
			return 1;
		}
		int ret = 0;
		for(int[][] block:blocks){
			boolean conflict = false;
			for(int i = 0;i<3;i++){
				int ty = sy + block[i][0];
				int tx = sx + block[i][1];
				if(ty<0||ty>=H||tx<0||tx>=W){
					conflict = true;
					continue;
				}
				if(map[ty][tx]){
					conflict = true;
				}
			}
			if(conflict){
				continue;
			}
			for(int i = 0;i<3;i++){
				int ty = sy + block[i][0];
				int tx = sx + block[i][1];
				map[ty][tx] = true;
			}
			ret += cover();
			for(int i = 0;i<3;i++){
				int ty = sy + block[i][0];
				int tx = sx + block[i][1];
				map[ty][tx] = false;
			}
		}
		return ret;
	}
	static void print(){
		for(int h = 0;h<H;h++){
			for(int w = 0;w<W;w++){
				if(map[h][w]){
					System.out.print(1);
				}else{
					System.out.print(0);
				}
			}
				System.out.println();
		}
	}
}
