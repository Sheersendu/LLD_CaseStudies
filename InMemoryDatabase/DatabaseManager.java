package InMemoryDatabase;

public class DatabaseManager {
	public static void main(String[] args) {
		Database database = new Database("MyDatabase");
		Table table = database.createTable("Table 1");
		database.getTables();
		table.addColumns("Column1, Column2, Column3");
		table.getColumnNames();
		table.insertData("R1D1, R1D2, R1D3");
		table.getRows();
	}
}
