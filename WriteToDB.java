package training;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Date;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteToDB {
	
private static final int Batch_size = 5;

Connection con = null;
PreparedStatement pstmt;

 WriteToDB(){
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs_assignments", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	public void writeFilesToDB(File file) throws IOException, SQLException {
		
		FileReader fr =  new FileReader();
		WriteToDB w2db = new WriteToDB();
		ArrayList<Employee> alist = fr.readFromFile(file);
		
		pstmt = con.prepareStatement("insert into employeebatch (Number, EName, ESalary, EAge, EDoj) values (?,?,?,?,?)");
		
		con.setAutoCommit(false);
		int counter = 1;
		boolean hasMoreFiles = true;
		
		for(Employee emp: alist) {
			if(emp == null) {
				break;
			}
			
			Date doj = new Date(emp.getDoj().getTime());
			
			pstmt.setInt(1, emp.getNumber());
            pstmt.setString(2, emp.getName());
            pstmt.setFloat(3, emp.getSalary());
            pstmt.setInt(4, emp.getAge());
            pstmt.setDate(5, doj);
            
            pstmt.addBatch();
            
            if(counter++ % Batch_size == 0) {
            	int[] count = pstmt.executeBatch();
            	hasMoreFiles = false;
            }else {
            	hasMoreFiles = true;
            }
		}
	if(hasMoreFiles) {
		int[] count = pstmt.executeBatch();
	}
	con.commit();
	con.rollback();
	
	try {
		Thread.sleep(2*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("System completed loading files.." +file);
	}
}
