# Write your MySQL query statement below
SELECT
    main.Department,
    main.Employee,
    main.Salary
FROM (
    SELECT
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER (PARTITION BY e.departmentId ORDER BY e.salary DESC) AS Ranking
    FROM Employee e
        JOIN Department d
            ON e.departmentId = d.id
) main
WHERE main.Ranking <= 3;
