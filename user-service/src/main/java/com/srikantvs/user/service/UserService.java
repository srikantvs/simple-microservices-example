package com.srikantvs.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.srikantvs.user.entity.User;
import com.srikantvs.user.repository.UserRepository;
import com.srikantvs.user.vo.Department;
import com.srikantvs.user.vo.ResponseTemplateVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;// to call department microservice

	public User saveUser(User user) {
		log.info("inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("inside getUserWithDepartment of UserService");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		// now we have the user now we need to get the department of this user. that is
		// in another microservice.
		// we will use RestTemplate over here.
//		Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
//				Department.class);

		//not suppose if department service is running on different url with different port then we need to do lot of changes 
		//so we will write the application name here.
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		
		// set the objects in vo
		responseTemplateVO.setDepartment(department);
		responseTemplateVO.setUser(user);
		
		
		return responseTemplateVO;
	}

}
