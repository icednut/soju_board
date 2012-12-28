/*
 * @(#)ArticleServiceImpl.java $version 2012. 12. 20.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhncorp.study.board.mapper.ArticleMapper;
import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;

/**
 * @author nhn
 */
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	/**
	 * @param searchParam
	 * @return
	 * @see com.nhncorp.study.board.service.ArticleService#getArticles(com.nhncorp.study.board.model.ArticleSearchParam)
	 */
	public List<Article> getArticles(ArticleSearchParam searchParam) {
		return articleMapper.selectArticles(searchParam);
	}

}
