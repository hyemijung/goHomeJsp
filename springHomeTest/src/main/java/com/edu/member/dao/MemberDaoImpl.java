package com.edu.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sqlSession;
	
	String namespace = "com.edu.member.";
	
	@Override
	public List<MemberVo> memberSelectList() {

		return sqlSession.selectList("com.edu.member.memberSelectList");
	}

	//1 맵방식
	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.edu.member.memberExist", paramMap);
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInsertOne", 
				memberVo);
	}

	// 모델방식
	@Override
	public MemberVo memberExist1(MemberVo paramMemberMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberExist1", paramMemberMap);
	}
	
	
	
}
