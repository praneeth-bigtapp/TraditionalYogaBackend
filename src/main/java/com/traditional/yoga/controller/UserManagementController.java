package com.traditional.yoga.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traditional.yoga.dto.request.MenuRequest;
import com.traditional.yoga.dto.request.RolePermissionRequest;
import com.traditional.yoga.dto.request.RoleRequest;
import com.traditional.yoga.dto.request.SubMenuRequest;
import com.traditional.yoga.dto.request.UserRequest;
import com.traditional.yoga.service.UserManagementService;

@CrossOrigin("*")
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserManagementController {

	private static final Logger LOG = LoggerFactory.getLogger(UserManagementController.class);

	@Autowired
	UserManagementService userManagementService;

	/**
	 * Authentication for Generated Token
	 * 
	 * @param token
	 */
	private void authenticate(String token) {
		LOG.debug(token);
		LOG.info("Validating the Token");
//		authResponse = (Response) jwtTokenUtil.validateUserToken(token);
	}

	/**
	 * Getting All the Data from users, menus, sub-menus, roles.
	 * 
	 * @param token
	 * @param operation
	 * @return
	 */
	@GetMapping("/getAll")
	public Object getAllDetails(@RequestHeader("token") String token, @RequestParam("operation") String operation) {
		LOG.info("Entering into getAll{} Method", operation);
		authenticate(token);
		return userManagementService.getAll(operation);
	}

	/**
	 * Getting role data without token authentication.
	 * 
	 * @return
	 */
	@GetMapping("/getRegRole")
	public Object getAllDetails() {
		return userManagementService.getAll("roles");
	}

	/**
	 * User CURD operation
	 * 
	 * @param token
	 * @param userDto
	 * @param operation
	 * @return
	 */
	@PostMapping("/user")
	public Object manageUser(@RequestHeader("token") String token, @RequestBody UserRequest userDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return userManagementService.manageUsers(operation, userDto);
	}

	/**
	 * Role CURD operation
	 * 
	 * @param token
	 * @param roleDto
	 * @param operation
	 * @return
	 */
	@PostMapping("/role")
	public Object manageRole(@RequestHeader("token") String token, @RequestBody RoleRequest roleDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return userManagementService.manageRole(operation, roleDto);
	}

	/**
	 * Menu CURD operation
	 * 
	 * @param token
	 * @param menuDto
	 * @param operation
	 * @return
	 */
	@PostMapping("/menu")
	public Object manageMenu(@RequestHeader("token") String token, @RequestBody MenuRequest menuDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return userManagementService.manageMenu(operation, menuDto);
	}

	/**
	 * Sub Menu CURD operation
	 * 
	 * @param token
	 * @param subMenuDto
	 * @param operation
	 * @return
	 */
	@PostMapping("/subMenu")
	public Object manageSubMenu(@RequestHeader("token") String token, @RequestBody SubMenuRequest subMenuDto,
			@RequestParam("operation") String operation) {
		authenticate(token);
		return userManagementService.manageSubMenu(operation, subMenuDto);
	}

	/**
	 * For getting Role Permissions
	 * 
	 * @param token
	 * @param roleId
	 * @return
	 */
	@GetMapping("/rolePermissions")
	public Object getPermissionsByRoleId(@RequestHeader("token") String token, @RequestParam("roleId") int roleId) {
		return userManagementService.getPermissionsByRole(roleId);
	}
	
	/**
	 * Update Role Permissions
	 * 
	 * @param token
	 * @param rolePermissions
	 * @return
	 */
	@PostMapping("/saveRolePermission")
	public Object updateRolePermission(@RequestHeader("token") String token,
			@RequestBody RolePermissionRequest rolePermissions) {
		authenticate(token);
		return userManagementService.saveRolePermission(rolePermissions);
	}

	/**
	 * Adding Default Role Permissions
	 * 
	 * @param token
	 * @param rolePermissions
	 * @return
	 */
	@PostMapping("/saveDefaultRolePermission")
	public Object defaultRolePermission(@RequestHeader("token") String token,
			@RequestBody RolePermissionRequest rolePermissions) {
		authenticate(token);
		return userManagementService.addDefaultPermissions(rolePermissions.getRoleId());
	}
}
