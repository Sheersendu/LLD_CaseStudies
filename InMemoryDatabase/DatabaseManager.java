package InMemoryDatabase;

import java.util.Arrays;

public class DatabaseManager {
	public static void main(String[] args) {
		Database database = new Database("MyDatabase");
		Table table = database.createTable("Table 1");
//		database.getTables();
		table.addColumns("Column1, Column2, Column3");
//		table.getColumnNames();

		// Insert Row
		table.insertData("R1D1, R1D2, R1D3");
		table.insertData("R2D1, R2D2, R2D3");
//		table.getRows();

		// Fetch Row
		try {
			Row row = table.fetchRowData("R3D1");
			System.out.println(Arrays.stream(row.getColumnValues()).toList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
