package com.asiantech.unittest.service;

import java.util.List;

import com.asiantech.unittest.entity.*;

public interface Service {
	//method loai 1
	public List<MockitoTest> getList();
	//method loai 2
	public void changeResult(String idMock, List<MockitoTest> list);
	//method loai 3
	public void saveDatabase(MockitoTest mock);
}
