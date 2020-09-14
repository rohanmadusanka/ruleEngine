package com.hcloud.ruleengine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcloud.ruleengine.model.Reshma;

public interface ReshmaRepository extends JpaRepository<Reshma, Long>{

	
	
	
	/*
	--both ranges
	select * from reshma f 
where 1=1
and ip_range like '%[%-%]%'
and :ipAddress like '%[%-%]%'
and (
(
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)
OR
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)
)
AND
(
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)
OR
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)
)
)

and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)
and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2)




union
	
	
	
	-- db range passing single
	select * from reshma f 
where 1=1
and ip_range like '%[%-%]%'
and :ipAddress  not like '%[%-%]%'
and (
(
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)
AND
CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)
)
)
and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)
and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2)

	union
	--passing single db range
	select * from reshma f 
where 1=1
and :ipAddress like '%[%-%]%'
and ip_range  not like '%[%-%]%'
and (
(
CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)
AND
CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)
)
)
and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)
and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2)

	union
	--both single
	select * from reshma f 
where 1=1
and :ipAddress not like '%[%-%]%'
and ip_range  not like '%[%-%]%'
and CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER) = CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)

and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)
and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2);
	
	
	**/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Query(value = "--both ranges\r\n" + 
			"	select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and ip_range like '%[%-%]%'\r\n" + 
			"and :ipAddress like '%[%-%]%'\r\n" + 
			"and (\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)\r\n" + 
			"OR\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER)\r\n" + 
			")\r\n" + 
			"AND\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)\r\n" + 
			"OR\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) <= CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER)\r\n" + 
			")\r\n" + 
			")\r\n" + 
			"\r\n" + 
			"and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)\r\n" + 
			"and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2)\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"union\r\n" + 
			"	\r\n" + 
			"	\r\n" + 
			"	\r\n" + 
			"	-- db range passing single\r\n" + 
			"	select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and ip_range like '%[%-%]%'\r\n" + 
			"and :ipAddress  not like '%[%-%]%'\r\n" + 
			"and (\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			"AND\r\n" + 
			"CAST (REPLACE(split_part(split_part(ip_range, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			")\r\n" + 
			")\r\n" + 
			"and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)\r\n" + 
			"and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2)\r\n" + 
			"\r\n" + 
			"	union\r\n" + 
			"	--passing single db range\r\n" + 
			"	select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and :ipAddress like '%[%-%]%'\r\n" + 
			"and ip_range  not like '%[%-%]%'\r\n" + 
			"and (\r\n" + 
			"(\r\n" + 
			"CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',1),'[','')AS INTEGER) <= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			"AND\r\n" + 
			"CAST (REPLACE(split_part(split_part(:ipAddress, '.', 3),'-',2),']','')AS INTEGER) >= CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			")\r\n" + 
			")\r\n" + 
			"and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)\r\n" + 
			"and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2)\r\n" + 
			"\r\n" + 
			"	union\r\n" + 
			"	--both single\r\n" + 
			"	select * from reshma f \r\n" + 
			"where 1=1\r\n" + 
			"and :ipAddress not like '%[%-%]%'\r\n" + 
			"and ip_range  not like '%[%-%]%'\r\n" + 
			"and CAST (REPLACE(REPLACE(split_part(ip_range, '.', 3),'[',''),']','')AS INTEGER) = CAST (REPLACE(REPLACE(split_part(:ipAddress, '.', 3),'[',''),']','')AS INTEGER)\r\n" + 
			"\r\n" + 
			"and split_part(ip_range, '.', 1)=split_part(:ipAddress, '.', 1)\r\n" + 
			"and split_part(ip_range, '.', 2)=split_part(:ipAddress, '.', 2);",
            nativeQuery = true)
	List<Reshma> getReshma(@Param("ipAddress") String ipAddress);
	
	
}
