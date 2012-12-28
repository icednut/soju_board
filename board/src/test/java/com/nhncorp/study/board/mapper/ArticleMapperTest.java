/*
 * @(#)ArticleMapperTest.java $version 2012. 12. 20.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;

/**
 * @author nhn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/datasource-context.xml", "/mybatis-context.xml" })
public class ArticleMapperTest {
	@Autowired
	ArticleMapper sut;

	@Test
	public void testSelectArticles() {
		ArticleSearchParam searchParam = new ArticleSearchParam();

		// when
		List<Article> articles = sut.selectArticles(searchParam);

		// then
		assertNotNull(articles);
	}

}
