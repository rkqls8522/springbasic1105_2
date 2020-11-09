package com.green.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	//JPA(java persistent API(@Entity))
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;

}
