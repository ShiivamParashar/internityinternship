package bankk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class bank {
	
	static HashMap<Integer, Account> Acc = new HashMap<>();
	Date d = new Date();
	String date = new SimpleDateFormat("dd/MMM/yyyy").format(d);
	String time = new SimpleDateFormat("HH:mm:ss").format(d);
	
	DbOperations dbOps = new DbOperations();
	
	
	void credit(int accNo ,String name){
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Account acc = Acc.get(accNo);
			
			System.out.println("Enter the amount to be credited");
			int camount = Integer.parseInt(br.readLine());
			
			if(camount>0)
			{
				int b = camount + acc.accountBal;						
				acc.accountBal = b;
				Acc.put(accNo, acc);							 
				System.out.println("Amount Credited");
				System.out.println("New amount " + acc.accountBal);
				
//				b is final , camount is transaction amount 
				dbOps.createTransaction(accNo, "credit", camount, false ,b,name);
				
				
				Account.miniState.add("Account "+accNo+" is credited with Rs"+camount + "on date"+date+ "at time" + time);			}
			    else
				System.out.println("Amount can't be negative");
			
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		} 
		
		
	}
	
	public void debit(int accNo,String name){
		try 
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Account acc = Acc.get(accNo);

		
			System.out.println("Enter the amount to be debited");
			int damount = Integer.parseInt(br.readLine());
		
		
			if(damount>0)
			{
				if(acc.accountBal<damount)
					System.out.println("Not enough balance");
				else 
				{
					int b = acc.accountBal - damount;
					acc.accountBal = b; 
					Acc.put(accNo, acc);
					System.out.println("Amount Debited");
					System.out.println("New amount " + acc.accountBal);
					dbOps.createTransaction(accNo, "debit", damount, false ,b,name);
				
					Account.miniState.add("Account "+accNo+" is debited with Rs"+damount);
				
				}
			}
			else
				System.out.println("Amount can't be negative");
		
		} 
		catch (NumberFormatException | IOException e) 
		{
			e.printStackTrace();
		}
	}
}
