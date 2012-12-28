package com.nhncorp.study.board.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;

@Data
// @EqualsAndHashCode(exclude = {"title", "regYmdt", "contents", "member"})
public class Article {
	private int seq;
	@NotBlank(message = "error title")
	private String title;
	private String contents;
	private String regYmdt;
	private int viewCount;

	@NotNull(message = "로그인 정보가 없습니다.")
	private Member member;
}
