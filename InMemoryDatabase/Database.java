package InMemoryDatabase;

import lombok.Getter;

import java.util.HashMap;

public class Database {
	@Getter
	private final String databaseName;
	private final HashMap<String, Table> tableList;

	public Database(String databaseName)
	{
		this.tableList = new HashMap<>();
		this.databaseName = databaseName;
	}

	public Table createTable(String tableName)
	{
		Table table = new Table(tableName);
		this.tableList.put(tableName, table);
		return table;
	}

	public void deleteTable(String tableName) throws Exception
	{
		if(this.tableList.get(tableName) != null)
		{
			this.tableList.remove(tableName);
			return;
		}
		throw new Exception("Table doesn't exists!");
	}

	public void getTables()
	{
		System.out.println(this.tableList.keySet());
	}
}
