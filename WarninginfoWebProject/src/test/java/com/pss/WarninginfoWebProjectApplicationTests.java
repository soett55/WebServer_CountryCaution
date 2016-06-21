package com.pss;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WarninginfoWebProjectApplication.class)
@WebAppConfiguration
public class WarninginfoWebProjectApplicationTests {
	@Autowired
	private DataSource ds;


	@Test
	public void contextLoads() {
	}
	@Test
	public void testConnection() throws Exception{
		System.out.println(ds);
		Connection con = ds.getConnection();
		System.out.println(con);
		
		con.close();
	}
}
