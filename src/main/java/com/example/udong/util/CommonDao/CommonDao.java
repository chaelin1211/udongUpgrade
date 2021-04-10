package com.example.udong.util.CommonDao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommonDao {
    @Autowired
    private SqlSessionTemplate sqlSession;
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