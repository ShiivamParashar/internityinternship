package automatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ATM {
	static HashMap<Integer,Transactions> Passbook = new HashMap<>();
	static int sno=1;
	int currentBal;
	
	Date d = new Date();
	String date = new SimpleDateFormat("dd/MMM/yyyy").format(d);
	String time = new SimpleDateFormat("HH:mm:ss").format(d);
	
	static Queue<String> miniStatement = new LinkedList<>();
	public void credit()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the particulars");
			String p = br.readLine();
			
			System.out.println("Enter the cheque number(If any else enter '0') ");
			int cno = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the amount to be credited");
			int camount = Integer.parseInt(br.readLine());
			
			if(camount>0)
			{
				int fbal=0;
				  //current operation
				fbal = this.currentBal + camount;
				this.currentBal = fbal;

				System.out.println("Your new amount= "+this.currentBal);
				ATM.Passbook.put(sno, new Transactions(p,cno,0,camount,fbal));
				ATM.sno++;

				int size = ATM.miniStatement.size();
				if(size==5)
					ATM.miniStatement.remove();

				ATM.miniStatement.add("This Account is credited with Rs" +camount+" on date "+date+" at "+time+". Final Balance= Rs"+fbal);

			}
			else
				System.out.println("No negative transactions are allowed");
			
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void debit()
	{
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter the particulars");
			String p = br.readLine();
			
			System.out.println("Enter the checque number(If any else enter '0') ");
			int cno = Integer.parseInt(br.readLine());
			
			System.out.println("Enter the amount to be debited");
			int damount = Integer.parseInt(br.readLine());
			
			if(damount > 0)
			{
				if(this.currentBal>=damount)
				{
					int fbal=0;
					
					fbal = this.currentBal - damount;
					this.currentBal = fbal;
						
					System.out.println("Your new amount= "+this.currentBal);
					ATM.Passbook.put(sno, new Transactions(p,cno,damount,0,fbal));
					sno++;
					
					int size = ATM.miniStatement.size();
					if(size==5)
						ATM.miniStatement.remove();
					
					ATM.miniStatement.add("This Account is debited with Rs" +damount+" on date "+date+" at "+time+". Final Balance= Rs"+fbal);
				}
				else
					System.out.println("Not enough balance to withdraw");
			}
			else
				System.out.println("No Negative Transactions allowed");
			
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void generatePassbook()
	{
		 if(ATM.Passbook.isEmpty())
		 {
			 System.out.println("No Transactions Done!");
		 }
		 else
		 {
			 System.out.println("S. no.   Perticulars   Cheque No.   Debit amt   Credit amt   Final Bal   Date");
			 for(HashMap.Entry<Integer,Transactions> m:Passbook.entrySet())
			 {
				 Transactions t = m.getValue();
					
				 System.out.print("   "+m.getKey()+"         "+t.particulars+"      ");
				 if(t.chequeNo==0)
					System.out.print("     -"+"   ");
			     else
					System.out.print("   "+t.chequeNo+"   ");
					
				 if(t.damount==0)
					System.out.print("        -          ");
				 else
					System.out.print("       "+t.damount+"           ");
					
				 if(t.camount==0)
					System.out.println("-         "+t.finalBal+"     "+t.date+"     "+t.time);
				 else
					System.out.println(t.camount+"         "+t.finalBal+"     "+t.date+"     "+t.time);
				 
				
				}
		}
		 
	}
	
	public void generateMiniStatement()
	{
		
		Iterator<String> it = ATM.miniStatement.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

}
