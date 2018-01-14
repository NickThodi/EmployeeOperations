package training;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;

public class FileReader {

	public ArrayList<Employee> readFromFile(File file) throws IOException {

		ArrayList<Employee> al = new ArrayList<>();

		Reader fr = new java.io.FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		String line = null;

		boolean keepReading = true;

		int index = 0;
		while (keepReading) {
			line = br.readLine();

			if (line == null || line.equals("")) {
				break;
			}
			if (index != 0) {
				Employee e = parseLine(line);
				al.add(e);
			}

			index++;
		}
		return al;
}

private Employee parseLine(String line) {
	String[] tokens = line.split(",");
	int num = Integer.parseInt(tokens[0]);
	String name = tokens[1];
	Float sal = Float.parseFloat(tokens[2]);
	int age = Integer.parseInt(tokens[3]);
	int year = Integer.parseInt(tokens[4]);
	Employee emp = Employee.constEmployee(num, name, sal, age, year);
	return emp;
}
}
