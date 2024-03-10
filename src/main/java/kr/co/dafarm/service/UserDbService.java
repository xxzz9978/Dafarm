package kr.co.dafarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dafarm.mapper.UserMapper;

@Service
public class UserDbService {

	@Autowired
	private UserMapper userMapper;
	
	
}
