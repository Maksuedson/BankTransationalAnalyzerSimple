package banktransctional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Test2 {
	private static final String RESOURCES = "./src/resources/extratos.txt";
	
	public static void main(String[] args) throws IOException {
		Path path = Paths.get(RESOURCES);
		List<String>lines = Files.readAllLines(path);
		double total = 0d;
		
		DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		for (String line: lines) {
			String[] columns = line.split(",");
			LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			
			if (date.getMonth() == Month.JANUARY) {
				double amount = Double.parseDouble(columns[1]);
				total += amount;
			}
		}
		
		System.out.println("O total de todas as transa??es ?: " + total);
	}

}
