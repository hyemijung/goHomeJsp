package com.edu.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.member.vo.MemberVo;

@Repository	//Dao : data access object
public class MemberDaoImpl implements MemberDao{
//mvc 모델과 같은 역할을 하도록 구성해줌? 외부접근안되고 스프링 패턴들이 들어가있는 상태
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//repository가 없었다면 메서드 선언하고 주입하고 설정하고 다 했어야 함!
	
	String namespace = "com.edu.member.";
	
	
	@Override
	public List<MemberVo> memberSelectList(int start, int end) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
//		List<MemberVo> memberList = null;
//		
//		memberList = sqlSession.selectList(
//				namespace + "memberSelectList");
				//spring인가, myBatis에서 제공하는 네이밍규칙
//		memberList = new ArrayList<MemberVo>();
//		return memberList;
		
		return sqlSession.selectList(
				namespace + "memberSelectList", map);
	}

	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {
		
		return sqlSession.selectOne(namespace + "memberExist",paramMap);
		//하나만 불러오기때문에 selectOne
	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + "memberInsertOne",memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "memberSelectOne", no);
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace + "memberUpdateOne", memberVo);
	}

	@Override
	public int memberDelete(int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace + "memberDelete", no);
	}

	@Override
	public int memberSelectTatalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(
				namespace + "memberSelectTatalCount");
	}
	
	
}
