package InMemoryDatabase;

import java.util.Arrays;

public class DatabaseManager {
	public static void main(String[] args) {
		Database database = new Database("MyDatabase");
		Table table = database.createTable("Table1");
		try {
			table.addColumns("Column1,Column2,Column3");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		// Insert Row
		try {
			table.insertData("R1D1,R1D2,R1D3");
			table.insertData("R2D1,R2D2,R2D3");
			table.insertData("R3D1,R2D2,R3D3");
			table.insertData("R4D1,R1D2,R1D3");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		// Fetch Row
		try {
			Row row1 = table.fetchRowData("R2D1");
			System.out.println(Arrays.stream(row1.getColumnValues()).toList());
			Row row2 = table.fetchRowData("R3D1");
			System.out.println(Arrays.stream(row2.getColumnValues()).toList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Delete Row based on primary key
		try {
			System.out.println("Before Deleting: ");
			table.getRows();
			table.deleteRow("R1D1");
			System.out.println("After Deleting: ");
			table.getRows();
			table.deleteRow("R1D1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Delete Row based on column name and value
		try {
			System.out.println("Before Deleting: ");
			table.getRows();
			table.deleteRow("Column3", "R1D3");
			System.out.println("After Deleting: ");
			table.getRows();
			table.deleteRow("Column3", "R1D3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Delete table
		try {
			System.out.println("Before Deleting: ");
			database.getTables();
			database.deleteTable("Table1");
			System.out.println("After Deleting: ");
			database.getTables();
			database.deleteTable("Table1");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Update column value
		try {
			System.out.println("Before Updating: ");
			table.getRows();
			table.update("Column2,Column3","R1D2,R1D3","Column3", "R1D3U1");
			System.out.println("After Updating: ");
			table.getRows();
			table.update("Column2", "R2D2","Column2,Column3", "Data2,Data3");
			System.out.println("After Updating: ");
			table.getRows();
			table.update("","", "", "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Search table
		try {
			table.search("Column2", "R2D2");
			table.search("Column2,Column3", "R1D2,R1D3");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
