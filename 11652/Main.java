import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Long,Integer> cnt = new HashMap<>();
		int max= 1;
		long max_num = Long.parseLong(br.readLine());
		cnt.put(max_num,1);
		for(int i = 1;i<N;i++){
			long num = Long.parseLong(br.readLine());
			int tmp;
			if(!cnt.containsKey(num)){
				tmp = 1;
			}else{
				tmp = cnt.get(num)+1;
			}
			cnt.put(num,tmp);

			if(tmp>=max){
				if(!(max_num < num && tmp == max)){
					max_num = num;
				}
				max = tmp;
			}
		}
		System.out.println(max_num);
	}
}
