package com.example.udong.util;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public MemberBean getObject(String sqlMapId, MemberBean dataMap) {
        MemberBean resultObject = sqlSession.selectOne(sqlMapId, dataMap);

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