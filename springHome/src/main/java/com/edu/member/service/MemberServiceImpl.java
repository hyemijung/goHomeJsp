package com.edu.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.member.dao.MemberDao;
import com.edu.member.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	public MemberDao memberDao; // 비지니스로직은 데이터베이스를 기초로하기때문에 memberDao를 인스턴스 변수로

	@Override
	public List<MemberVo> memberSelectList() {

//		List<MemberVo> list = memberDao.memberSelectList();

//		String name = list.get(0).getName();
//				
//		if("홍길동".equals(name)) {
//			System.out.println("확실해" + name);
//		}

//		return list;

		return memberDao.memberSelectList();
	}

	@Override
	public MemberVo memberExist(Map<String, Object> paramMap) {

		MemberVo memberVo = memberDao.memberExist(paramMap);

		return memberVo;
		
// 리턴값을 보내는 것이므로 위의 두줄을 생략하여 아래 한줄로 처리해도된다. 
//		membervo의 주소를 보내는것 뿐이다
//		return memberDao.memberExist(paramMap); 

	}

	@Override
	public int memberInsertOne(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return memberDao.memberInsertOne(memberVo);
	}
}