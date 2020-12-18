package com.bitacademy.hremplist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HREConnectionTest {

	public static void main(String[] args) {

		Connection conn = null;

		try {

			try {

				// JDBC Driver 불러오기
				Class.forName("org.mariadb.jdbc.Driver");

				// 연결하기
				String url = "jdbc:mysql://192.168.200.200:3307/webdb?characterEncoding=utf8";
				conn = DriverManager.getConnection(url, "webdb", "webdb");

				System.out.println("연결 성공!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
