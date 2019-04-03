package com.edu.member.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.member.service.MemberServiceImpl;
import com.edu.member.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MemberDaoImplTest {

	@Autowired //이 자체가 함수 호출과 같은 작동시키는 힘이 있음..
	public MemberDaoImpl memberDaoImpl;
	
	@Autowired
	public MemberServiceImpl memberServiceImpl;
	
	@Test
	public void testMemberSelectList() {
		
		memberDaoImpl.memberSelectList();
		
		if (memberServiceImpl.memberSelectList().size() > 0) {
			
			String name = memberServiceImpl.memberSelectList().get(0).getName();
			
			
//			Assert.assertTrue(name.equals("홍길동"));
			
			Assert.assertEquals("희야", name);
			
			Assert.assertTrue(memberServiceImpl.memberSelectList().size() > 0);
//		memberServiceImpl.memberSelectList();
//		List<MemberVo> list = memberDaoImpl.memberSelectList();
	}
	}
	
//	@Ignore
//	public void testMemberSelectList() {
//		// TODO Auto-generated method stub
//		
//		List<MemberVo> memberList = memberDaoImpl.memberSelectList();
//		
//		Assert.assertNotNull(memberDaoImpl.memberSelectList());
//		Assert.assertNotNull(memberList);
//		
////		Assert.assertEquals("홍길동", memberList.get(0).getName());
////		Assert.assertTrue("홍길동".equals(memberList.get(0).getName()));
////		Assert.assertTrue(1<memberList.size());
//		
//		Assert.assertEquals(memberList,memberDaoImpl.memberSelectList() );
//		
////		memberDaoImpl.memberSelectList();
//		
//		
//	}
	
}
