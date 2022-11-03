package com.traditional.yoga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.repository.LoginUserRepository;
import com.traditional.yoga.repository.ModelRepository;
import com.traditional.yoga.repository.RolePermissionRepository;
import com.traditional.yoga.repository.RoleRepository;
import com.traditional.yoga.repository.SubModelRepository;

@Service
public class UserManagementService {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementService.class);

	@Autowired
	LoginUserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	SubModelRepository subModelRepository;

	@Autowired
	RolePermissionRepository rolePermissionRepository;

	public Object getAll(String operationType) {
		Response response = new Response();
		HttpStatus httpStatus;
		String message;

		try {
			if (operationType.equals("users")) {
				return userRepository.findAll();
			} else if (operationType.equals("modules")) {
				return modelRepository.findAll();
			} else if (operationType.equals("submodules")) {
				return subModelRepository.findAll();
			} else if (operationType.equals("roles")) {
				System.out.println("sads");
				System.out.println(roleRepository.findAll());
				return roleRepository.findAll();
			} else {
				message = "Unknown Operation";
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
				response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
				return new ResponseEntity<>(response, httpStatus);
			}

		} catch (Exception e) {

			message = "Unknown Error";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), httpStatus.getReasonPhrase());
			return new ResponseEntity<>(response, httpStatus);
		}

	}
}
