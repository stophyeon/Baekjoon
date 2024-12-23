SELECT b.BOOK_ID, a.AUTHOR_NAME, date_format(b.PUBLISHED_DATE,"%Y-%m-%d") as  PUBLISHED_DATE 
FROM BOOK as b
inner join AUTHOR as a 
ON  b.CATEGORY="경제" and a.AUTHOR_ID=b.AUTHOR_ID
order by b.PUBLISHED_DATE ASC;