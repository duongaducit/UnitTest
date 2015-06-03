package com.asiantech.unittest.entity;

public class MockitoTest {
	private String idMock;
	private String resutlMock;

	public String getIdMock() {
		return idMock;
	}

	public void setIdMock(String idMock) {
		this.idMock = idMock;
	}

	public String getResutlMock() {
		return resutlMock;
	}

	public void setResutlMock(String resutlMock) {
		this.resutlMock = resutlMock;
	}

	public MockitoTest(String idMock, String resutlMock) {
		super();
		this.idMock = idMock;
		this.resutlMock = resutlMock;
	}
	
}
