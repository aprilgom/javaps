import java.util.*;
import java.io.*;

public class Main{
	static boolean[] smaller;
	static boolean[] bigger;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			String a = br.readLine();
			String b = br.readLine();
			String smaller_s;
			String bigger_s;
			if(a.length() < b.length()){
				smaller_s = a;
				bigger_s = b;
			}else{
				smaller_s = b;
				bigger_s = a;
			}
			
			smaller = new boolean[smaller_s.length()];
			for(int i = 0;i<smaller_s.length();i++){
				if(c == 'F'){
					smaller[i] = true;
				}else{
					smaller[i] = false;
				}
			}
			bigger = new boolean[bigger_s.length()];
			for(int i = 0;i<bigger_s.length();i++){
				if(c == 'F'){
					bigger[i] = true;
				}else{
					bigger[i] = false;
				}
			}

		}
	}
}
