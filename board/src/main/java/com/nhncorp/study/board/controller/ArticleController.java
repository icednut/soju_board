package com.nhncorp.study.board.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.Member;

@Controller
public class ArticleController {
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
	public String saveArticleForm(@Valid Article article, BindingResult bindingResult, Model model) {
		System.out.println("hello article view");
		model.addAttribute("article", article);

		if (bindingResult.hasErrors()) {
			return "article/form";
		}

		return "article/view";
	}

}
