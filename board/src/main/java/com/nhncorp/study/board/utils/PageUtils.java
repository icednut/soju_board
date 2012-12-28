/*
 * @(#)PageUtils.java $version 2012. 12. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.nhncorp.study.board.utils;

import lombok.Data;

/**
 * @author nhn
 */
@Data
public class PageUtils {
	private int pagePerArticleCount;

	/**
	 * @param page
	 */
	public int getFrom(int page) {
		return (page - 1) * pagePerArticleCount;
	}

	/**
	 * @param page
	 */
	public int getTo(int page) {
		return page * pagePerArticleCount;
	}
}
