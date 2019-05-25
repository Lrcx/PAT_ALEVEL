package higherlevel;

import java.util.*;
import java.math.RoundingMode;
import java.text.*;

public class I002 {
	public static void main(String[] args) {
		I002 pat=new I002();
		Scanner s=new Scanner(System.in);
		String line1=s.nextLine();
		String line2=s.nextLine();
		String str1[]=line1.split(" ");
		String str2[]=line2.split(" ");
		double a[]=new double[str1.length];
		double b[]=new double[str2.length];
		for(int i=0;i<a.length;i++) {
			a[i]=Double.valueOf(str1[i]);
		}
		for(int i=0;i<b.length;i++) {
			b[i]=Double.valueOf(str2[i]);
		}
		pat.sum(a, b);
	}
	public void sum(double a[],double b[]) {
		ArrayList<String> list=new ArrayList<String>();
		DecimalFormat df=new DecimalFormat("0.#");
		int m=(int)a[0];
		int n=(int)b[0];
		double sum=0;
		for(int i=1;i<2*m;i+=2) {
			boolean flag=false;
			for(int j=1;j<2*n;j+=2) {
				if(a[i]==b[j]) {
					sum=a[i+1]+b[j+1];
					list.add(a[i]+" "+sum);
					flag=true;
					break;
				}
			}
			if(flag==false) {
				list.add(a[i]+" "+a[i+1]);
			}
		}
		for(int i=1;i<2*n;i+=2) {
			boolean flag=false;
			for(int j=1;j<2*m;j+=2) {
				if(b[i]==a[j]) {
					flag=true;
					break;
				}
			}
			if(flag==false) {
				list.add(b[i]+" "+b[i+1]);
			}
		}
		String str="";
		for(int i=0;i<list.size();i++) {
			str=str+list.get(i)+" ";
		}
		String z[]=str.split(" ");
		double d[]=new double[z.length];
		System.out.print(d.length/2);
		for(int i=0;i<d.length;i++) {
			d[i]=Double.parseDouble(z[i]);
		}
		if(d.length==2) {
			System.out.print(" "+df.format(point(d[0]))+" "+df.format(point(d[1])));
		}else if(d.length==4) {
			if(d[0]<d[2]) {
				System.out.print(" "+df.format(point(d[2]))+" "+df.format(point(d[3]))+
						" "+df.format(point(d[0]))+" "+df.format(point(d[1])));
			}else {
				System.out.print(" "+df.format(point(d[0]))+" "+df.format(point(d[1]))+
						" "+df.format(point(d[2]))+" "+df.format(point(d[3])));
			}
		}else {
			double temp=0;
			for(int i=0;i<d.length-2;i+=2) {
				for(int j=i;j<d.length;j+=2) {
					if(d[i]<d[j]) {
						temp=d[i];
						d[i]=d[j];
						d[j]=temp;
						temp=d[i+1];
						d[i+1]=d[j+1];
						d[j+1]=temp;
					}
				}
			}
//			System.out.println(Arrays.toString(d));
			for(int i=0;i<d.length;i++) {
				System.out.print(" "+df.format(point(d[i])));
			}
		}
	}
	public double point(double a) {
		
		double b=((double)Math.round(a*10))/10;
		
		return b;
	}
}
