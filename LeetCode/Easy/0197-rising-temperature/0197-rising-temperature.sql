# Write your MySQL query statement below
SELECT main.id
FROM Weather main
    JOIN (
        SELECT
            id,
            recordDate,
            DATE_ADD(recordDate, INTERVAL 1 DAY) AS nextRecordDate,
            temperature
        FROM Weather 
    ) sub
        ON main.recordDate = sub.nextRecordDate
WHERE main.temperature > sub.temperature