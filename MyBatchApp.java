package training;

import java.io.File;


public class MyBatchApp  {

	public static void main(String[] args) {
		
	 File[] files = loadFiles(); 
	 
	 FileExecutor fe = new FileExecutor();
	 fe.fileProcessor(files);
	 
	}
	
	private static File[] loadFiles( ) {
		
		File folder = new File("C:\\Users\\adity\\Desktop\\Assignments\\BatchFiles");
        File[] files = folder.listFiles();
       
        return files;
	}  
}
