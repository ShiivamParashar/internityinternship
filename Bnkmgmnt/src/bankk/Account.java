package bankk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


    public class Account extends bank {
	
    	String accHolderName;										 
    	int accountNo;												 
    	int accountBal;												 
    	static ArrayList<String> miniState;							 
	
	
    	Account(String name,int no,int bal)
    	{
    		accHolderName = name;
    		accountNo = no;
    		accountBal = bal;
		
    		Acc.put(accountNo, this);
    	}
    	public void call()
		{
			
			while(true)				    
			{							
				try 
				{	
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					bank bank = new bank();
				
					System.out.println("\nYour Current Balance is Rs"+this.accountBal+"\n");
					System.out.println("Enter 1 to credit");
					System.out.println("Enter 2 to debit");
					System.out.println("Enter 3 to generate mini statement");
					System.out.println("Enter 4 to exit");
					int ch = Integer.parseInt(br.readLine());
					
					switch(ch)
					{
						case 1:
								bank.credit(accountNo);
								break;
								
						case 2: 
								bank.debit(accountNo);
								break;
								
						case 3: for(int i=0;i<Account.miniState.size();i++)
									System.out.println(Account.miniState.get(i));
						
								System.out.println("--------------------------------------");
								break;
						
						case 4: System.exit(0);
								break;
								
						default: System.out.println("Please Enter the valid number");		
						
					}
				} 			
				catch (NumberFormatException |IOException e) 
				{
					System.out.println("Inavlid inputs");
				}
			}				
		}


}


