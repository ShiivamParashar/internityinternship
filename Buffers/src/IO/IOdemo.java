package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOdemo {
	
	public static void bufferWriterDemo() throws Exception {
		FileWriter writer = new FileWriter("E:\\jid\\Buffers\\Eg.txt");  
	    BufferedWriter buffer = new BufferedWriter(writer);  
	    buffer.write("Internity Internship 2k18");  
	    buffer.close();  
	    System.out.println("DONE");
	}
	
	public static void bufferReaderDemo() throws Exception {
		FileReader fr=new FileReader("E:\\jid\\Buffers\\Eg.txt");    
        BufferedReader br=new BufferedReader(fr);    

        int i;    
        while((i=br.read())!=-1){  
        System.out.print((char)i);  
        }  
        br.close();    
        fr.close();    
	}
	
	public static void fileOutputStream() {
		
		try{    
            FileOutputStream fout=new FileOutputStream("E:\\jid\\Buffers\\Eg.txt");    
            String s="Summer InternShip";    
            byte bit[]=s.getBytes();   
            fout.write(bit);    
            fout.close();    
            System.out.println("\nDONE...");    
           }
			catch(Exception e)
			{
        	   System.out.println(e);
        	}  
	}
	
	public static void fileInputStream(){
		try{    
            FileInputStream fin=new FileInputStream("E:\\jid\\Buffers\\Eg.txt");    
            int i=0;    
            while((i=fin.read())!=-1){    
             System.out.print((char)i);    
            }    
            fin.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}    
	}
	
	public static void ObjeOutputStreamDemo() {
		
		String s = "Hi My Name is Shivam Parashar Contact No.--";
	    int i = 741737558;
	    try {

	         FileOutputStream out = new FileOutputStream("test.txt");
	         ObjectOutputStream oout = new ObjectOutputStream(out);

	         oout.writeObject(s);
	         oout.writeObject(i);

	         oout.close();

	         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.txt"));

	         
	         System.out.println("" + (String) ois.readObject());
	         System.out.println("" + ois.readObject());
	         
	     

	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	      
	}
	
	public static void PrintWriterDemo(){
		  Object obj1 = "Internity Summer Internship ";
	      Object obj2 = 2018;
	      
	      try {
	         PrintWriter prwr = new PrintWriter(System.out);
	         prwr.println(obj1);
	         prwr.println(obj2);

	         
	         prwr.flush();

	      } 
	      catch (Exception ex) 
	      {
	         ex.printStackTrace();
	      }
	}
	
	public static void main(String[] args) throws Exception {     

    bufferWriterDemo();
    bufferReaderDemo();
    fileOutputStream();
    fileInputStream();
    ObjeOutputStreamDemo();
	PrintWriterDemo();
	

}
}
