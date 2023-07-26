package com.project.fp01;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class Fp01ApplicationTests {

	private DataSource dataSource;

	@Test
	public void connetionTest() {
		try(Connection connection  = dataSource.getConnection()) {

		} catch (Exception e) {

		}
	}

}
