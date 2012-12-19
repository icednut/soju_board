package com.nhncorp.study.board.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nhncorp.study.board.model.Article;

@Controller
public class HelloSpringController {
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam String title) {
		System.out.println("hello spring request " + title);
		return new ModelAndView("helloSpring");
	}

	@RequestMapping("/hello2")
	public ModelAndView hello2(@RequestParam String title,
			@RequestParam(value = "cont", required = false, defaultValue = "hello ±è¿µÁø") String contents) {
		System.out.println(title + " " + contents);
		return new ModelAndView("helloSpring");
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(Article article) {
		System.out.println(article.toString());
		ModelAndView mav = new ModelAndView("helloSpring");
		mav.addObject("article", article);
		return mav;
	}
	
	@RequestMapping("/hello4")
	public ModelAndView hello4(String test) {
		System.out.println(test);
		return new ModelAndView("helloSpring");
	}
	
	@RequestMapping("/hello5")
	public ModelAndView hello5(@RequestParam Map<String, Object> params) {
		System.out.println(params);
		ModelAndView mav = new ModelAndView("helloSpring");
		return mav;
	}
	
	@RequestMapping("/helloSpring")
	public ModelAndView helloSpring() {
		System.out.println("helloSpring request arrvied");
		return new ModelAndView("/WEB-INF/helloSpring.jsp");
	}
	
	
}
