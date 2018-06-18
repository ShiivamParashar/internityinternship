package automatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		ATM atmob = new ATM();
		
		while(true)        
		{				   
			try 
			{
				System.out.println("Enter current balance");
				atmob.currentBal = Integer.parseInt(br.readLine());
				break;      //break the loop if user enters correct input
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		while(true)				
		{				   		
			try 
			{
				System.out.println("\n");
				System.out.println("press 1 for credit money");
				System.out.println("press 2 for debit money");
				System.out.println("press 3 for generate passbook");
				System.out.println("press 4 for generate mini statements");
				System.out.println("press 5 for exit");
					
				int choice = Integer.parseInt(br.readLine());
				switch(choice)
				{
					case 1: atmob.credit();
							break;
								
					case 2: atmob.debit();		
							break;
								
					case 3: atmob.generatePassbook();
							break;
								
					case 4: atmob.generateMiniStatement();
							break;
							
					case 5: System.exit(0);								
				}	
			} 
			catch (NumberFormatException |IOException e) 
			{
				System.out.println("Try again with valid input");
			}
		}
			
	}

	}


