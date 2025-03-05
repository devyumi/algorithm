SELECT ID, FISH_NAME, LENGTH
FROM fish_name_info fni
         JOIN fish_info fi ON fni.fish_type = fi.fish_type
WHERE length = (
    SELECT MAX(length)
    FROM fish_info fi2
    WHERE fi2.fish_type = fi.fish_type
);