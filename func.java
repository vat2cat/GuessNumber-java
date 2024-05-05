package homework002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class AB{int A=0,B=0;}

public class func 
{
	static String InvertStr( String s )
	{  int k=s.length(); String z="";
	   for(int i=0; i<k; i++) { z=s.substring(i,i+1)+z; }
	   return(z);
	}

	static int Invert2(int i)
	{  String s=String.valueOf(i);	  
	   return( Integer.parseInt( InvertStr(s) ) );
	}
	static int Rand(int n)  //** Generate a random number (0 ~ n-1) **
	{ return( (int)(Math.random()*n) ); }
	
	static int RandMN(int m, int n)
	{ return( m+Rand(n-m+1) ); }
	
	static boolean CheckDifferent( int[] LT )
	{   boolean fg=true;  int k=LT.length;
  	    for(int i=0; i<=k-2; i++)
  	    {   for(int j=i+1; j<=k-1; j++)
  	        {  if(LT[i]==LT[j]) { fg=false; break; }  }
  	        if(fg==false) { break; }
  	    }		
		return(fg);
	}
	
	
	static boolean CheckDifferent( String ans ) //** overload 過荷 **
	{   int k=ans.length(); boolean fg=true;
        for(int i=0; i<(k-1); i++)
        {  String z1=ans.substring(i,i+1);
           String z2=ans.substring(i+1,k);
           if( z2.indexOf(z1)>=0 ) { fg=false; break; }
        }
		return(fg);
	}
	
	static String GuessAnswer()
	{   String ans="";
	    do { ans= String.valueOf( RandMN(1023,9876) ); }
	    while( CheckDifferent(ans)==false );
		return(ans);
	}
	static String UserGuess(int mesg)
	{ String gus;
	do {
		do 
		{gus=func.Input("("+mesg+")輸入四個不同的數字:");}
		while(gus.length()!=4);			
	}while(func.CheckDifferent(gus)==false);
	return(gus);
	}
	
	static String Input( String msg )
	{  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String s="";
       System.out.print(msg);
       try { s = br.readLine(); } catch(Exception e) {   }
       return( s );
	}
	
	static int InputNum( String msg )
	{   int ans=-1; boolean fg=true;
		do
	    {   fg=true;
			try { ans = Integer.parseInt( Input(msg) ); }	    
	        catch(Exception e) { fg=false; }		
	    }while(fg==false);
		return(ans);
	}	
	static int CountAB(String s1,String s2)
	{
		String z1="";
		int A=0,B=0;
		for(int i=0;i<4;i++)
		{
			z1=s1.substring(i,i+1);
			int k=s2.indexOf(z1);
			if(k>=0) {A++;}else{B++;}
		}
		return(A*10+B);
	}
	static AB CountAB2(String s1,String s2)
	{
		AB p=new AB();//建構construct
		p.A=0;p.B=0;String z1="";
		for(int i=0;i<4;i++)
		{
			z1=s1.substring(i,i+1);
			int k=s2.indexOf(z1);
			if(k>=0) {p.A++;}else{p.B++;}
		}
		return(p);
	}
}