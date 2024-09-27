Scope:

1. Create table ✅
2. Update table (column, multiple column)✅
3. Fetch rows ✅
4. Insert rows ✅
5. Search functionality ✅
6. Delete rows ✅
7. Delete table ✅

Assumption:

1. We cannot alter table name
2. For insertion all columns are necessary
3. We don't have and cannot add any type of constraint to the table
4. The first column value in a row is the primary key
5. All the values are of type string

Approach:

1. Since search functionality is required we can choose hashMap for efficient searching
2. We can make table object using builder design pattern as multiple params + once object created it should be immutable

Classes:

1. Database class
2. Table class
3. Row class
4. DatabaseManager class
