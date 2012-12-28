/*
 * @(#)ArticleSearchParam.java $version 2012. 12. 20.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.model;

import lombok.Data;

/**
 * @author nhn
 */
@Data
public class ArticleSearchParam {
	private int page;
	private String title;
	private Member member;
}
