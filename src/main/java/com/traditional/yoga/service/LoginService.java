package com.traditional.yoga.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.RolePermissions;
import com.traditional.yoga.dto.SubModules;
import com.traditional.yoga.dto.request.LoginRequest;
import com.traditional.yoga.dto.response.LoginResponse;
import com.traditional.yoga.model.ModuleModel;
import com.traditional.yoga.model.PermissionModel;
import com.traditional.yoga.model.RoleModel;
import com.traditional.yoga.model.RolePermissionModel;
import com.traditional.yoga.model.SubModuleModel;
import com.traditional.yoga.model.UserModel;
import com.traditional.yoga.repository.ModelRepository;
import com.traditional.yoga.repository.PermissionRepository;
import com.traditional.yoga.repository.RolePermissionRepository;
import com.traditional.yoga.repository.RoleRepository;
import com.traditional.yoga.repository.SubModelRepository;
import com.traditional.yoga.repository.UserRepository;

@Service
public class LoginService {

	private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	UserRepository loginUserRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModelRepository modelRepository;

	@Autowired
	SubModelRepository subModelRepository;

	@Autowired
	RolePermissionRepository rolePermissionRepository;

	@Autowired
	PermissionRepository permissionRepository;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

	/**
	 * @param userDetails
	 * @return
	 */
	public Object loginUser(LoginRequest userDetails) {
		LoginResponse loginResponse = new LoginResponse();

		LOG.info("Checking for bad Request");
		Boolean checkingUser = userDetails.getUserName() == null || userDetails.getUserName().isBlank();
		if (Boolean.FALSE.equals(checkingUser)) {
			UserModel userData = loginUserRepository.getUserByName(userDetails.getUserName());
			Boolean validateUser = validatingUser(userData, userDetails);
			if (Boolean.TRUE.equals(validateUser)) {
				loginResponse.setUserId(userData.getUserName());
				loginResponse.setRoleId(userData.getRoleId());

				RoleModel role = roleRepository.getRoleById(userData.getRoleId());
				loginResponse.setUserRole(role.getRoleName());
				loginResponse.setRoleStatus(role.getActive());

				LOG.info("Fletching Role Permissions");
				List<RolePermissionModel> permissionData = rolePermissionRepository
						.getPermissionByroleId(userData.getRoleId());
				List<RolePermissions> permission = getModuleScreenMap(permissionData);
				loginResponse.setPermissions(permission);

				LOG.info("Assiging Token");
				loginResponse.setUserToken("empty");

				message = "Login Sucessfully";
				httpStatus = HttpStatus.OK;
				response = new Response(message, httpStatus.value(), null);
				LOG.info(message);
				loginResponse.setResponse(response);
			} else {
				httpStatus = HttpStatus.UNAUTHORIZED;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
				loginResponse.setResponse(response);
			}
		} else {
			message = "Bad User Details";
			httpStatus = HttpStatus.NOT_ACCEPTABLE;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
			loginResponse.setResponse(response);
		}

		return new ResponseEntity<>(loginResponse, httpStatus);
	}

	/**
	 * @param userData
	 * @param userDetails
	 * @return
	 */
	private Boolean validatingUser(UserModel userData, LoginRequest userDetails) {
		LOG.info("Checking for user exsits");
		Boolean validateUser = userData == null || userData.getUserName().isBlank();
		Boolean checkingPassword = userDetails.getPassword() == null || userDetails.getPassword().isBlank();
		if (Boolean.TRUE.equals(validateUser)) {
			message = "Unauthorized user, Please check the user details";
			return false;
		} else if (Boolean.TRUE.equals(checkingPassword)) {
			message = "Password is required, Please check the user details";
			return false;
		} else if (!userDetails.getPassword().equals(userData.getPassword())) {
			message = "Password is not Matching, Please check the user details";
			return false;
		}
		return true;
	}

	/**
	 * @param rolePermissions
	 * @return
	 */
	public List<RolePermissions> getModuleScreenMap(List<RolePermissionModel> rolePermissions) {
		int moduleTemp = 2;

		List<RolePermissions> permissions = new ArrayList<>();
		List<SubModules> subModuleList = new ArrayList<>();
		RolePermissions moduleList = new RolePermissions();

		for (RolePermissionModel eachPermission : rolePermissions) {
			SubModules subModules = new SubModules();
			SubModuleModel subModulesName = subModelRepository.getSubModuleById(eachPermission.getSubModuleId());
			PermissionModel permissionName = permissionRepository.getPermissionById(eachPermission.getPermissionId());
			subModules.setSubModuleId(eachPermission.getSubModuleId());
			subModules.setSubModuleName(subModulesName.getSubModuleName());
			subModules.setPermissionId(eachPermission.getPermissionId());
			subModules.setPermissionName(permissionName.getPermissionName());
			subModuleList.add(subModules);

			Boolean st = rolePermissions.indexOf(eachPermission) == (rolePermissions.size() - 1);
			if (eachPermission.getModuleId() == moduleTemp || Boolean.TRUE.equals(st)) {
				ModuleModel module = modelRepository.getModuleById(eachPermission.getModuleId());
				moduleList.setModuleName(module.getModuleName());
				moduleList.setSubModules(subModuleList);
				permissions.add(moduleList);
				moduleTemp++;
			}
		}
		return permissions;
	}

}
