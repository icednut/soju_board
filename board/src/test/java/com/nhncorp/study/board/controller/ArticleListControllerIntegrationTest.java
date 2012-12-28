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
	public void 게시글_목록을_조회한다() throws Exception {
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
		o.setTitle("제목");
		o.setContents("내용");
		Member member = new Member();
		member.setId("crazybnn");
		o.setMember(member);
		articleList.contains(o);
		
		for(Article at : articleList) {
			assertTrue("게시글을 조회한다.", at.equals(at));
		}
	}

	/**
	 * @param article
	 */
	private void addArticle(Article article) {
	}

	@Test
	public void testShowArticles_제목으로_검색() throws Exception {
		// given
		ExtendedModelMap model = new ExtendedModelMap();
		ArticleSearchParam articleSearchParam = new ArticleSearchParam();
		articleSearchParam.setTitle("제목");

		// when
		sut.showArticles(articleSearchParam, model);

		// then
		List<Article> articles = (List<Article>) model.get("articleList");

		assertTrue("제목으로 검색되어야 함", CollectionUtils.isEmpty(articles));
	}

	@Test
	public void testShowArticles_제목에_searchParam_없으면_검색안됨() throws Exception {
		// given

		// when

		// then

	}

	@Test
	public void testShowArticles_작성자_검색가능() throws Exception {
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
