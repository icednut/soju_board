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
		
		Article article1 = new Article();
		article1.setSeq(1);
		article1.setTitle("TEST 1");
		article1.setContents("TEST 1 content");
		article1.setMember(member);
		article1.setRegYmdt("2012-12-20 11:23:01");

		Article article2 = new Article();
		article2.setSeq(2);
		article2.setTitle("TEST 2");
		article2.setContents("TEST 2 content");
		article2.setMember(member);
		article2.setRegYmdt("2012-12-21 11:23:01");

		Article article3 = new Article();
		article3.setSeq(3);
		article3.setTitle("TEST 3");
		article3.setContents("TEST 3 content");
		article3.setMember(member);
		article3.setRegYmdt("2012-12-22 11:23:01");		
		
		expectArticleList.add(article1);
		expectArticleList.add(article2);
		expectArticleList.add(article3);

		// when & then
		MockMvcBuilders
				.xmlConfigSetup("classpath:root-context.xml",
						"classpath:servlet-context.xml").build()
				.perform(post("/article/list").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("articles", expectArticleList));
	}
}
