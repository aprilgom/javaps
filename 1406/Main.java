import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> edit = new LinkedList<>();
		Integer c = 0;
		while((c = br.read()) != '\n'){
			edit.add(c);
		}
		ListIterator<Integer> li = edit.listIterator(edit.size());
		int M = Integer.parseInt(br.readLine());
		for(int i = 0;i<M;i++){
			switch(br.read()){
				case 'L':
					if(li.hasPrevious()){
						li.previous();
					}
					break;
				case 'D':
					if(li.hasNext()){
						li.next();
					}
					break;
				case 'B':
					if(li.hasPrevious()){
						li.previous();
						li.remove();
					}
					break;
				case 'P':
					br.read();
					li.add(br.read());
					break;
			}
			br.read();
		}
		for(int i:edit){
			bw.write((char)i);
		}
		bw.flush();
		bw.close();
	}
}
