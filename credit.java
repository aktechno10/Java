import java.io.*;
import java.util.*;

interface CreditCardInterface
{
	void viewCreditAmt();
	void useCard();
	void payCredit();
	void increaseLimit();
}

//FOR SILVER CARD CUSTOMER
class SilverCard implements CreditCardInterface
{                
	String name;
	int crNo, crAmt=0, crLimit=50000, total;
	Scanner sc = new Scanner(System.in);
	
	public void get()
	{
		System.out.println("\nEnter your name :");
		name=sc.next();
		
		System.out.println("\nEnter your card-number :");
		crNo=sc.nextInt();
	}
	
 	public void viewCreditAmt()
 	{
 		System.out.println("\n\t------------------------");
 		System.out.println("\n\tTotal Amount Credited Is :"+crAmt);
		System.out.println("\n\t----------------------");
 	}
 	
 	public void useCard()
 	{
 		System.out.println("\n\tCard Limit Is:"+crLimit);
 		
 		System.out.println("\n\tEnter Amount To Be Added To Your Card :");
 		int uAmt=sc.nextInt();
 		
 		if(uAmt<=crLimit)
 		{
	 	 System.out.println("\n\tYour A/C Is Credited By An Amount :"+uAmt);
	 	 
	 	 total=crAmt+uAmt;
	 	 System.out.println("\n\tNow Total Balance In Your Card :"+total);
 	    }
 	    else
 	    {
 	    	System.out.println("\n\tYou Can't Add More Than 50,000 Rs. !!!");
 	    }
 	}
 	
 	public void payCredit()
 	{
		 System.out.println("\n\tTotal Balance In Your Card :"+total);
		 
		 System.out.println("\n\tEnter An Amount To Be Use In Your Card :");
		 int pAmt=sc.nextInt();
		 
		 System.out.println("\n\tUsed Amount In Your Card Is :"+pAmt);
		 
		 int rem=total-pAmt;
		 System.out.println("\n\tRemaining Balance In Your Card Is :"+rem);
 	}
 	
 	public void increaseLimit()
	{
	System.out.println("\n\t-------OOPS!!! SILVER CARD CUSTOMER CANNOT INCREASE LIMIT!---------");
	}
}

//FOR GOLD CARD CUSTOMER

class GoldCard extends SilverCard
{
    String name;
	int crNo, crAmt=0, crLimit=100000, total;
	
	Scanner sc = new Scanner(System.in);
	public void get()
	{
		System.out.println("\n\tEnter your name :");
		name=sc.next();
		
		System.out.println("\n\tEnter your card-number :");
		crNo=sc.nextInt();
	}
	
	public void viewCreditAmt()
 	{
 		System.out.println("\n\t------------------------");
 		System.out.println("\n\tTotal Amount Credited Is :"+crAmt);
		System.out.println("\n\t----------------------");
 	}
 	
	public void useCard()
 	{
 		System.out.println("\n\tCard Limit Is:"+crLimit);
 		
 		System.out.println("\n\tEnter Amount To Be Added To Your Card :");
 		int uAmt=sc.nextInt();
 		
 		if(uAmt<=crLimit)
 		{
	 	 System.out.println("\n\tYour A/C Is Credited By An Amount :"+uAmt);
	 	 
 	  	 total=crAmt+uAmt;
	 	 System.out.println("\n\tNow Total Balance In Your Card :"+total);
 	    }
 	    else
 	    {
   		 System.out.println("\n\tYou can't add more than 100000 Rs. !!!");
 	    }
 	}
 	
 	
 	public void payCredit()
 	{
		 System.out.println("\n\tTotal Balance In Your Card :"+total);
		 
		 System.out.println("\n\tEnter An Amount To Be Use In Your Card :");
		 int pAmt=sc.nextInt();
		 
		 System.out.println("\n\tUsed Amount In Your Card Is :"+pAmt);
		 
		 int rem=total-pAmt;
		 System.out.println("\n\tRemaining Balance In Your Card Is :"+rem);
 	}
	 
	 public void increaseLimit()
 	{
 		int iamt, crLimit=100000, crtime=0;
 		
 		System.out.println("\n\t^^^^^! You Can Increase Limit Upto 3 Times !^^^^^");
		System.out.print("\n\tEnter Amout To Be Increased: ");
		iamt=sc.nextInt();
		
			if(crtime < 3)
			{
				
				if(iamt<=5000)
				{
					crLimit=crLimit+iamt;
					crtime++;
					System.out.println("\n\tCredited Amount Is: "+crLimit);
				}
				else
				{
					System.out.println("\n\t---------Please Enter Amount Upto Rs.5000-/---------");
				}
				crtime++;
			}
	 	
	 		else
	 			System.out.println("\n\t---------You Crossed Your Limit!---------");/*(This line is neccesary
				 for bug fixing of amount increase no.of time)*/
	}
}
/* MAIN CLASS */

class credit
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		CreditCardInterface cci = null;
		
		System.out.println("\n\t\t-----------Please Select Your Card Type-----------");
		
		System.out.print("\n\t1. SILVER CARD");
		System.out.print("\n\t2. GOLD CARD");
		System.out.print("\n\t3. EXIT\n");
		
		int ch=sc.nextInt();
		
		if(ch==1)/*SILVER CARD DATA*/
		{
			cci = new SilverCard();
			/*cci.get*/
			System.out.println("\n\t\t*****YOU SELECTED SILVER CARD*****");
			
			while(true)
			{ 
			System.out.print("\n\t*******************");
			System.out.print("\n\t1. View Card");
			System.out.print("\n\t2. Use Card");
			System.out.print("\n\t3. Pay Card");
			System.out.print("\n\t4. Increase Limit");
			System.out.print("\n\t5. Exit");
			System.out.print("\n\t*******************");
			
			System.out.print("\n\tSelect process: ");
			int sp=sc.nextInt();
			switch(sp)
			{
			case 1: cci.viewCreditAmt();
			break;
			case 2: cci.useCard();
			break;
			case 3: cci.payCredit();
			break;
			case 4: cci.increaseLimit();
			break;								
			}
			}
		}
		
		else if(ch==2)
		{
			cci = new GoldCard();
			System.out.println("\n\t*****YOU SELECTED GOLD CARD*****");
			/*cci.get();*/
		 	while(true)
		 	{ 
			 System.out.print("\n\t*******************");
			 System.out.print("\n\t1. View Card");
			 System.out.print("\n\t2. Use Card");
			 System.out.print("\n\t3. Pay Card");
			 System.out.print("\n\t4. Increase Limit");
			 System.out.print("\n\t5. Exit");
			 System.out.print("\n\t*******************");
			
			 System.out.print("\n\tSelect process: ");
			 int sp=sc.nextInt();
			
			 switch(sp)
			 {
			 case 1: cci.viewCreditAmt();
			 break;
			 case 2: cci.useCard();
			 break;
			 case 3: cci.payCredit();
			 break;
			 case 4: cci.increaseLimit();
			 break;
			 case 5:
			 		System.exit(0);								
			 }
			 }
		} else	
		  	  System.out.println("\n\tFor Transaction Please Select Choice 1 or 2");
	}   
}
