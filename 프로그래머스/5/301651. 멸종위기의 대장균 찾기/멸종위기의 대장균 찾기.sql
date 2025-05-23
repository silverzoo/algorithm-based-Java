WITH RECURSIVE GENERATION AS(
    SELECT ID, 1 AS g_level
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL # 최상위 노드

    UNION ALL

    SELECT e.ID, g.g_level+1 AS g_level
    FROM ECOLI_DATA e
    INNER JOIN GENERATION g
    ON e.PARENT_ID = g.ID
)

SELECT COUNT(*) AS `COUNT`, g_level as GENERATION
FROM GENERATION g
LEFT JOIN ECOLI_DATA e
ON g.ID = e.PARENT_ID
WHERE e.ID IS NULL 
GROUP BY GENERATION
ORDER BY GENERATION