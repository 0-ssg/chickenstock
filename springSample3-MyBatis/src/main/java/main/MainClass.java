package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BbsDto;
import dto.BbsParam;
import dto.MemberDto;

public class MainClass {
	public static void main(String[] args) throws IOException {
		// configration(설정)
		InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
		
		// SqlSessionFactory 객체를 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		// SqlSession 객체를 생성  <- Database 접근 가능해짐
		SqlSession session = factory.openSession();
		
		// insert
		/*
		MemberDto dto = new MemberDto("aabb", "1122", "이승철", "aadd@daum.net", 0);
		
		int count = session.insert("addmember", dto);
		if(count > 0) {
			session.commit();	// Db에 적용
			System.out.println("추가성공!");
		}else {
			session.rollback(); // 취소
			System.out.println("추가실패");
		}
		*/
		
		//select(1개의 row)
		/*
		String id = "aabb";
		MemberDto mem = session.selectOne("getMember", id);
		System.out.println(mem.toString());
		*/
		
		// select(다수의 row)
		/*
		List<MemberDto> list = session.selectList("allMember");
		for (MemberDto m : list){
			System.out.println(m.toString());
		}
		*/
		
		// delete
		/*
		String name = "aabb";
		session.insert("delMember", name);
		session.commit();
		List<MemberDto> list = session.selectList("allMember");
		for (MemberDto m : list){
			System.out.println(m.toString());
		}
		*/
		
		// update
		/*
		MemberDto dto = new MemberDto("asd", null, "이승철", "dltmdcjf@gmail.com", 0);
		//MemberDto dto = new MemberDto("asd", "이승철", "dltmdcjf@gmail.com");

		session.insert("upMember", dto);
		session.commit();
		List<MemberDto> list = session.selectList("allMember");
		for (MemberDto m : list){
			System.out.println(m.toString());
		}
		*/
		
		BbsParam param = new BbsParam("title", "파업");
		List<BbsDto> list = session.selectList("search", param);
		for(BbsDto bbs : list){
			System.out.println(bbs.toString());
		}
	}
}











