package com.example.udong.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.example.udong.repository.H2DB;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    private static final CommentDao COMMENT_DAO = new CommentDao();

    public static CommentDao getInstance() {
        return COMMENT_DAO;
    }

    public JSONArray getListJSON(String postNumber) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONArray jsonArray = new JSONArray();
        try {
            con = H2DB.getConnection();
            String sql = "select * from COMMENT where POST_NUM = " +postNumber + ";";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()){
				JSONObject obj = new JSONObject(); 
            
				obj.put("CO_NUM", rs.getString("CO_NUM"));
				obj.put("POST_NUM", rs.getString("POST_NUM"));
				obj.put("ID", rs.getString("ID"));
				obj.put("CONTENT", rs.getString("CONTENT"));
                obj.put("TIME", rs.getString("TIME"));
                
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
		
		Integer resultObject = sqlSession.delete(sqlMapId,dataMap);
		return resultObject;
	}
}