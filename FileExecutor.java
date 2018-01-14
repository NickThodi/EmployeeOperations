package training;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileExecutor {
 
	public void fileProcessor(File[] folder) {
		
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		for(File file: folder) {
			es.execute(new FileLoader(file));
		}
	}
	
}
