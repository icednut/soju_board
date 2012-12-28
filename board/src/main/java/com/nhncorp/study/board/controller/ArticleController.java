package com.nhncorp.study.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.model.Member;
import com.nhncorp.study.board.service.ArticleService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	@Autowired
	private ArticleService service;

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getArticleForm(Model model) {
		Article article = new Article();
		Member member = new Member();
		member.setId("crazybnn");
		member.setName("Lee");
		article.setMember(member);
		model.addAttribute("article", article);
		return "article/form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String saveArticleForm(@Valid Article article,
			BindingResult bindingResult, Model model) {
		System.out.println("hello article view");
		model.addAttribute("article", article);

		if (bindingResult.hasErrors()) {
			return "article/form";
		}

		return "article/view";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public @ResponseBody
	Model getArticles(Model model, ArticleSearchParam param) {
		model.addAttribute("articles", service.getArticles(param));
		return model;
	}
}
