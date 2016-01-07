package asignment1;

/*
 * three functions
 * 1) place queens on safe coloumns starting from left(no need to check right)
 * 2) adjusting row positions to place safely and calling above function recursively along with this function to place all queens
 * 3) function calling all these functions and to print the output
 */

public class queen {
	public int[][] chess ;
	
	public queen()
	{
		chess = new int[8][8];
		for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
            	chess[i][j]= 0;
            }
	 
	 }
	}

	void printsol(int chess[][])
	{
		for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
                System.out.print(" " + chess[i][j]
                                 + " ");
            System.out.println();
        }
	}
	
	// placing queen on safe coloumns, therefore only considering left side of attacking queen
	boolean issafecol(int chess[][], int row,int col)
	{   int i,j;
		for(i=0; i <= col;i++)// left side rows
		
			 if (chess[row][i] == 1)
	                return false;
			
			for (i=row, j=col; i>=0 && j>=0; i--, j--)//upper diagonal
	            if (chess[i][j] == 1)
	                return false;
	 
	        
	        for (i=row, j=col; j>=0 && i<8; i++, j--)// lower diagonal
	            if (chess[i][j] == 1)
	                return false;
	 
		return true;
	}
	
	boolean placingrow (int chess[][],int col)
	{	 
		
		
		if (col >= 8)
        return true;
		
		
		for(int i=0; i<8 ; i++)
		{
			if(issafecol(chess,i,col))
			{
				chess[i][col]=1; // make that position 1 and increment col
				if(placingrow(chess,col+1)==true)
					{
					return true;
					
					}
				chess[i][col]=0;//if that sol was not true again make it zero
			}	
		}	
		return false;		
			
	}
	
	boolean solving ()
	{      
		if(placingrow(chess,0)==true)
		 {
			
			 printsol(chess);
		 }
		 return true;
	}
	
	 public static void main(String args[])
	    {
	       queen q = new queen();
	       q.solving();
	    }
	       
}


