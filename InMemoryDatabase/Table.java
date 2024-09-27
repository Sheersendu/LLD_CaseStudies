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

	public Row fetchRowData(String primaryKey) throws Exception
	{
		for (Row row : rows) {
			if (row.getColumnValues()[0].equals(primaryKey)) {
				return row;
			}
		}
		throw new Exception("Row doesn't Exists!");
	}

	public void deleteRow(String primaryKey) throws Exception
	{
		for (Row row : rows) {
			if (row.getColumnValues()[0].equals(primaryKey)) {
				this.rows.remove(row);
				return;
			}
		}
		throw new Exception("Row cannot be deleted as it doesn't Exists!!");
	}

	public void deleteRow(String columnName, String columnValue) throws Exception
	{
		int columnIndex = this.columnNames.get(columnName);
		boolean rowFound = false;
		for (Row row : rows) {
			String[] columnValues = row.getColumnValues();
			if (columnValues[columnIndex].equals(columnValue)) {
				this.rows.remove(row);
				rowFound = true;
			}
		}
		if(!rowFound)
		{
			throw new Exception("Row cannot be deleted as it doesn't Exists!!");
		}
	}

	public void update(String searchColumnNames, String searchColumnValues, String columnNames, String columnValues) throws Exception
	{
		List<Row> result = search(searchColumnNames, searchColumnValues);
		if(!result.isEmpty())
		{
			String[] updateColumnNames = columnNames.split(",");
			String[] updateColumnValues = columnValues.split(",");
			int totalUpdateColumns = updateColumnNames.length;
			List<Integer> columnIndexes = getColumnIndexes(updateColumnNames);
			for(Row row: result) {
				for (int index = 0; index < totalUpdateColumns; index++) {
					row.updateColumnValue(columnIndexes.get(index), updateColumnValues[index]);
				}
			}
		}
	}

	public List<Row> search(String searchColumnNames, String searchColumnValues) throws Exception
	{
		String[] filterColumnNames = searchColumnNames.split(",");
		String[] filterColumnValues = searchColumnValues.split(",");
		List<Integer> columnIndexes = getColumnIndexes(filterColumnNames);
		List<Row> resultRows = new ArrayList<>();
		int totalFilterColumns = filterColumnNames.length;
		for(Row row: rows)
		{
			String[] columnValues = row.getColumnValues();
			boolean isResult = true;
			for(int index=0; index<totalFilterColumns; index++)
			{
				if (!columnValues[columnIndexes.get(index)].equals(filterColumnValues[index])) {
					isResult = false;
					break;
				}
			}
			if(isResult) {
				resultRows.add(row);
			}
		}
		return resultRows;

	}

	private List<Integer> getColumnIndexes(String[] columnNames) throws Exception
	{
		List<Integer> columnIndexes = new ArrayList<>();
		for (String columnName : columnNames) {
			Integer columnIndex = this.columnNames.get(columnName);
			if (columnIndex != null) {
				columnIndexes.add(columnIndex);
			} else {
				throw new Exception("Column doesn't exists!");
			}
		}
		return columnIndexes;
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
