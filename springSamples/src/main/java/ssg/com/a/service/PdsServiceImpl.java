package ssg.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssg.com.a.dao.PdsDao;
import ssg.com.a.dto.PdsDto;

@Service
public class PdsServiceImpl implements PdsService{
	
	@Autowired
	PdsDao dao;

	@Override
	public List<PdsDto> pdslist() {
		return dao.pdslist();
	}

	@Override
	public boolean uploadPds(PdsDto pds) {
		return dao.uploadPds(pds)>0;
	}
	
	
	
}
