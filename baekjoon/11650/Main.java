import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Dot[] dots = new Dot[n];
		for(int i = 0;i<n;i++){
			String[] s = br.readLine().split(" ");
			dots[i] = new Dot();
			dots[i].x = Integer.parseInt(s[0]);
			dots[i].y = Integer.parseInt(s[1]);
		}
		int[] s_idx = IntStream.range(0,n)
			.boxed()
			.sorted((a,b)->{
				if(dots[a].x == dots[b].x){
					return Integer.compare(dots[a].y, dots[b].y);
				}
				return Integer.compare(dots[a].x, dots[b].x);
			})
			.mapToInt(i->i)
			.toArray();
		for(int i:s_idx){
			System.out.print(dots[i].x);
			System.out.print(" ");
			System.out.print(dots[i].y);
			System.out.print("\n");
		}
	}
}

class Dot{
	public int x;
	public int y;
}
