SELECT t1.ID
FROM ECOLI_DATA as t1
LEFT JOIN ECOLI_DATA AS t2 ON (t1.PARENT_ID = t2.ID)
LEFT JOIN ECOLI_DATA AS t3 ON (t2.PARENT_ID = t3.ID)
WHERE t3.PARENT_ID IS null
AND t3.ID IS NOT null
ORDER BY t1.ID