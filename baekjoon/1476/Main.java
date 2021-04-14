import java.util.*;
import java.io.*;

public class Main{
	static int E;
	static int S;
	static int M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int ret = 1;
		while(!(E == 1 && S == 1 && M == 1)){
			E--;
			S--;
			M--;
			if(E==0)E = 15;
			if(S==0)S = 28;
			if(M==0)M = 19;
			ret++;
		}
		System.out.println(ret);
	}
}
