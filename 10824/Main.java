import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long ab = Long.parseLong(s[0]+s[1]);
		long cd = Long.parseLong(s[2]+s[3]);
		System.out.println(ab+cd);
	}
}
