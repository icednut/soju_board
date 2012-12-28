/*
 * @(#)ArticleService.java $version 2012. 12. 20.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.service;

import java.util.List;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;

/**
 * @author nhn
 */
public interface ArticleService {

	/**
	 * @param searchParam
	 */
	List<Article> getArticles(ArticleSearchParam searchParam);

}
