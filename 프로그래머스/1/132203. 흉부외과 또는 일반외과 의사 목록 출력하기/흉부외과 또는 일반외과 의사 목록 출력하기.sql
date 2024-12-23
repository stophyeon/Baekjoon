SELECT DR_NAME,	DR_ID, MCDP_CD,	date_format(HIRE_YMD,"%Y-%m-%d") as HIRE_YMD from doctor where
(doctor.MCDP_CD="CS" or doctor.MCDP_CD="GS") 
order by doctor.HIRE_YMD DESC ,doctor.DR_NAME ASC