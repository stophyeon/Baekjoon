SELECT fh.FLAVOR 
FROM FIRST_HALF as fh 
join ICECREAM_INFO as info 
on info.flavor=fh.flavor
where fh.TOTAL_ORDER>3000 and 
info.INGREDIENT_TYPE = 'fruit_based'
order by fh.TOTAL_ORDER DESC