package line_point;

import java.io.IOException;
import java.util.Scanner;



public class Cluster {
	void cluster()
	{
		 Point line1 = new Point();
		 line1.getdata();
		 Point line2 = new Point();
		 line2.getdata();
		 
		int size = 5;
	    int [] input = new int[size];
		for(int i = 0 ; i< size-1; i++)
		{
			int x;
			Scanner user_input1 = new Scanner(System.in);
			System.out.println("enter x=");
		     x = user_input1.nextInt();	
			 input[i] = x;	
				 
			 int y ;	 
			 System.out.println("enter y=");
			 user_input1 = new Scanner (System.in); 
			 y = user_input1.nextInt();	 
			 input[i+1] = y;
				
			 Utility u1 = new Utility();
			 u1.position(x, y);
			 
			 Utility u2 = new Utility(); 
			 u2.position(x,y);
				 
			 String variable1 = u1.position(x, y);
			 String variable2 = u2.position(x, y); 	
			 
			 if(  variable1.equals("up")&& variable2.equals("up"))
			 {
				 System.out.println("quadrant 1 with x coordinate = "+input[i]);
				 System.out.println("quadrant 1 with y coordinate = "+input[i+1]);
				
			 }else
			 if(variable1.equals("down")&& variable2.equals("up"))
			 {
				 System.out.println("quadrant 2 with x coordinate = "+input[i]);
				 System.out.println("quadrant 2 with y coordinate = "+input[i+1]);
			 }else
			 if(variable1.equals("down")&& variable2.equals("down"))
			 {
				 System.out.println("quadrant 3 with x coordinate = "+input[i]);
				 System.out.println("quadrant 3 with y coordinate = "+input[i+1]); 
			 }else
			 if(variable1.equals("up")&& variable2.equals("down"))
			 {
				 System.out.println("quadrant 4 with x coordinate = "+input[i]);
				 System.out.println("quadrant 4 with y coordinate = "+input[i+1]);
			 }
				
				
	 }
        
}		
				  
	 public static void main (String[] args) throws IOException
	 {  
		  
		  
		  Cluster quad = new Cluster();
		  quad.cluster();
	 }			   
					 
}					 


