package InMemoryDatabase;

import lombok.Getter;

import java.util.*;

public class Table {
	@Getter
	private final String tableName;
	private final List<Row> rows;
	private int totalColumns;
	private final HashMap<String, Integer> columnNames;

	public Table(String tableName)
	{
		this.tableName = tableName;
		this.columnNames = new HashMap<>();
		this.rows = new ArrayList<>();
	}

	public void addColumns(String userInputColumnNames)
	{
		String[] columnNames = userInputColumnNames.split(",");
		this.totalColumns = columnNames.length;
		for(int index = 0; index < totalColumns; index++)
		{
			String columnName = columnNames[index];
			this.columnNames.put(columnName, index);
		}
	}

	public void insertData(String userInput)
	{
		Row row = new Row(totalColumns);
		row.insert(userInput);
		this.rows.add(row);
	}

	public void getRows()
	{
		for(int index = 0; index < rows.size(); index++)
		{
			Row row = rows.get(index);
			System.out.println(Arrays.stream(row.getColumnValues()).toList());
		}
	}

	public void getColumnNames()
	{
		columnNames.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.forEach(System.out::print);
		System.out.println();
	}

}
