-- 코드를 입력하세요
WITH A AS (
SELECT MAX(PRICE) AS MAX_PRICE FROM FOOD_PRODUCT)

SELECT PRODUCT_ID,PRODUCT_NAME,PRODUCT_CD,CATEGORY,PRICE
FROM FOOD_PRODUCT, A
WHERE PRICE = A.MAX_PRICE

-- 다른방법
# SELECT *
# FROM FOOD_PRODUCT
# ORDER BY PRICE DESC
# LIMIT 1