package com.nhncorp.study.board.model;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.validator.constraints.NotBlank;

@Data
//@EqualsAndHashCode(exclude = {"title", "regYmdt", "contents", "member"})
public class Article {
	int seq;
	@NotBlank(message = "error title")
	String title;
	String contents;
	String regYmdt;

	@NotNull(message = "error member")
	Member member;

//	public Article() {
//		super();
//		Member member = new Member();
//		member.setId("crazybnn");
//		member.setName("Lee");
//		this.setMember(member);
//	}

}
