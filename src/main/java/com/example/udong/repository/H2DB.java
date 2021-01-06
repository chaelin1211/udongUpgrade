package com.example.udong.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public interface H2DB {
    // 드라이버 클래스 이름
    public static final String DRIVER_NAME = "org.h2.Driver";

    // DB 연결
    public static final String URL = "jdbc:h2:mem:testdb";
    public static final String USER = "sa";
    public static final String PWD = "";

    // DB 연결 메소드
    public static Connection getConnection() {
        // 1. 드라이버 로딩
        Connection con = null;

        // 2. DB 연결
        con = DriverManager.getConnection(URL, USER, PWD);

        return con;
    }

    // JDBC 닫기
    public static void closeJDBC(Connection con, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
