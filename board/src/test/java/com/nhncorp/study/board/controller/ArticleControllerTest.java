package com.nhncorp.study.board.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.Member;

public class ArticleControllerTest {

	@Test
	@Ignore
	public void testGetArticleForm() throws Exception {
		Article article = new Article();
		Member member = new Member();
		member.setId("crazybnn");
		member.setName("Lee");
		article.setMember(member);

		MockMvcBuilders.standaloneSetup(new ArticleController()).build()
				.perform(get("/form")).andExpect(status().isOk())
				.andExpect(view().name("article/form"))
				.andExpect(model().attribute("article", article));
	}

	@Test
	@Ignore
	public void testSaveArticlXteForm() throws Exception {
		MockMvcBuilders
				.xmlConfigSetup(("classpath:servlet-context.xml"))
				.build()
				.perform(
						post("/form").param("title", "hello title")
								.param("contents", "hello contents")
								.param("member.id", "crazybnn"))
				.andExpect(view().name("article/view"));
	}

	// @Test
	// public void testSaveArticlXteForm_������_�������() throws Exception {
	// Article expectArticle = new Article();
	// expectArticle.setTitle("hello title");
	// expectArticle.setContents("hello contents");
	//
	// MockMvcBuilders
	// .xmlConfigSetup(("classpath:servlet-context.xml"))
	// .build()
	// .perform(
	// post("/form")
	// .param("title", "hello title")
	// .param("contents", "hello contents")
	// // .param("member.id", "crazybnn")
	// )
	// .andExpect(status().isOk())
	// .andExpect(view().name("article/form"))
	// // .andExpect(model().attributeHasFieldErrors("article", "member"))
	// .andExpect(model().attribute("article", expectArticle));
	// }

	@Test
	public void testGetArticles_게시글_첫목록_얻어오기_성공() throws Exception {
		// given
		List<Article> expectArticleList = new ArrayList<Article>();
		Member member = new Member();
		member.setId("crazybnn");
		member.setName("이완근");
		Article article = new Article();
		article.setTitle("연습1");
		article.setContents("연습1 내용");
		article.setMember(member);
		article.setRegYmdt("2012-12-20 11:23:01");
		expectArticleList.add(article);

		// when & then
		MockMvcBuilders
				.xmlConfigSetup("classpath:root-context.xml",
						"classpath:servlet-context.xml",
						"classpath:datasource-context.xml",
						"classpath:mybatis-context.xml").build()
				.perform(post("/article/list").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("articles", expectArticleList));
	}
}
