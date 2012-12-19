package com.nhncorp.study.board.controller;

import org.junit.Test;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import com.nhncorp.study.board.controller.ArticleController;
import com.nhncorp.study.board.model.Article;
import com.nhncorp.study.board.model.Member;

public class ArticleControllerTest {

	@Test
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
	public void testSaveArticlXteForm() throws Exception {
		MockMvcBuilders
				.xmlConfigSetup(("classpath:servlet-context.xml"))
				.build()
				.perform(
						post("/form")
							.param("title", "hello title")
							.param("contents", "hello contents")
							.param("member.id", "crazybnn"))
				.andExpect(view().name("article/view"));
	}

//	@Test
//	public void testSaveArticlXteForm_제목이_없을경우() throws Exception {
//		Article expectArticle = new Article();
//		expectArticle.setTitle("hello title");
//		expectArticle.setContents("hello contents");
//		
//		MockMvcBuilders
//				.xmlConfigSetup(("classpath:servlet-context.xml"))
//				.build()
//				.perform(
//						post("/form")
//						.param("title", "hello title")
//						.param("contents", "hello contents")
////						.param("member.id", "crazybnn")
//				)
//				.andExpect(status().isOk())
//				.andExpect(view().name("article/form"))
////				.andExpect(model().attributeHasFieldErrors("article", "member"))
//				.andExpect(model().attribute("article", expectArticle));
//	}
}
