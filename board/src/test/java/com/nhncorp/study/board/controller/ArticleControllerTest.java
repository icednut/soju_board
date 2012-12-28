package com.nhncorp.study.board.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.web.server.setup.ContextMockMvcBuilder;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.ArticleSearchParam;
import com.nhncorp.study.board.model.Member;

public class ArticleControllerTest {
	private static ContextMockMvcBuilder mockMvc;

	@BeforeClass
	public static void setUpBefore() {
		mockMvc = MockMvcBuilders.xmlConfigSetup("classpath:root-context.xml",
				"classpath:servlet-context.xml");
	}

	@Test
	public void testGetArticleForm_로그인이_되어있을_경우() throws Exception {
		Member member = new Member();
		member.setId("crazybnn");
		member.setName("이완근");

		mockMvc.build()
				.perform(
						get("/article/form.nhn")
							.param("member.id", member.getId())
							.param("member.name", member.getName()))
				.andExpect(status().isOk())
				.andExpect(view().name("article/form"));
	}

	@Test
	public void testGetArticleForm_로그인이_되어있지_않은_경우() throws Exception {
		mockMvc.build()
				.perform(get("/article/form.nhn"))
				.andExpect(status().isOk())
				.andExpect(view().name("article/list"))
				.andExpect(model().attribute("errorMessage", "로그인이 되어 있지 않습니다."));
	}

	@Test
	public void testAddArticle_로그인이_되어있을_경우() throws Exception {
		mockMvc.build()
			.perform(
					post("/article/addArticle.nhn")
						.param("title", "hello title")
						.param("contents", "hello contents")
						.param("member.id", "crazybnn"))
			.andExpect(view().name("article/view"));
	}

	@Test
	public void testAddArticle_로그인이_되어있지_않은_경우() throws Exception {
		mockMvc.build()
			.perform(
					post("/article/addArticle")
						.param("title", "hello title")
						.param("contents", "hello contents"))
			.andExpect(view().name("article/form"))
			.andExpect(model().attribute("errorMessage", "로그인 정보가 없습니다."));;
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
	public void testGetListPage() throws Exception {
		// given

		// when

		// then
		mockMvc.build().perform(get("/article/list.nhn"))
				.andExpect(status().isOk())
				.andExpect(view().name("article/list"));
	}

	@Test
	public void testGetArticles_게시글_첫목록_얻어오기_성공() throws Exception {
		// given
		Member member = new Member();
		member.setId("crazybnn");

		Article article1 = new Article();
		article1.setSeq(1);
		article1.setTitle("TEST 1");
		article1.setContents("TEST 1 content");
		article1.setMember(member);
		article1.setRegYmdt("2012-12-20 11:23:01");
		article1.setViewCount(10);

		Article article2 = new Article();
		article2.setSeq(2);
		article2.setTitle("TEST 2");
		article2.setContents("TEST 2 content");
		article2.setMember(member);
		article2.setRegYmdt("2012-12-21 11:23:01");
		article2.setViewCount(40);

		Article article3 = new Article();
		article3.setSeq(3);
		article3.setTitle("TEST 3");
		article3.setContents("TEST 3 content");
		article3.setMember(member);
		article3.setRegYmdt("2012-12-22 11:23:01");
		article3.setViewCount(32);

		Article article4 = new Article();
		article4.setSeq(4);
		article4.setTitle("TEST 4");
		article4.setContents("TEST 4 content");
		article4.setMember(member);
		article4.setRegYmdt("2012-12-24 11:23:01");
		article4.setViewCount(80);

		List<Article> expectArticleList = new ArrayList<Article>();
		expectArticleList.add(article1);
		expectArticleList.add(article2);
		expectArticleList.add(article3);
		expectArticleList.add(article4);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articles", expectArticleList);
		resultMap.put("page", 1);

		// when & then
		mockMvc.build()
				.perform(post("/article/getArticles.nhn").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(content().type("application/json;charset=UTF-8"));
		// .andExpect(content().string(resultMap.toString()));
	}

	@Test
	public void testGetArticles_게시글_제목으로_검색_성공() throws Exception {
		// given
		Member member = new Member();
		member.setId("crazybnn");

		ArticleSearchParam param = new ArticleSearchParam();
		param.setPage(1);
		param.setMember(member);

		Article article = new Article();
		article.setSeq(4);
		article.setTitle("TEST 4");
		article.setContents("TEST 4 content");
		article.setMember(member);
		article.setRegYmdt("2012-12-24 11:23:01");
		article.setViewCount(80);

		List<Article> expectArticleList = new ArrayList<Article>();
		expectArticleList.add(article);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articles", expectArticleList);
		resultMap.put("page", 1);

		// when & then
		mockMvc.build()
				.perform(
						post("/article/getArticles.nhn").param("title",
								"TEST 1").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(content().type("application/json;charset=UTF-8"));
		// .andExpect(content().string(resultMap.toString()));
	}

	@Test
	public void testGetArticles_게시글_작성자_아이디로_검색_성공() throws Exception {
		// given
		Member member = new Member();
		member.setId("aretias");

		ArticleSearchParam param = new ArticleSearchParam();
		param.setPage(1);
		param.setMember(member);

		Article article = new Article();
		article.setSeq(4);
		article.setTitle("TEST 4");
		article.setContents("TEST 4 content");
		article.setMember(member);
		article.setRegYmdt("2012-12-24 11:23:01");
		article.setViewCount(80);

		List<Article> expectArticleList = new ArrayList<Article>();
		expectArticleList.add(article);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articles", expectArticleList);
		resultMap.put("page", 1);

		// when & then
		mockMvc.build()
				.perform(
						post("/article/getArticles.nhn").param("member.id",
								"aretias").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(content().type("application/json;charset=UTF-8"));
		// .andExpect(content().string(resultMap.toString()));
	}

	@Test
	public void testGetArticles_게시글_내용으로_검색_성공() throws Exception {
		// given
		Member member = new Member();
		member.setId("crazybnn");

		ArticleSearchParam param = new ArticleSearchParam();
		param.setPage(1);
		param.setContents("TEST 3");

		Article article = new Article();
		article.setSeq(3);
		article.setTitle("TEST 3");
		article.setContents("TEST 3 content");
		article.setMember(member);
		article.setRegYmdt("2012-12-22 11:23:01");
		article.setViewCount(32);

		List<Article> expectArticleList = new ArrayList<Article>();
		expectArticleList.add(article);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articles", expectArticleList);
		resultMap.put("page", 1);

		// when & then
		mockMvc.build()
				.perform(
						post("/article/getArticles.nhn").param("contents",
								"TEST 3").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(content().type("application/json;charset=UTF-8"));
		// .andExpect(content().string(resultMap.toString()));
	}

	@Test
	public void testGetArticles_게시글_조회수가_많은_글로_정렬하여_조회() throws Exception {
		// given
		Member member = new Member();
		member.setId("crazybnn");

		ArticleSearchParam param = new ArticleSearchParam();
		param.setPage(1);
		param.setOrderingType("viewCount");

		Article article1 = new Article();
		article1.setSeq(1);
		article1.setTitle("TEST 1");
		article1.setContents("TEST 1 content");
		article1.setMember(member);
		article1.setRegYmdt("2012-12-20 11:23:01");
		article1.setViewCount(10);

		Article article2 = new Article();
		article2.setSeq(3);
		article2.setTitle("TEST 3");
		article2.setContents("TEST 3 content");
		article2.setMember(member);
		article2.setRegYmdt("2012-12-22 11:23:01");
		article2.setViewCount(32);

		Article article3 = new Article();
		article3.setSeq(2);
		article3.setTitle("TEST 2");
		article3.setContents("TEST 2 content");
		article3.setMember(member);
		article3.setRegYmdt("2012-12-21 11:23:01");
		article3.setViewCount(40);

		Article article4 = new Article();
		article4.setSeq(4);
		article4.setTitle("TEST 4");
		article4.setContents("TEST 4 content");
		article4.setMember(member);
		article4.setRegYmdt("2012-12-24 11:23:01");
		article4.setViewCount(80);

		List<Article> expectArticleList = new ArrayList<Article>();
		expectArticleList.add(article1);
		expectArticleList.add(article2);
		expectArticleList.add(article3);
		expectArticleList.add(article4);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articles", expectArticleList);
		resultMap.put("page", 1);

		// when & then
		mockMvc.build()
				.perform(
						post("/article/getArticles.nhn").param("orderingType",
								"viewCount").param("page", "1"))
				.andExpect(status().isOk())
				.andExpect(content().type("application/json;charset=UTF-8"));
		// .andExpect(content().string(resultMap.toString()));
	}
}
