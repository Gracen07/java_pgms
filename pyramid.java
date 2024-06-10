class pyramid{
    public static void main(String args[])
    {
            for(int i=0;i<=5;i++)
            {
                for(int j=i;j<=5;j++)
                {
                    System.out.println(" ");
                }
                for(int k=0;k<i*2;k++)
                {
                    System.out.println("*");
                }
                System.out.println();
            }
    }
}

