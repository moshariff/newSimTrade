package coordinateSystem;

import java.util.Scanner;


public class PointLocation
{
		
	public static void main(String[] args)
	{ 
		
		FindTheQuadrant loc = new FindTheQuadrant();
		loc.location();
		
	}
}



class coordinateMembers
{
	  Scanner in = new Scanner(System.in);
	protected double[] x=new double[3];
	protected double[] y=new double[3];
	protected double m;
	protected double n;
	protected double a;
	protected double b;
	protected double c;
	protected String Location1;
	protected String Location2;
}

 class coordinateDisplay 
{
private double x;
private double y;

public coordinateDisplay(double x, double y)
{
    this.x=x;
    this.y=y;
}
public String toString()
{
    return "("+ this.x+","+this.y+")";
}
}
 
 
 
 class LocationOfPoint extends coordinateMembers
 {
	 
	
	public  LocationOfPoint()
	{
		for(int i =0 ; i<2; i++)
		{	System.out.println("Enter the coordinates for x"+(i+1)+"y"+(i+1));
			x[i]=in.nextDouble();
			y[i]=in.nextDouble();
		}
		
		for(int i =0 ; i<2; i++)
		{
		
			coordinateDisplay point= new coordinateDisplay(x[i], y[i]);
         System.out.println("(x["+(i+1)+"],y["+(i+1)+"])= "+" "+ point.toString());
         
		} 
		
	}
 
		public void calcVariables()
		{
			a=y[0]-y[1];
			b=x[1]-x[0];
			c= ((x[0]-x[1])*y[0]) + ((y[1]-y[0])*x[0]);
			System.out.println("a/b/c = " + a +"/" +b + "/"+c);
		}
		
		
		 public void newPoint()
		 {
		 System.out.println("Enter the coordinate to be classified");
		 m=in.nextDouble();
		 n=in.nextDouble();
		 coordinateDisplay point= new coordinateDisplay(m, n);
	     System.out.println("(m,n)"+ point.toString());
		 }
	
	 
	 public String condition()
	 {
		
		 if (((((a*m)+(b*n)+c)>0) && (b>0)) || (((a*m)+(b*n)+c<0) && (b<0)))
			{
			return "up";
			}
			else 
				return "down";
			
	 
	 
 }
 }

 
 class FindTheQuadrant extends coordinateMembers 
	{
	 
	 
	public FindTheQuadrant()
	{
		  System.out.println("Enter the coordinates for Line1");
		  LocationOfPoint Line1 = new LocationOfPoint();
			Line1.calcVariables();
			Line1.newPoint();
			Location1= Line1.condition(); 
			System.out.println(Location1);
			
			System.out.println("Enter the coordinates for Line2");
			LocationOfPoint Line2 = new LocationOfPoint();
			Line2.calcVariables();
			Line2.newPoint();
			 Location2 = Line2.condition(); 
			System.out.println(Location2);
	}
	 public void location()
	 {
		 if(Location1.equals("up") && Location2.equals("up"))
			{
				System.out.println("Quadrant 1");
			}

			else if(Location1.equals("up") && Location2.equals("down"))
			{
				System.out.println("Quadrant 2");
			}

			else if(Location1.equals("down") && Location2.equals("up"))
			{
				System.out.println("Quadrant 3");
			}

			else if(Location1.equals("down") && Location2.equals("down"))
			{
				System.out.println("Quadrant 4");
			}
			
	 }
	}
 
 
 
 