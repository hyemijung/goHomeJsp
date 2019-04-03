package com.edu.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.vo.MemberVo;
@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	public MemberDao memberDao;
	
	@Override
	public List<MemberVo> memberSelectList(){
		
//		List<MemberVo> list = memberDao.memberSelectList();
//		String name = list.get(0).getName();
//		list.get(0).setName("홍길동");
//		if ("홍길동".equals(name)) {
//		}
		return memberDao.memberSelectList();
	}

	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		MemberVo memberVo = memberDao.memberExist(paramMap);
		
//		memberDao.memberExist(paramMap) <- 오류는 아니지만 이렇게 쓰면 메서드 실행되고 생겼다가 바로 사라짐
		//여기서만 쓰고 사라지는 33라인일 뿐임
		
		return memberVo;
		//결국은 주소만 보내주는것임
		//return memberDAO.memberExist(paramMap)이랑 같음
	}
	//Dao와 service가 햇갈린다면?
	//service의 return 은 memberDao임!
	
	public int memberInsertOne(MemberVo memberVo) {
		
		return memberDao.memberInsertOne(memberVo);
	}

	@Override
	public MemberVo memberSelectOne(int no) {
		// TODO Auto-generated method stub
		return memberDao.memberSelectOne(no);
	}

	@Override
	public int memberUpdateOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberUpdateOne(memberVo);
	}
	
	
	
	
}
