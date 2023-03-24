package org.geon.study.jdbc;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Log4j2
public class JDBCTest {

    @Test
    public void connectionTest() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        log.info("---------------jdbc---------------");
        String url = "jdbc:mysql://35.188.000.000:3306/";
        String username = "test";
        String password = "test";

        Connection connection = DriverManager.getConnection(url, username, password);

        log.info(connection);

        connection.close();
    }
}
