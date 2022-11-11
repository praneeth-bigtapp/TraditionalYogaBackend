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
import com.traditional.yoga.dto.request.RoleRequest;
import com.traditional.yoga.dto.request.SubMenuRequest;
import com.traditional.yoga.dto.request.UserRequest;
import com.traditional.yoga.model.ModuleModel;
import com.traditional.yoga.model.RoleModel;
import com.traditional.yoga.model.RolePermissionModel;
import com.traditional.yoga.model.SubModuleModel;
import com.traditional.yoga.model.UserModel;
import com.traditional.yoga.repository.UserRepository;
import com.traditional.yoga.repository.ModelRepository;
import com.traditional.yoga.repository.RolePermissionRepository;
import com.traditional.yoga.repository.RoleRepository;
import com.traditional.yoga.repository.SubModelRepository;

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

		try {
			if (operation.equals("add")) {
				addUsers(userDto);
			} else if (operation.equals("save")) {
				updateUsers(userDto);
			} else if (operation.equals("delete")) {
				deleteUsers(userDto);
			} else {
				message = "Operation Doesn't exist";
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
			message = "User deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "User Doesn't exist";
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
				userDb.setUserName(userDto.getUserName());
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

	private void addUsers(UserRequest userDto) {
		UserModel userNew = userRepository.getUserByName(userDto.getUserName());
		if (userNew == null) {
			UserModel newUser = new UserModel();
			newUser.setUserName(userDto.getUserName());
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
			if (operation.equals("add")) {
				addRole(roleDto);
			} else if (operation.equals("save")) {
				updateRole(roleDto);
			} else if (operation.equals("delete")) {
				deleteRole(roleDto);
			} else {
				message = "Operation Doesn't exist";
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
//			roleRepository.deleteById(roleDb.getRoleId());
//			LOG.info(roleRepository.findMaxId());
			message = "Role deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Role Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateRole(RoleRequest roleDto) {
		RoleModel roleDb = roleRepository.getRoleById(roleDto.getRoleId());
		if (roleDb != null) {
			RoleModel roleCheck = roleRepository.getRoleByName(roleDto.getRoleName());
			if (roleCheck == null) {
				roleDb.setRoleName(roleDto.getRoleName());
				roleRepository.save(roleDb);
				message = "Role saved sucessfully";
				LOG.info(message);
				response = new Response(message, httpStatus.value(), null);
			} else {
				message = "Updated Role is already exist";
				httpStatus = HttpStatus.CONFLICT;
				LOG.error(message);
				response = new Response(message, httpStatus.value(), message);
			}

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
			newRole.setActive("Y");
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
		ModuleModel menuDb = modelRepository.getModuleById(menuDto.getMenuId());
		if (menuDb != null) {
			message = "Menu deleted sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Menu Doesn't exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}

	private void updateMenu(MenuRequest menuDto) {
		ModuleModel menuDb = modelRepository.getModuleById(menuDto.getMenuId());
		if (menuDb != null) {
			ModuleModel menuCheck = modelRepository.getModuleByName(menuDto.getMenuName());
			if (menuCheck == null) {
				menuDb.setModuleName(menuDto.getMenuName());
				modelRepository.save(menuDb);
				message = "Menu saved sucessfully";
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

	private void addMenu(MenuRequest menuDto) {
		ModuleModel menuNew = modelRepository.getModuleByName(menuDto.getMenuName());
		if (menuNew == null) {
			ModuleModel newMenu = new ModuleModel();
			newMenu.setModuleName(menuDto.getMenuName());
			modelRepository.save(newMenu);
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
			if (menuCheck == null) {
				subMenuDb.setSubModuleName(subMenuDto.getSubMenuName());
				subModelRepository.save(subMenuDb);
				message = "Sub-Menu saved sucessfully";
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

	private void addSubMenu(SubMenuRequest subMenuDto) {
		SubModuleModel subMenuNew = subModelRepository.getSubModuleByName(subMenuDto.getSubMenuName());
		if (subMenuNew == null) {
			SubModuleModel newMenu = new SubModuleModel();
			newMenu.setSubModuleName(subMenuDto.getSubMenuName());
			subModelRepository.save(newMenu);
			message = "Sub-Menu added sucessfully";
			LOG.info(message);
			response = new Response(message, httpStatus.value(), null);
		} else {
			message = "Sub-Menu is already exist";
			httpStatus = HttpStatus.CONFLICT;
			LOG.error(message);
			response = new Response(message, httpStatus.value(), message);
		}
	}
	
	
//	Role Permission
	public Object getPermissionsByRole(int roleId) {
		this.httpStatus = HttpStatus.OK;
		List<RolePermissionModel> rolePermissions = new ArrayList<>();
		try {
			rolePermissions = rolePermissionRepository.findPermissionsByRoleId(roleId);
			message = "";
		} catch (Exception e) {
			message = "";
			httpStatus = HttpStatus.EXPECTATION_FAILED;
		}
		return new ResponseEntity<>(rolePermissions, httpStatus);
	}
}
