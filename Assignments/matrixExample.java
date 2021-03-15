package Assignments;

public class matrixExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=5;

for(int i=1; i<=n; i++)
{

for(int j=1; j<=n; j++)
{
	if((j==n&&i==1)||(j==n-1&&i==2)||(j==n-2&&i==3)||(j==n-3&&i==4)||(j==n-4&&i==5))
	{
		System.out.print("* ");
	}
	else 
{
System.out.print(j+" ");
}
}
System.out.println("");
}

}

}

