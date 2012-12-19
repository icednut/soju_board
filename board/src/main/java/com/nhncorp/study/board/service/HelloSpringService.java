package com.nhncorp.study.board.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class HelloSpringService implements InitializingBean {
	public void afterPropertiesSet() throws Exception {
		System.out.println("Hello Spring");
	}
}
