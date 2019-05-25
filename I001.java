package higherlevel;

import java.util.*;

public class I001 {
	public static void main(String[] args) {
		I001 pat=new I001();
		Scanner s=new Scanner(System.in);
		long a=s.nextLong();
		long b=s.nextLong();
		pat.format(a, b);
	}
	public void format(long a,long b) {
		ArrayList list=new ArrayList();
		long c=a+b;
		int t=0;
		if(c<0) {
			c=-c;
			String s=String.valueOf(c);
			char m[]=s.toCharArray();
			for(int i=m.length-1;i>0;i--) {
				list.add(m[i]);
				t++;
				if(t%3==0) {
					list.add(",");
				}
			}
			list.add(m[0]);
			System.out.print("-");
			for(int i=list.size()-1;i>=0;i--) {
				System.out.print(list.get(i));
			}
		}else {
			String s=String.valueOf(c);
			char m[]=s.toCharArray();
			for(int i=m.length-1;i>0;i--) {
				list.add(m[i]);
				t++;
				if(t%3==0) {
					list.add(",");
				}
			}
			list.add(m[0]);
			for(int i=list.size()-1;i>=0;i--) {
				System.out.print(list.get(i));
			}
		}
	}
}
