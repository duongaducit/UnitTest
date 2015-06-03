package com.asiantech.unittest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.asiantech.unittest.dao.ServiceDao;
import com.asiantech.unittest.entity.*;
import com.asiantech.unittest.service.impl.ServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	// gia lap database
	@Spy
	List<MockitoTest> listDB = new ArrayList<MockitoTest>();

	// @InjectMocks: yeu cau MockitoJUnitRunner tao gia tri cho bien,
	@InjectMocks
	private ServiceImpl serviceImpl;

	// khoi tao doi tuong se mock
	@Mock
	private ServiceDao serviceDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		// gia lap ham getlist
		Mockito.when(serviceDao.getList()).then(
				new Answer<List<MockitoTest>>() {

					public List<MockitoTest> answer(InvocationOnMock invocation)
							throws Throwable {
						List<MockitoTest> list = new ArrayList<MockitoTest>();
						for (int i = 0; i < 10; i++) {
							list.add(new MockitoTest("Mock_" + i, "Result_" + i));
						}
						return list;
					}
				});
		// gia lap ham change
		Mockito.doAnswer(new Answer<List<MockitoTest>>() {
			public List<MockitoTest> answer(InvocationOnMock invocation)
					throws Throwable {
				String id = (String) invocation.getArguments()[0];
				List<MockitoTest> list = (List<MockitoTest>) invocation
						.getArguments()[1];

				for (int i = 0; i < list.size(); i++) {
					if (id.equals(list.get(i).getIdMock())) {
						list.get(i).setResutlMock("Result Change");
					}
				}
				return list;
			}
		}).when(serviceDao)
				.changeResutl(Mockito.anyString(), Mockito.anyList());
		// gia lap ham save
		Mockito.doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				MockitoTest mock = (MockitoTest) invocation.getArguments()[0];
				listDB.add(mock);
				return null;
			}
		}).when(serviceDao).saveDatabase(Mockito.any(MockitoTest.class));

	}

	@Test
	public void testGetList() {
		List<MockitoTest> list = serviceImpl.getList();
		Assert.assertEquals(list.size(), 10);
	}

	@Test
	public void testChangeResult() {
		List<MockitoTest> list = serviceImpl.getList();
		serviceImpl.changeResult("Mock_0", list);
		Assert.assertEquals("Result Change", list.get(0).getResutlMock());
	}

	//
	@Test
	public void testSaveDatabase() {
		serviceImpl.saveDatabase(new MockitoTest("Mock_s", "Result_s"));
		Assert.assertEquals(listDB.size(), 1);
	}

}
