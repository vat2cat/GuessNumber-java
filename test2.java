package homework002;
import java.util.ArrayList;
public class test2 
{
	public static void main(String[] a)
	{
		int n=0,x=1; String s=""; 
		for(int c=1;c<=5;c++)
		{
			if(c==1)
			{ s=func.Input("�A�Q���q�٬O��q�A���q��0��q��1"); }
			else
			{ s=func.Input("�п�ܻP���e���P���Ʀr"); }
			n=Integer.parseInt(s);
			if(n==0)
			{
				String ans=func.GuessAnswer(); //�H�q�q��
				String gus="";AB p=new AB(); String z1; int cnt=1;
				do
				{
					do
					{
						do
						{
							gus=func.Input("("+cnt+")��J�|�Ӥ��P���Ʀr�G");
					
						}while(gus.length()!=4);
					}while(func.CheckDifferent(gus)==false);
					cnt++; p=func.CountAB2(ans, gus);
					System.out.println(p.A+"A"+p.B+"B");
				}while(p.A!=4);
				System.out.println("ans�G"+ans+"you guess"+(cnt-1)+"��");
			}
			else //�q���q�H
			{
				ArrayList<String> sol1=new ArrayList<String>();
				ArrayList<String> sol2=new ArrayList<String>();
				String gus=""; String z=""; int pt=0; int pt2=0; AB pp; int A=0,B=0;
				for(int i=1023; i<9876; i++)
				{
					z=String.valueOf(i);
					if(func.CheckDifferent(z)==true) {sol1.add(z);}
				}
				do
				{
					int k=func.RandMN(0, pt-1);
					gus=sol1.get(k);
					System.out.println("my guess..."+gus);
					A=func.InputNum("�HA "); B=func.InputNum("�HB ");
					pt2=0;
					for(int i=0;i<pt;i++)
					{
						pp=func.CountAB2(gus, sol1.get(i));
						if((pp.A==A)&&(pp.B==B)) {sol2.add(sol1.get(i));}
					}
					System.out.println(pt2);
					sol1.clear();sol1.addAll(sol2);
					pt=pt2;
				}while(pt>1);
				if(pt==1) {System.out.println("answer is ..."+sol1.get(0));}
				else {System.out.println("you lose");}
			}
		}
	}
}

