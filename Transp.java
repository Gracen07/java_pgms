import java.io.*;
import java.util.*;
class Transp{
	public static void main(String args[]){
		int a[][],b[][],c[][];
		int i,j,n,k;
		Scanner s= new Scanner(System.in);
		System.out.println("enter the order of matrix: ");
		try{
		n=s.nextInt();
		a=new int[n][n];
		b=new int[n][n];
		c=new int[n][n];
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.println("enter value for a["+i+"]["+j+"]");
				a[i][j]=s.nextInt();
			}
		}
		System.out.println("matrix: ");
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(a[i][j]+"  ");
			}System.out.println("");
		}
		System.out.println("Transpose of a matrix: ");
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(a[j][i]+"  ");
			}System.out.println("");
		}
		}catch(Exception e){
		}
	}
}

		
		