package com.nhncorp.study.board.controller;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nhncorp.study.board.mapper.BoardUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/datasource-context.xml", "/mybatis-context.xml"})
public class DBInitialTest {
	@Autowired
	DataSource dataSource;
	@Autowired
	BoardUserMapper userMapper;
	
	@Test
	public void testNotNull() {
		assertNotNull(dataSource);
	}

	@Test
	public void testGetId() throws SQLException {
		Connection connection = dataSource.getConnection();
		Statement s = connection.createStatement();
		ResultSet rs = s.executeQuery("select * from board_user");
		while(rs.next()){
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
		}
	}
	
	@Test
	public void test(){
		System.out.println(userMapper.getUser("geun").getEmail());
	}
}
