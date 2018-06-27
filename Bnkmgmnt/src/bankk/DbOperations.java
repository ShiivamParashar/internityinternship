package bankk;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DbOperations {

	private String userName="root";
	private String password="shivam";
	private String dbUrl ="jdbc:mysql://localhost:3306/bank";
	Connection con =null;
	Statement stm = null;


	private void createConnection(){

		try {
			if(con==null || con.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Connecting to database...");
				con = DriverManager.getConnection(dbUrl,userName,password);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

	public   void createAccount(int num,int bal,String name, int transactionId) {

		try {
			createConnection();
			stm = con.createStatement();

			String query ="insert into account(accountnum,balance,holdername,transactionid) values("+num+","+bal+",'"+name+"',"+transactionId+" )";
			System.out.println(query);
			stm.execute(query);
			con.commit();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	
	public int createTransaction( int accountNumber,String type, int cAmount ,boolean isFirst,int finalBalance ,String name){
		createConnection();
		int id=0;
		try {
			stm = con.createStatement();
			String query ="insert into transaction(type ,amount) values ('"+type+"',"+cAmount+")";
			int i = stm.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
			if(i>0){
				ResultSet rs =stm.getGeneratedKeys();
				rs.next();
				id= rs.getInt(1);
				
			}
			if(!isFirst){
				createAccount(accountNumber,finalBalance ,name , id);
			}
			return id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return 0;
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		String query="insert into account "
	}
}
