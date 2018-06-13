package PathDemo;

import java.awt.List;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
	
	public static void check(){
		Path path = Paths.get("E:\\jid\\Path\\Demo.txt"); 
		boolean exists = Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS});
		System.out.println(exists);
	}
	
	public static void Copy(){
		Path source  = Paths.get("E:\\jid\\Path\\Demo.txt");
		Path target = Paths.get("E:\\jid\\Path\\Demo3.txt");

		try {
		    Files.copy(source, target);
		    System.out.println("Done");
		} catch(FileAlreadyExistsException fae) {
		    fae.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public static void delete(){
		Path path = Paths.get("E:\\jid\\Path\\Demo2.txt");
		try {
		    Files.delete(path);
		    System.out.println("Done");
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//check();
		//Copy();
		delete();

	}

}

