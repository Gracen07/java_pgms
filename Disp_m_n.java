import java.io.*;
class Disp_m_n
{
	public static void main(String args[])
	{
		DataInputStream din;
		din=new DataInputStream(System.in);
		int m,n;
		try
		{
			System.out.println("Enter two numbers to display required series");
			m=Integer.parseInt(din.readLine());
			n=Integer.parseInt(din.readLine());
			System.out.println("The series of numbers from "+m+" to "+n+" is:");
			while(m!=n)
			{
				System.out.println(m);
				if(m<n)
					m++;
				else
					m--;
			}
			System.out.println(m);	
		}
		catch(Exception e)
		{
			System.out.println("Error:"+e);
		}
	}
}