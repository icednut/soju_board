/*
 * @(#)ArticleListControllerIntegrationTest.java $version 2012. 12. 20.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.util.CollectionUtils;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.model.Member;

/**
 * @author nhn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/servlet-context.xml", "/root-context.xml" })
public class ArticleListControllerIntegrationTest {
	@Autowired
	ArticleListController sut;

	@Test
	public void �Խñ�_�����_��ȸ�Ѵ�() throws Exception {
		// given
		Article article = new Article();
		article.setTitle("articleTitle");
		article.setContents("articleContent");
		addArticle(article);
		ExtendedModelMap model = new ExtendedModelMap();

		// when
		String viewName = sut.showArticles(new ArticleSearchParam(), model);

		// then
		assertEquals("article/list", viewName);
		List<Article> articleList = (List<Article>) model.get("articleList");

		Article o = new Article();
		o.setSeq(1);
		o.setTitle("����");
		o.setContents("����");
		Member member = new Member();
		member.setId("crazybnn");
		o.setMember(member);
		articleList.contains(o);
		
		for(Article at : articleList) {
			assertTrue("�Խñ��� ��ȸ�Ѵ�.", at.equals(at));
		}
	}

	/**
	 * @param article
	 */
	private void addArticle(Article article) {
	}

	@Test
	public void testShowArticles_��������_�˻�() throws Exception {
		// given
		ExtendedModelMap model = new ExtendedModelMap();
		ArticleSearchParam articleSearchParam = new ArticleSearchParam();
		articleSearchParam.setTitle("����");

		// when
		sut.showArticles(articleSearchParam, model);

		// then
		List<Article> articles = (List<Article>) model.get("articleList");

		assertTrue("�������� �˻��Ǿ�� ��", CollectionUtils.isEmpty(articles));
	}

	@Test
	public void testShowArticles_����_searchParam_������_�˻��ȵ�() throws Exception {
		// given

		// when

		// then

	}

	@Test
	public void testShowArticles_�ۼ���_�˻�����() throws Exception {
		// given

		// when

		// then

	}
	
	@Test
	public void testName() throws Exception {
		// given

		// when

		// then
		
	}
}
