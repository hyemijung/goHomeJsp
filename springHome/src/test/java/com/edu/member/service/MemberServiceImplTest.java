package com.edu.member.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.member.vo.MemberVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MemberServiceImplTest {

	
	@Autowired
	public MemberServiceImpl memberServiceImpl;
	
	@Test
	public void testMemberSelectList() {
		
		
		List<MemberVo> list = memberServiceImpl.memberSelectList();
		
//		if (memberServiceImpl.memberSelectList().size() > 0) {
//			
		
		Assert.assertTrue(0 < list.size());
		
//		Assert.assertEquals(expected, actual);
		
							//우리가 생각한 내용 , 실제로 나오는 내용
//		Assert.assertEquals("홍길동", memberServiceImpl.memberSelectList().get(0).getName());
//			String name = memberServiceImpl.memberSelectList().get(0).getName();
			String name = list.get(0).getName();
			
			Assert.assertEquals("희야", name);
			
			String email = list.get(0).getEmail();
			
			Assert.assertEquals("날좀@바라봐", email);
			
			System.out.println(list.get(0).getEmail());
			
			for (int i = 0; i < list.size(); i++) {
				
				System.out.println(list.get(i));
				
			}
			
			
			
			
//			Assert.assertTrue(name.equals("홍길동"));
			
//			Assert.assertTrue(memberServiceImpl.memberSelectList().size() > 0);
		
//		memberServiceImpl.memberSelectList();
//		List<MemberVo> list = memberDao.memberSelectList();
		
//	}
}
	
}
