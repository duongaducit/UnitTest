package com.asiantech.unittest.service.impl;

import java.util.List;

import com.asiantech.unittest.dao.ServiceDao;
import com.asiantech.unittest.entity.MockitoTest;
import com.asiantech.unittest.service.Service;

public class ServiceImpl implements Service{

	private ServiceDao serviceDao;
	
	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public List<MockitoTest> getList() {
		// TODO Auto-generated method stub
		return serviceDao.getList();
	}

	public void changeResult(String idMock, List<MockitoTest> list) {
		serviceDao.changeResutl(idMock,list);
		
	}

	public void saveDatabase(MockitoTest mock) {
		serviceDao.saveDatabase(mock);
		
	}

}
