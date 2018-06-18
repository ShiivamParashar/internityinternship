package automatic;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Transactions extends ATM {
	Date d = new Date();
	String date = new SimpleDateFormat("dd/MMM/yyyy").format(d);
	String time = new SimpleDateFormat("HH:mm:ss").format(d);	
	
	String particulars;
	int chequeNo;
	int damount;
	int camount;
	int finalBal;
	
	Transactions(String particulars, int cno, int damt, int camt,int fbal)
	{
		this.particulars = particulars;
		chequeNo = cno;
		damount = damt;
		camount = camt;
		finalBal = fbal;
		
	}	

}
