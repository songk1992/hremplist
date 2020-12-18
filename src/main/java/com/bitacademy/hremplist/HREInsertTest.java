package com.bitacademy.hremplist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class HREInsertTest {

	public static void main(String[] args) {

		HREmpListVo hREmpListVo = new HREmpListVo();
		hREmpListVo.setSsn(050303);
		hREmpListVo.setFirstname("John");
		hREmpListVo.setLastname("Doe");
		hREmpListVo.setWage(1000);
		hREmpListVo.setEmail("jd@company.com");

		boolean result = insert(hREmpListVo);
		if (result) {
			System.out.println("성공!");
		}

	}

	private static boolean insert(HREmpListVo hREmpListVo) {
		boolean result = false;
		Connection conn = null;
		Statement stmt = null;

		try {
			// JDBC Driver 불러오기
			Class.forName("org.mariadb.jdbc.Driver");

			// 연결하기
			String url = "jdbc:mysql://192.168.200.200:3307/webdb?characterEncoding=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// System.out.println("연결 성공!");

			// 3. SQL
			String sql = "insert into emptable values('" + hREmpListVo.getSsn() + "', '" + hREmpListVo.getLastname() + "', '"
					+ hREmpListVo.getFirstname() + "', '" + hREmpListVo.getWage() + "', '" + hREmpListVo.getEmail() + "')";
			stmt = conn.createStatement();
			int updateCount = stmt.executeUpdate(sql);
//			int updateCount = stmt.executeUpdate(

//					
//					);

			result = updateCount == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {

			try {
				// 자원 정리
				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}
}
