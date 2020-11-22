import java . util .*;
import java .math.*;
 //import java.math.BigInteger; 
public class Rsa
{
 public static void main(String args[])
 	{
	 Scanner sc=new Scanner(System.in);
	 int p,q,n,z,d=0,e,i;
	 System.out.println("Enter a number to be encrypted and decrypted");
	 int msg=sc.nextInt();
	 double c;
	 BigInteger msgback; 
	 System.out.println("Enter the 1st prime number p");
	 p=sc.nextInt();
	 System.out.println("Enter the   2nd prime number q");
	 q=sc.nextInt(); 
	 n=p*q;
	 z=(p-1)*(q-1);
	System.out.println("The value of n is " + n);
	 System.out.println("the value of totient is  "+z); 
		for(e=2;e<z;e++)
		 {
		 	if(gcd(e,z)==1)// e is for public key exponent
		 { 
		 break;
		 }
		 }
	 System.out.println("the value of e is  "+e); 
		 for(i=0;i<=9;i++)
		 {
			 int x=1+(i*z);
			 if(x%e==0)//d is for private key exponent
		{
			 d=x/e;
			 break;
		 }
		 }
	 System.out.println("the value of d  is "+d); 
	 c=(Math.pow(msg,e))%n;
	 System.out.println("Encrypted message is : -");
	 System.out.println(c);
	 BigInteger N = BigInteger.valueOf(n);//convert int value of n to BigInteger
	 BigInteger C = BigDecimal.valueOf(c).toBigInteger();//convert float value of c to BigInteger
	 msgback = (C.pow(d)).mod(N);
	 System.out.println("Derypted message is : -");
	 System.out.println(msgback);
        
}
	static int gcd(int e, int z)
		 {
		 if(e==0)
		 return z; 
		 else
		 return gcd(z%e,e);
 		}
}

