package InMemoryDatabase;

import lombok.Getter;

public class Row {
	private final int totalColumns;
	@Getter
	private String[] columnValues;

	public Row(int totalColumns)
	{
		this.totalColumns = totalColumns;
		columnValues = new String[totalColumns];
	}

	public void insert(String userValues)
	{
		String[] userRowValues = userValues.split(",");
		if(isValidRowData(userRowValues)){
			columnValues = userRowValues;
		}
	}

	private boolean isValidRowData(String[] rowValues)
	{
		if(rowValues.length != totalColumns)
		{
			return false;
		}
		for(int index = 0; index< totalColumns; index++)
		{
			if(rowValues[index].isEmpty())
			{
				return false;
			}
		}
		return true;
	}
}
