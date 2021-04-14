import java.util.*;
import java.io.*;

public class Main{
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int r = 0;r<R;r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 0;c<C;c++){
				map[r][c] = Integer.parseInt(st.nextToken());	
			}
		}
		System.out.println(makePath(R,C));
	}
	static String makePath(int r,int c){
		StringBuilder sb = new StringBuilder();
		if(r%2 == 1){
			for(int y = 0;y<r/2;y++){
				for(int x = 0;x<c-1;x++){
					sb.append('R');
				}
				sb.append('D');
				for(int x = 0;x<c-1;x++){
					sb.append('L');
				}
				sb.append('D');
			}
			for(int x = 0;x<c-1;x++){
				sb.append('R');
			}
		}else if(c%2 == 1){
			for(int x = 0;x<c/2;x++){
				for(int y = 0;y<r-1;y++){
					sb.append('D');
				}
				sb.append('R');
				for(int y = 0;y<r-1;y++){
					sb.append('U');
				}
				sb.append('R');
			}
			for(int y = 0;y<r-1;y++){
				sb.append('D');
			}
		}else{
			int min = Integer.MAX_VALUE;
			int miny = 0;
			int minx = 0;
			for(int y = 0;y<r;y++){
				for(int x = (y+1)%2;x<c;x+=2){
					if(min > map[y][x]){
						min = map[y][x];
						miny = y;
						minx = x;
					}
				}
			}
			for(int y = 0;y<miny/2;y++){
				for(int x = 0;x<c-1;x++){
					sb.append('R');
				}
				sb.append('D');
				for(int x = 0;x<c-1;x++){
					sb.append('L');
				}
				sb.append('D');
			}
			for(int x = 0;x<minx/2;x++){
				sb.append('D');
				sb.append('R');
				sb.append('U');
				sb.append('R');
			}
			
			if(minx%2 == 0){
				sb.append('R');
				sb.append('D');
			}else{
				sb.append('D');
				sb.append('R');
			}
			for(int x = 0;x<(c-1 - minx)/2;x++){
				sb.append('R');
				sb.append('U');
				sb.append('R');
				sb.append('D');
			}
			for(int y = 0;y<(r-1 - miny)/2;y++){
				sb.append('D');
				for(int x = 0;x<c-1;x++){
					sb.append('L');
				}
				sb.append('D');
				for(int x = 0;x<c-1;x++){
					sb.append('R');
				}
			}
		}
		return sb.toString();
	}
}
