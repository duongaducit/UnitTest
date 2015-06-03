package com.asiantech.unittest.dao;

import java.util.List;

import com.asiantech.unittest.entity.MockitoTest;

public interface ServiceDao {

	public List<MockitoTest> getList();

	public void changeResutl(String idMock, List<MockitoTest> list);

	public void saveDatabase(MockitoTest mock);

}
