package bankk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class main extends Account {
	main(String name, int no, int bal) {
		super(name, no, bal);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		DbOperations dbOps = new DbOperations();
		miniState = new ArrayList<String>();

		char y='y';
		while(y=='y')                    
		{								
			try 
			{
				System.out.println("Account holder name ");
				String name = br.readLine();

				int num = (int)((Math.random() *9000) +1000);

				System.out.println("Your Account No is " + num);

				System.out.println("Enter Current Balance **MINIMUM 1000 ");
				int bal = Integer.parseInt(br.readLine());

				if(bal<0)
					System.out.println("Amount can't be -ve");
				else if( bal < 1000){
					System.out.println("Ammount should be 1000");
				}
				else
				{
					int generatedKey =dbOps.createTransaction(num,"credit",bal,true,0,name);
					if(generatedKey == 0){
						throw new Exception("there is some problem occurred Please try again");
					}
					dbOps.createAccount(num, bal,name , generatedKey);
					y='n';				
					Account accob = new Account(name,num,bal);
					accob.call();
				}
				
				
			} 
			catch (NumberFormatException | IOException e) 
			{
				System.out.println("Wrong Input--- Enter valid ");
			}

		}


	}


}
