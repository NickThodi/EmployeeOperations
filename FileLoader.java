package training;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileLoader implements Runnable {

	private File fileName;
	
	
	public FileLoader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileLoader(File fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
     WriteToDB w2db = new WriteToDB();
     
     try {
		w2db.writeFilesToDB(fileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	}

}
