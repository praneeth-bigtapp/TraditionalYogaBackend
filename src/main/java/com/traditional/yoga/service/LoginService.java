package com.traditional.yoga.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.traditional.yoga.dto.Response;
import com.traditional.yoga.dto.RolePermissions;
import com.traditional.yoga.dto.SubModules;
import com.traditional.yoga.dto.request.LoginRequest;
import com.traditional.yoga.dto.response.LoginResponse;
import com.traditional.yoga.model.UserModel;
import com.traditional.yoga.model.ModuleModel;
import com.traditional.yoga.model.RoleModel;
import com.traditional.yoga.model.RolePermissionModel;
import com.traditional.yoga.model.SubModuleModel;
import com.traditional.yoga.repository.UserRepository;
import com.traditional.yoga.repository.ModelRepository;
import com.traditional.yoga.repository.RolePermissionRepository;
import com.traditional.yoga.repository.RoleRepository;
import com.traditional.yoga.repository.SubModelRepository;

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

	public LoginResponse loginUser(LoginRequest userDetails) {
		LoginResponse loginResponse = new LoginResponse();
		Response response = new Response();

		LOG.info("Checking for bad Request");
		Boolean validateUser = userDetails.getUserName() == null || userDetails.getUserName().isBlank();
		if (Boolean.FALSE.equals(validateUser)) {
			UserModel userData = loginUserRepository.getUserByName(userDetails.getUserName());

			LOG.info("Checking for user exsits");
			Boolean checkingUser = userData == null || userData.getUserName().isBlank();
			if (Boolean.FALSE.equals(checkingUser)) {
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

				response.setMessage("Login Sucessfully");
				response.setStatusCode(HttpStatus.OK.value());
				response.setErrorMessage(null);
				loginResponse.setResponse(response);
			} else {
				LOG.info("User doesnot exists");
				response.setMessage("User doesnot exists");
				response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				response.setErrorMessage("User doesnot exists");
				loginResponse.setResponse(response);
			}
		} else {
			LOG.info("Bad User Details");
			response.setMessage("Bad User Details");
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			response.setErrorMessage("Bad User Details");
			loginResponse.setResponse(response);
		}

		return loginResponse;
	}

	public List<RolePermissions> getModuleScreenMap(List<RolePermissionModel> rolePermissions) {
		int moduleTemp = 2;

		List<RolePermissions> permissions = new ArrayList<>();
		List<SubModules> subModuleList = new ArrayList<>();
		RolePermissions moduleList = new RolePermissions();

		for (RolePermissionModel eachPermission : rolePermissions) {
			SubModules subModules = new SubModules();
			SubModuleModel subModulesName = subModelRepository.getSubModuleById(eachPermission.getSubModuleId());
			subModules.setSubModuleId(eachPermission.getSubModuleId());
			subModules.setSubModuleName(subModulesName.getSubModuleName());
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
