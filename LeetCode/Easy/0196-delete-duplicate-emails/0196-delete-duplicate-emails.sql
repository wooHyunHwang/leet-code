# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
DELETE FROM Person
WHERE id NOT IN (
    SELECT temp.id
    FROM (
        SELECT MIN(c.id) AS id
        FROM Person c
        GROUP BY c.email
    ) temp
)