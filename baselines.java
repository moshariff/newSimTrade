package drawline;
import java.util.*;
/**
 * 
 * @author mosharif
 * class denotes the lines
 */
public class baselines {
	private int x1,x2,y1,y2;
	int a,b,c;
	/**
	 * @category constructor to accept the lines
	 */
	baselines()
	{
		Scanner in=new Scanner(System.in);
		System.out.println("enter the two points of the line");
		x1=in.nextInt();
		y1=in.nextInt();
		x2=in.nextInt();
		y2=in.nextInt();
	}
	/**
	 * function to calculate the equation of the line
	 */
	public void createlines()
	{
		 a=y1-y2;
	     b=x2-x1;
	     c=(((x1-x2)*(y1)) + (y2-y1)*(x1));
	     System.out.println("a , b ,c:" +a +" " +b +" " +c);
	}
}
/**
 * 
 * @author mosharif
 *class denoting the file or point
 */
class fileop
{Scanner in=new Scanner(System.in);
	private int x,y,eq1,eq2,cr1,cr2;
	/**
	 * constructor to create the file 
	 */
	fileop()
	{
		System.out.println("enter the file loc");
		x=in.nextInt();
		y=in.nextInt();
	}
	/**
	 * function to check the position of the point relative to the two lines @param ob1, @param ob2
	 * @param ob1
	 * @param ob2
	 */
	public void checkcond(baselines ob1, baselines ob2)
	{
		
		eq1=(ob1.a*x)+(ob1.b*y)+ob1.c;
		eq2=(ob2.a*x)+(ob2.b*y)+ob2.c;
		System.out.println("eq1: "+ eq1 +" " + "eq2: " +eq2);
		
		if ((eq1>0 && ob1.b>0) ||(eq1<0 && ob1.b<0))
				cr1=1;
			else cr1=0;
			
			if((eq2>0 && ob2.b>0) || (eq2<0 && ob2.b<0))
				cr2=1;
			else                                                     
				cr2=0;
			System.out.println("cr1: "+ cr1 +" " + "cr2: " +cr2);
		}
	/**
	 * assign quadrants based on the condition results of {@link checkcond}
	 * and retuen the quad value
	 * @return
	 */
	public int assignquad()
	{
		System.out.println("cr1: "+ cr1 +" " + "cr2: " +cr2);
		if (cr1==1 && cr2==1)
			return 4;
		if(cr1==1 && cr2==0)
			return 1;
		if(cr1==0 && cr2==0)
			return 2;
		else
			return 3;
	}


	public static void main (String args[])
	{
		Scanner in=new Scanner(System.in);
		baselines ob1=new baselines();
		baselines ob2=new baselines();
		ob1.createlines();
		ob2.createlines();
		/**
		 * create a hashmap with key as the file name and value as the quadrant number
		 */
		HashMap<String, Integer> hm=new HashMap<String, Integer>();
		
	for(;;)
	{
		System.out.println("enter choice 1.insert file 2.display 3.exit");
		int ch=in.nextInt();
		switch (ch)
		{
		case 1: System.out.println("enter the file name");
				String name=in.next();
				fileop f=new fileop();
				f.checkcond(ob1,ob2);
				int value=f.assignquad();
				hm.put(name, value);
				break;
		case 2:
			 Set set = hm.entrySet();
			 Iterator i = set.iterator();
			 while(i.hasNext()) {
		         Map.Entry me = (Map.Entry)i.next();
		         System.out.print(me.getKey() + ": ");
		         System.out.println(me.getValue());
		      }
			 break;
		case 3:
			System.exit(0);
		default :	System.exit(0);
		}
	}
}
}