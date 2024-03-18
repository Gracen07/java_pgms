import java.io.*;
public class Complxnum 
{
    	public static void main(String[] args)
	{
        	Complex a, b, c;
        	System.out.println("FOR A ");
        	a = new Complex();
        	a.read();
        	b = new Complex();
        	System.out.println("FOR B ");
        	b.read();
        	a.disp(); 
		b.disp();
        	c = a.add(b);
		System.out.print("Sum: ");
        	c.disp();
		System.out.print("Product: ");
        	c=a.multi(b);
        	c.disp();
    	}
}
class Complex
{
	int real, imag;
	public void read()
	{
        	DataInputStream din = new DataInputStream(System.in);
        	try
		{
        		System.out.print("Enter real number: ");
            		real = Integer.parseInt(din.readLine());
            		System.out.print("Enter Imag number: ");
            		imag = Integer.parseInt(din.readLine());
        	} 
		catch (Exception e){
            	System.out.println("Error " + e);
       		}
    	}
	public void disp()
	{
        System.out.println("Real: " + real + " Imaginary: " + imag);
    	}
	public Complex add(Complex a) {
        Complex t = new Complex();
        t.real = a.real + real;
        t.imag = a.imag + imag;
        return t;
    	}
	public Complex multi(Complex a) {
        Complex t = new Complex();
        t.real = (a.real * real) - (a.imag * imag);
        t.imag = (a.real * imag) + (a.imag * real);
        return t;
    	}
}