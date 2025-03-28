-- 코드를 입력하세요
SELECT APT.APNT_NO, PT.PT_NAME, PT.PT_NO, APT.MCDP_CD, DR.DR_NAME, APT.APNT_YMD
FROM APPOINTMENT APT
JOIN PATIENT PT ON PT.PT_NO = APT.PT_NO
JOIN DOCTOR DR ON DR.MCDP_CD = APT.MCDP_CD AND DR.DR_ID = APT.MDDR_ID
WHERE APT.APNT_CNCL_YMD IS NULL
AND DATE(APT.APNT_YMD) = '2022-04-13'
AND APT.MCDP_CD = 'CS'
ORDER BY APT.APNT_YMD ASC;