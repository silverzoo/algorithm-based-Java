with tb1 as (
    SELECT *
    FROM USER_INFO
    WHERE YEAR(JOINED) = '2021'
    )

SELECT YEAR(o.SALES_DATE) as 'YEAR',
    MONTH(o.SALES_DATE) as 'MONTH',
COUNT(DISTINCT o.USER_ID) as 'PURCHASED_USERS',
    ROUND(COUNT(DISTINCT o.USER_ID) / total.total_cnt, 1) as 'PUCHASED_RATIO'
FROM ONLINE_SALE o
JOIN tb1 t ON o.USER_ID = t.USER_ID
JOIN (
    SELECT COUNT(*) AS total_cnt
    FROM tb1
    ) total
GROUP BY 1, 2
ORDER BY 1, 2 asc