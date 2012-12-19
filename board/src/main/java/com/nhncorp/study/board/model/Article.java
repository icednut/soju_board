package com.nhncorp.study.board.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;

@Data
public class Article {
	@NotBlank(message = "������ ����ֽ��ϴ�. ������ �Ԏ��Ͽ� �ּ���.")
	String title;
	String contents;
	Date writeDate;

	@NotNull(message = "�ۼ��� ������ �����ϴ�.")
	Member member;

	public Article() {
		super();
		Member member = new Member();
		member.setId("crazybnn");
		member.setName("Lee");
		this.setMember(member);
	}

}
