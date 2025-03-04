SELECT DISTINCT cp3.CART_ID
FROM (
    SELECT cp1.cart_id
    FROM cart_products cp1
    WHERE name LIKE 'Yogurt'
) AS cp2
JOIN cart_products cp3 ON cp2.cart_id = cp3.cart_id
    AND cp3.name LIKE 'Milk'
ORDER BY cp3.cart_id;