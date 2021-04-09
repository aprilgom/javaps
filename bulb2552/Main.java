import java.io.*;
import java.util.*;
import java.util.stream.*;
 
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] s = br.readLine().split(" ");
        int[] conn = Arrays.stream(s)
            .mapToInt(i->Integer.parseInt(i))
            .toArray();
        int N = conn.length;
        int K = Integer.parseInt(br.readLine());
        boolean[][] joints = new boolean[N][N];
		List<Integer> j_list = new ArrayList<>();
        for(int i = N-1;i>=0;i--){
            for(int j = i-1;j>=0;j--){
                if(conn[i] < conn[j]){
					joints[N-1-i][N-1-j] = true;
					joints[N-1-j][N-1-i] = true;
                    j_list.add(1<<N-i-1 | 1<<N-j-1);
				}   
            }
        }
		int[] dig = new int[N];
		dig[0] = 1;
		for(int i = 1;i<N;i++){
			int av = 1;
			for(int j = i-1;j>=0;j--){
				if(!joints[i][j]){
					av+=dig[j];
				}
			}
			dig[i] = av;
		}
		int ret = -1;
		int count = 1;
		int di = 0;
		while(count < K && di< N){
			count += dig[di];
			di++;
		}
		di--;
		count -= dig[di];
		if(di == N){
			System.out.println(ret);
			return;
		}
		int si = 0;
		while(count < K && si<di){
			if(!joints[di][si]){
				count+=dig[si];
			}
			si++;
		}
		si--;
		count -= dig[si];
		count++;
		if(count == K){
			ret = 1<<di;
			System.out.println(ret);
			return;
		}
		int prev = 0;
		for(int i = (si==0)?0:(1<<si);i<(1<<di);i++){
			int bulb = i|(1<<di);
			for(int jnt:j_list){
				if(((i|(1<<si))&jnt)==jnt){
					bulb &= ~jnt;
				}
			}
			if(prev<bulb){
				prev = bulb;
				count++;
			}
			if(count == K){
				ret = bulb;
				break;
			}
		}
		System.out.println(ret);
    }
}
