/*
 * @(#)ArticleListController.java $version 2012. 12. 20.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.service.ArticleService;

/**
 * @author nhn
 */
@Controller
public class ArticleListController {
	@Autowired
	ArticleService service;

	public String showArticles(ArticleSearchParam searchParam, Model model) {
		List<Article> articles = service.getArticles(searchParam);
		model.addAttribute("articleList", articles);
		return "article/list";
	}
}
