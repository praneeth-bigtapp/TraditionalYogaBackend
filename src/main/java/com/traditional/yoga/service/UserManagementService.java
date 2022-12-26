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
import com.traditional.yoga.dto.request.MenuRequest;
import com.traditional.yoga.dto.request.RolePermissionRequest;
import com.traditional.yoga.dto.request.RoleRequest;
import com.traditional.yoga.dto.request.SubMenuRequest;
import com.traditional.yoga.dto.request.UserRequest;
import com.traditional.yoga.model.ModuleModel;
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
import com.traditional.yoga.utils.Constants;
import com.traditional.yoga.utils.UserManagementUtil;

@Service
public class UserManagementService {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementService.class);

	@Autowired
	UserRepository userRepository;

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

	@Autowired
	UserManagementUtil userManagementUtil;

	Response response = new Response();
	HttpStatus httpStatus = HttpStatus.OK;
	String message;

//	Get Service
	public Object getAll(String operationType) {

		LOG.info("Fetching {} data", operationType);

		try {
			if (operationType.equals("users")) {
				return userRepository.findAll();
			} else if (operationType.equals("menus")) {
				return modelRepository.findAll();
			} else if (operationType.equals("subMenus")) {
				return subModelRepository.findAll();
			} else if (operationType.equals("roles")) {
				return roleRepository.findAll();
			} else if (operationType.equals("pemissions")) {
				return permissionRepository.findAll();
			} else {
				message = "Unknown Operation";
				httpStatus = HttpStatus.NOT_ACCEPTABLE;
				LOG.error(message);
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

//	User
	public Object manageUsers(String operation, UserRequest userDto) {

		this.httpStatus = HttpStatus.OK;
		UserModel userReq = new UserModel();
		userReq.setUserName(userDto.getUserName());
		userReq.setPassword(userDto.getPassword());
		try {

			if (operation.equals(Constants.ADD)) {
				addUsers(userDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateUsers(userDto);
			} else if (operation.equals(Constants.ACTIVE)) {
				activeUsers(userDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteUsers(userDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Role";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void deleteUsers(UserRequest userDto) {
		UserModel menuDb = userRepository.getUserById(userDto.getId());
		if (menuDb != null) {
			userRepository.deleteById(userDto.getId());
			message = "User deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.USER_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateUsers(UserRequest userDto) {
		UserModel userDb = userRepository.getUserById(userDto.getId());
		if (userDb != null) {
			UserModel userCheck = userRepository.getUserByName(userDto.getUserName());
			if (userCheck == null) {
				userDb.setId(userDto.getId());
				userDb.setUserName(userDto.getUserName());
				userDb.setPassword(userDto.getPassword());
				userDb.setEmail(userDto.getEmail());
				userDb.setRegion(userDto.getRegion());
				userDb.setCountry(userDto.getCountry());
				userDb.setGender(userDto.getGender());
				userDb.setRoleId(userDto.getRoleId());
				userDb.setAgeFrom(userDto.getAgeFrom());
				userDb.setAgeTo(userDto.getAgeTo());
				userDb.setStatus(userDto.getStatus());
				userDb.setMobile(userDto.getMobile());
				userRepository.save(userDb);
				message = "User saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated User is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = "User Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void activeUsers(UserRequest userDto) {
		UserModel userDb = userRepository.getUserById(userDto.getId());
		if (userDb != null) {
			userDb.setId(userDto.getId());
			userDb.setUserName(userDto.getUserName());
			userDb.setPassword(userDto.getPassword());
			userDb.setEmail(userDto.getEmail());
			userDb.setRegion(userDto.getRegion());
			userDb.setCountry(userDto.getCountry());
			userDb.setGender(userDto.getGender());
			userDb.setRoleId(userDto.getRoleId());
			userDb.setAgeFrom(userDto.getAgeFrom());
			userDb.setAgeTo(userDto.getAgeTo());
			userDb.setStatus(userDto.getStatus());
			userDb.setMobile(userDto.getMobile());
			userRepository.save(userDb);
			message = "User saved sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);

		} else {
			message = "User Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addUsers(UserRequest userDto) {
		UserModel userNew = userRepository.getUserByName(userDto.getUserName());
		if (userNew == null) {
			UserModel newUser = new UserModel();
			newUser.setId(userDto.getId());
			newUser.setUserName(userDto.getUserName());
			newUser.setPassword(userDto.getPassword());
			newUser.setEmail(userDto.getEmail());
			newUser.setRegion(userDto.getRegion());
			newUser.setCountry(userDto.getCountry());
			newUser.setGender(userDto.getGender());
			newUser.setRoleId(userDto.getRoleId());
			newUser.setAgeFrom(userDto.getAgeFrom());
			newUser.setAgeTo(userDto.getAgeTo());
			newUser.setStatus(userDto.getStatus());
			newUser.setMobile(userDto.getMobile());
			userRepository.save(newUser);
			message = "User added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "User is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

//	Role
	public Object manageRole(String operation, RoleRequest roleDto) {

		try {
			if (operation.equals(Constants.ADD)) {
				addRole(roleDto);
			} else if (operation.equals(Constants.SAVE)) {
				updateRole(roleDto);
			} else if (operation.equals(Constants.ACTIVE)) {
				activeRole(roleDto);
			} else if (operation.equals(Constants.DELETE)) {
				deleteRole(roleDto);
			} else {
				message = Constants.OPERATION_ERROR;
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Role";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void deleteRole(RoleRequest roleDto) {
		RoleModel roleDb = roleRepository.getRoleById(roleDto.getRoleId());
		if (roleDb != null) {
			roleRepository.deleteById(roleDb.getRoleId());
			message = "Role deleted sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.ROLE_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateRole(RoleRequest roleDto) {
		RoleModel roleDb = roleRepository.getRoleById(roleDto.getRoleId());
		if (roleDb != null) {
			RoleModel roleCheck = roleRepository.getRoleByName(roleDto.getRoleName());
			if (roleCheck == null || roleCheck.getRoleId() == roleDto.getRoleId()) {
				roleDb.setRoleName(roleDto.getRoleName());
				roleDb.setRoleId(roleDto.getRoleId());
				roleDb.setActive(roleDto.getActive());
				roleRepository.save(roleDb);
				message = "Role updated successfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Error: Role with the specified name already exists";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} else {
			message = "Error: Role not found";
			httpStatus = HttpStatus.NOT_FOUND;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void activeRole(RoleRequest roleDto) {
		RoleModel roleDb = roleRepository.getRoleById(roleDto.getRoleId());
		if (roleDb != null) {
			roleDb.setRoleName(roleDto.getRoleName());
			roleDb.setActive(roleDto.getActive());
			roleRepository.save(roleDb);
			message = "Role saved sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Role Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addRole(RoleRequest roleDto) {
		RoleModel roleNew = roleRepository.getRoleByName(roleDto.getRoleName());
		if (roleNew == null) {
			RoleModel newRole = new RoleModel();
			newRole.setRoleName(roleDto.getRoleName());
			newRole.setRoleId(roleDto.getRoleId());
			newRole.setActive(Constants.YES);
			roleRepository.save(newRole);
			message = "Role added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Role is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

//	Menu
	public Object manageMenu(String operation, MenuRequest menuDto) {

		try {
			if (operation.equals("add")) {
				addMenu(menuDto);
			} else if (operation.equals("save")) {
				updateMenu(menuDto);
			} else if (operation.equals("active")) {
				activeMenu(menuDto);
			} else if (operation.equals("delete")) {
				deleteMenu(menuDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Menu";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void deleteMenu(MenuRequest menuDto) {
		ModuleModel menuDb = modelRepository.getModuleById(menuDto.getModuleId());
		if (menuDb != null) {
			modelRepository.deleteById(menuDto.getModuleId());
			message = "Menu deleted sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = Constants.MENU_ERROR;
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateMenu(MenuRequest menuDto) {
		ModuleModel menuDb = modelRepository.getModuleById(menuDto.getModuleId());
		if (menuDb != null) {
			ModuleModel menuCheck = modelRepository.getModuleByName(menuDto.getModuleName());
			if (menuCheck == null) {
				menuDb.setModuleId(menuDto.getModuleId());
				menuDb.setModuleName(menuDto.getModuleName());
				menuDb.setStatus(menuDto.getStatus());
				modelRepository.save(menuDb);
				message = "Menu saved sucessfully";
				httpStatus = HttpStatus.OK;
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated Menu is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = "Menu Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void activeMenu(MenuRequest menuDto) {
		ModuleModel menuDb = modelRepository.getModuleById(menuDto.getModuleId());
		if (menuDb != null) {
			menuDb.setModuleId(menuDto.getModuleId());
			menuDb.setModuleName(menuDto.getModuleName());
			menuDb.setStatus(menuDto.getStatus());
			modelRepository.save(menuDb);
			message = "Menu saved sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Menu Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addMenu(MenuRequest menuDto) {
		ModuleModel menuNew = modelRepository.getModuleByName(menuDto.getModuleName());
		if (menuNew == null) {
			ModuleModel newMenu = new ModuleModel();
			newMenu.setModuleName(menuDto.getModuleName());
			modelRepository.save(newMenu);
			httpStatus = HttpStatus.OK;
			message = "Menu added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Menu is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

//	Sub Menu
	public Object manageSubMenu(String operation, SubMenuRequest subMenuDto) {

		try {
			if (operation.equals("add")) {
				addSubMenu(subMenuDto);
			} else if (operation.equals("save")) {
				updateSubMenu(subMenuDto);
			} else if (operation.equals("active")) {
				activeSubMenu(subMenuDto);
			} else if (operation.equals("delete")) {
				deleteSubMenu(subMenuDto);
			} else {
				message = "Operation Doesn't exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}
		} catch (Exception e) {
			message = "Exception in Sub-Menu";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	private void deleteSubMenu(SubMenuRequest subMenuDto) {
		SubModuleModel subMenuDb = subModelRepository.getSubModuleById(subMenuDto.getSubMenuId());
		if (subMenuDb != null) {
			subModelRepository.deleteById(subMenuDto.getSubMenuId());
			message = "Sub-Menu deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Sub-Menu Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateSubMenu(SubMenuRequest subMenuDto) {
		SubModuleModel subMenuDb = subModelRepository.getSubModuleById(subMenuDto.getSubMenuId());
		if (subMenuDb != null) {
			SubModuleModel menuCheck = subModelRepository.getSubModuleByName(subMenuDto.getSubMenuName());
			Boolean menuStatus = (subMenuDto.getMenuId() == subMenuDb.getModuleId().getModuleId());
			if (menuCheck == null) {
				subMenuDb.setSubModuleId(subMenuDto.getSubMenuId());
				subMenuDb.setModuleId(modelRepository.getModuleById(subMenuDto.getMenuId()));
				subMenuDb.setSubModuleName(subMenuDto.getSubMenuName());
				subMenuDb.setStatus(subMenuDto.getStatus());
				subModelRepository.save(subMenuDb);
				httpStatus = HttpStatus.OK;
				message = "Sub-Menu saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else if (Boolean.FALSE.equals(menuStatus)) {
				LOG.info("Updating Menu change");
				subMenuDb.setSubModuleId(subMenuDto.getSubMenuId());
				subMenuDb.setModuleId(modelRepository.getModuleById(subMenuDto.getMenuId()));
				subMenuDb.setSubModuleName(subMenuDto.getSubMenuName());
				subMenuDb.setStatus(subMenuDto.getStatus());
				subModelRepository.save(subMenuDb);
				httpStatus = HttpStatus.OK;
				message = "Menu change Sub-Menu saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated Sub-Menu is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

		} else {
			message = "Sub-Menu Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void activeSubMenu(SubMenuRequest subMenuDto) {
		SubModuleModel subMenuDb = subModelRepository.getSubModuleById(subMenuDto.getSubMenuId());
		if (subMenuDb != null) {
			subMenuDb.setStatus(subMenuDto.getStatus());
			subModelRepository.save(subMenuDb);
			message = "Sub-Menu saved sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Updated Sub-Menu is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void addSubMenu(SubMenuRequest subMenuDto) {
		SubModuleModel subMenuNew = subModelRepository.getSubModuleByName(subMenuDto.getSubMenuName());
		if (subMenuNew == null) {
			SubModuleModel newMenu = new SubModuleModel();
			newMenu.setModuleId(modelRepository.getModuleById(subMenuDto.getMenuId()));
			newMenu.setSubModuleName(subMenuDto.getSubMenuName());
			newMenu.setStatus(Constants.YES);
			subModelRepository.save(newMenu);
			message = "Sub-Menu added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
			setRolePermission(subMenuDto.getSubMenuName());
		} else {
			message = "Sub-Menu is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	public void setRolePermission(String subMenuName) {
		SubModuleModel subMenu = subModelRepository.getSubModuleByName(subMenuName);
		if (subMenu != null) {
			List<RoleModel> role = roleRepository.findAll();
			for (RoleModel eachRole : role) {
				RolePermissionModel updateRolePermission = new RolePermissionModel();
				updateRolePermission.setRole(roleRepository.getRoleById(eachRole.getRoleId()));
				updateRolePermission.setModule(modelRepository.getModuleById(subMenu.getModuleId().getModuleId()));
				updateRolePermission.setSubModule(subModelRepository.getSubModuleById(subMenu.getSubModuleId()));
				updateRolePermission
						.setPermission(permissionRepository.getPermissionById(Constants.DEFAULT_PERMISSION));
				rolePermissionRepository.save(updateRolePermission);
			}
		}
	}

	public void updateRolePermission(SubModuleModel subMenuDb) {
		List<RoleModel> role = roleRepository.findAll();
		for (RoleModel eachRole : role) {
			RolePermissionModel updateRolePermission = new RolePermissionModel();
			updateRolePermission.setRole(roleRepository.getRoleById(eachRole.getRoleId()));
			updateRolePermission.setPermission(permissionRepository.getPermissionById(Constants.DEFAULT_PERMISSION));
			rolePermissionRepository.save(updateRolePermission);
		}
	}

	/**
	 * Get Role Permission By ID
	 * 
	 * @param roleId
	 * @return
	 */
	public Object getPermissionsByRole(int roleId) {
		List<RolePermissionModel> rolePermissions = new ArrayList<>();
		try {
			rolePermissions = rolePermissionRepository.getPermissionByroleId(roleId);
			message = "Role permission fetched sucessfully";
			httpStatus = HttpStatus.OK;
			LOG.info(message);
			return new ResponseEntity<>(rolePermissions, httpStatus);
		} catch (Exception e) {
			message = "Exception in Get Permissions";
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
			return new ResponseEntity<>(message, httpStatus);
		}
	}

	/**
	 * Update permission in Role Permission
	 * 
	 * @param rolePermissions
	 * @return
	 */
	public Object saveRolePermission(RolePermissionRequest rolePermissions) {
		RolePermissionModel updateRolePermission = new RolePermissionModel();
		updateRolePermission = userManagementUtil.rolePermissionsDtoToEntity(rolePermissions, updateRolePermission);
		try {
			rolePermissionRepository.save(updateRolePermission);
			message = "Permissions set sucessfully";
			LOG.info(message);
			httpStatus = HttpStatus.OK;
			response = new Response(message, httpStatus.value(), null);
		} catch (Exception e) {
			message = "Exception while saving permission to role permission";
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	public Object addDefaultPermissions(int roleId) {
		List<RolePermissionModel> roleDefatultRolePermissions = constructDefaultpermissios(roleId);
		try {
			for (RolePermissionModel eachRolePermissions : roleDefatultRolePermissions) {
				rolePermissionRepository.save(eachRolePermissions);
			}
			message = "Default Permissions set sucessfully";
			LOG.info(message);
			httpStatus = HttpStatus.OK;
			response = new Response(message, httpStatus.value(), null);
		} catch (Exception e) {
			message = "Exception while saving default permission to role permission";
			LOG.error(message);
			LOG.error(e.getLocalizedMessage());
			httpStatus = HttpStatus.EXPECTATION_FAILED;
			response = new Response(message, httpStatus.value(), e.getLocalizedMessage());
		}
		return new ResponseEntity<>(response, httpStatus);
	}

	public List<RolePermissionModel> constructDefaultpermissios(int roleId) {
		List<RolePermissionModel> rolePermissionsList = new ArrayList<>();
		List<ModuleModel> moduleList = modelRepository.findAll();
		List<SubModuleModel> moduleSubModuleList;
		RolePermissionModel rolePermissions;

		int moduleId = 0;
		int subModuleId = 0;
		for (ModuleModel eachModule : moduleList) {
			moduleId = eachModule.getModuleId();
			moduleSubModuleList = subModelRepository.getSubModuleByModuleId(moduleId);
			for (SubModuleModel eachSubModule : moduleSubModuleList) {
				subModuleId = eachSubModule.getSubModuleId();
				rolePermissions = new RolePermissionModel();
				rolePermissions.setPermission(permissionRepository.getPermissionById(Constants.DEFAULT_PERMISSION));
				rolePermissions.setModule(modelRepository.getModuleById(moduleId));
				rolePermissions.setRole(roleRepository.getRoleById(roleId));
				rolePermissions.setSubModule(subModelRepository.getSubModuleById(subModuleId));
				rolePermissionsList.add(rolePermissions);
			}
		}
		return rolePermissionsList;
	}
}
