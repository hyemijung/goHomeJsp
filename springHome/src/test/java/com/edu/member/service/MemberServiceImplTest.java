package com.edu.member.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.member.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		"file:src/main/webapp/WEB-INF/spring/**/*.xml") //(/**/) 중간에 어떤 폴더, 서브폴더까지 와도 된다
//"file:src/main/webapp/WEB-INF/spring/app2/a11/*.xml"
//"file:src/main/webapp/WEB-INF/spring/app/b11/a11*.xml"
//"file:src/main/webapp/WEB-INF/spring/bbp/adda/adfadf/*.xml"

//"file:src/main/webapp/WEB-INF/spring/*/*.xml"   // (/*/)중간에 어떤폴더가 와도된다. 단 한레벨의 폴더만!!! (/*.xml) 어떤 이름의 xml 파일로 와도된다
//"file:src/main/webapp/WEB-INF/spring/app/*.xml"
//"file:src/main/webapp/WEB-INF/spring/bbb/*.xml"

//"file:src/main/webapp/WEB-INF/spring/app/*.xml" //app 폴더아래 어떤이름의 xml파일이 와도된다
@Service
public class MemberServiceImplTest {
	
		
	@Autowired
	public MemberServiceImpl memberServiceImpl; //서비스를 테스트하고 싶으니 이것을 Autowired 한다
	
	@Test
//	@Ignore
	public void testMemberSelectList() {
		
		List<MemberVo> list = memberServiceImpl.memberSelectList();
		
//		list.get(0).getEmail();
		
//		Assert.assertEquals("s1@test.com", list.get(0).getEmail());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getEmail());
			Assert.assertEquals("s1@test.com", list.get(0).getEmail());
			
		}
		
//		Assert.assertTrue(0 < list.size());
		
		
	}

}
