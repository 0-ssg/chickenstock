package ssg.com.a.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssg.com.a.dto.PdsDto;

@Repository
public class PdsDaoImpl implements PdsDao{

	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> pdslist() {

		return session.selectList(ns + "pdslist");
	}

	@Override
	public int uploadPds(PdsDto pds) {
		// TODO Auto-generated method stub
		return session.insert(ns + "uploadPds", pds);
	}

	// 다운로드
	@Override
	public PdsDto getPds(int seq) {
		return session.selectOne(ns + "getPds", seq);
	}
	
	
	
}
