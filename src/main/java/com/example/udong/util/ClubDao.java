package com.example.udong.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.udong.repository.H2DB;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClubDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	private static final ClubDao CLUB_DAO = new ClubDao();

	public static ClubDao getInstance(){
		return CLUB_DAO;
	}


	public JSONArray getListJSON(Object dataMap){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray jsonArray = new JSONArray();
		try{
			con = H2DB.getConnection();
			String sql = "SELECT * FROM CLUB";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()){
				JSONObject obj = new JSONObject();
				obj.put("CLUB_NUM", rs.getString("CLUB_NUM"));
				obj.put("CLUB_NAME", rs.getString("CLUB_NAME"));
				obj.put("INTRO", rs.getString("INTRO"));
				obj.put("AREA_NAME", rs.getString("AREA_NAME"));
				obj.put("CONTENT", rs.getString("CONTENT"));
				obj.put("ID", rs.getString("ID"));
				obj.put("INTEREST", rs.getString("INTEREST"));
				obj.put("RECOMMEND", rs.getString("RECOMMEND"));
				jsonArray.add(obj);
			}

		}catch (Exception e){
			e.printStackTrace();
		}finally{
			H2DB.closeJDBC(con, pstmt, rs);
		}
		return jsonArray;
	}

	public Object getList(String sqlMapId, Object dataMap) {
		Object resultObject = sqlSession.selectList(sqlMapId, dataMap);

		return resultObject;
	}

	public Object getObject(String sqlMapId, Object dataMap) {
		Object resultObject = sqlSession.selectOne(sqlMapId, dataMap);

		return resultObject;
	}

	public Object saveObject(String sqlMapId, Object dataMap) {
		Integer resultObject = sqlSession.insert(sqlMapId, dataMap);

		return resultObject;
	}

	public Object updateObject(String sqlMapId, Object dataMap) {
		Integer resultObject = sqlSession.update(sqlMapId, dataMap);

		return resultObject;
	}

	public Object deleteObject(String sqlMapId, Object dataMap) {

		Integer resultObject = sqlSession.delete(sqlMapId, dataMap);
		return resultObject;
	}
}