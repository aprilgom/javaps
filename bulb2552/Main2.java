 
import java.io.*;
import java.util.*;
import java.util.stream.*;
 
public class Main{
	static List<Integer> cache;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] s = br.readLine().split(" ");
        int[] conn = Arrays.stream(s)
            .mapToInt(i->Integer.parseInt(i))
            .toArray();
        int n = conn.length;
		cache = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());
        List<Integer> joints = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            for(int j = i-1;j>=0;j--){
                if(conn[i] < conn[j]){
                    joints.add(1<<n-i-1 | 1<<n-j-1);
                }   
            }
        }
        List<Integer> is = new ArrayList<>();
        int prev = 0;
        int ret = -1;
        int counter = 0;
		cache.add(0);
        int bulb;
        for(int i = 0;i<1<<(n/2);i++){
            bulb = i;
            for(int joint:joints){
                if((i&joint) == joint){
                    bulb &= ~joint;
                }
            }
            if(prev<bulb){
                counter++;
				cache.add(bulb);
                prev = bulb;
            }
            if(counter == k-1){
                ret = bulb;
                break;
            }
        }
		if(ret != -1){
			System.out.println(ret);
			return;	
		}
        for(int i = 1;i<1<<(n/2);i++){
			for(int c:cache){
				int bi = (i<<(n/2))|c;
				bulb = (i<<(n/2))|c;
            	for(int joint:joints){
            	    if((bi&joint) == joint){
            	        bulb &= ~joint;
            	    }
            	}
            	if(prev<bulb){
					//System.out.println("blb"+Integer.toBinaryString(bulb));
            	    counter++;
            	    prev = bulb;
            	}
            	if(counter == k-1){
            	    ret = bulb;
            	    break;
            	}
			}
            if(counter == k-1){
                break;
            }
        }
        //System.out.println(Integer.toBinaryString(ret));
        System.out.println(ret);
    }
}
