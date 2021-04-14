import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String[] s = br.readLine().split(" ");
		Integer[] ia = Arrays.stream(s)
			.mapToInt(i->Integer.parseInt(i))
			.boxed()
			.toArray(Integer[]::new);
		Integer mx = Arrays.stream(ia)
			.max((a,b)->Integer.compare(a,b))
			.orElse(0);
		Integer mn = Arrays.stream(ia)
			.min((a,b)->Integer.compare(a,b))
			.orElse(0);
		System.out.println(mn+ " " +mx );
	}
}
