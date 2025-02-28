SELECT flavor AS FLAVOR
FROM (SELECT j.shipment_id, SUM(j.total_order) AS total_order
      FROM july j
      GROUP BY j.flavor) sj
         JOIN first_half fh ON sj.shipment_id = fh.shipment_id
GROUP BY flavor
HAVING SUM(fh.total_order + sj.total_order)
ORDER BY SUM(fh.total_order + sj.total_order) DESC
LIMIT 3;