package com.edu.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.vo.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberVo> memberSelectList() {
		// TODO Auto-generated method stub
		
//		List<MemberVo> memberList = null;
//		
//		memberList = sqlSession.selectList("mappers.edu_member.memberSelectList");
//				
//		return memberList;
		return sqlSession.selectList("com.edu.member.memberSelectList");
	}

	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.edu.member.memberExist", paramMap);
	}

	

	
}
