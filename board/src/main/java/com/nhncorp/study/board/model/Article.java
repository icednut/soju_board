package com.nhncorp.study.board.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;

@Data
public class Article {
	@NotBlank(message = "제목이 비어있습니다. 제목을 입렭하여 주세요.")
	String title;
	String contents;
	Date writeDate;

	@NotNull(message = "작성자 정보가 없습니다.")
	Member member;

	public Article() {
		super();
		Member member = new Member();
		member.setId("crazybnn");
		member.setName("Lee");
		this.setMember(member);
	}

}
