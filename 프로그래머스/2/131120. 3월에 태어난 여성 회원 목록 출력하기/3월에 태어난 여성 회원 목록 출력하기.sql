SELECT m.MEMBER_ID, m.MEMBER_NAME, m.GENDER, date_format(m.DATE_OF_BIRTH,"%Y-%m-%d") AS DATE_OF_BIRTH
from member_profile as m 
where m.GENDER="w" and substring(m.date_of_birth,7,1)=3 and m.tlno is not null 
order by m.member_id ASC;