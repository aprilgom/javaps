import java.util.*;
import java.io.*;

public class Main{
	static int cur;
	static String image;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<TC;tc++){
			cur = 0;
			image = br.readLine();
			System.out.println(flip(image));
		}
	}
	static String flip(String image){
		StringBuilder sb = new StringBuilder();
		char ch = image.charAt(cur);
		cur++;
		if(ch == 'x'){
			sb.append('x');
			String lu = flip(image);
			String ru = flip(image);
			String ld = flip(image);
			String rd = flip(image);
			sb.append(ld).append(rd).append(lu).append(ru);
		}else{
			sb.append(ch);
		}
		return sb.toString();
	}
}
