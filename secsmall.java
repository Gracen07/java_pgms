import java.io.*;
import java.util.*;

class secsmall
{
	public static void main (String args[])
	{
		int n, a[],x,c=0;
		Scanner s =new Scanner(System.in);
		try
		{
			System.out.println("Enter the size:");
			n=s.nextInt();
			a=new int[n];
			System.out.println("Enter the elements:");
			for(int i=0;i<n;i++)
			{
				a[i]=s.nextInt();
			}
			int temp;
        		for (int i = 0; i < n; i++) {
        		    for (int j = i + 1; j < n; j++) {
                		if (a[i] > a[j]) {
                		    temp = a[i];
                		    a[i] = a[j];
                		    a[j] = temp;
                		}
			    }
			}
			System.out.println("The second smallest element is "+ a[1]);
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
	}
}