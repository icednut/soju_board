package com.nhncorp.study.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.model.Member;
import com.nhncorp.study.board.service.ArticleService;
import com.nhncorp.study.board.utils.PageUtils;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	@Autowired
	private ArticleService service;

	@Autowired
	private PageUtils pageUtils;

	@RequestMapping(value = "/form.nhn", method = RequestMethod.GET)
	public String getArticleForm(Model model, ArticleSearchParam param) {
		Member member = param.getMember();
		if (member == null || member.getId() == null) {
			model.addAttribute("errorMessage", "로그인이 되어 있지 않습니다.");
			return "article/list";
		}

		return "article/form";
	}

	@RequestMapping(value = "/addArticle.nhn", method = RequestMethod.POST)
	public String addArticle(@Valid Article article, BindingResult bindingResult, Model model) {
		model.addAttribute("article", article);

		if (bindingResult.hasErrors()) {
			StringBuilder errorMessageBuilder = new StringBuilder();
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError error : allErrors) {
				String errorMessage = error.getDefaultMessage();
				errorMessageBuilder.append(errorMessage);
			}

			return "article/form";
		}

		return "article/view";
	}

	@RequestMapping(value = "/list.nhn")
	public String list() {
		return "article/list";
	}

	@RequestMapping(value = "/getArticles.nhn", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getArticles(ArticleSearchParam param) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int page = param.getPage();
		param.setFrom(pageUtils.getFrom(page));
		param.setTo(pageUtils.getTo(page));

		resultMap.put("articles", service.getArticles(param));
		resultMap.put("page", page);
		System.out.println(resultMap.toString());
		return resultMap;
	}
	
	@RequestMapping(value = "/getArticle.nhn", method = RequestMethod.POST)
	@ResponseBody
	public Article getArticle(ArticleSearchParam param) {
		return service.getArticle(param);
	}
}
