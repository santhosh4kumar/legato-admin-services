/**
 * 
 */
package com.legato.admin.services.service;

import java.util.List;

import com.legato.admin.services.jwt.security.dto.UserDto;
import com.legato.admin.services.model.UserProfile;
import com.legato.admin.services.view.request.UserRequestView;
import com.legato.admin.services.view.response.UserResponseView;

/**
 * @author Niranjan
 *
 */
public interface UserService {
	/**
	 * @param user
	 * @return
	 */
	public UserResponseView getResponseView(UserProfile user);

	/**
	 * @param request
	 * @return
	 */
	UserProfile save(UserRequestView request);

	/**
	 * @return
	 */
	List<UserResponseView> findAll();

	/**
	 * @param request
	 * @return
	 */
	UserProfile update(UserRequestView request);

	/**
	 * @param username
	 * @return
	 */
	UserDto getUser(String username);

	/**
	 * @param managerId
	 * @return
	 */
	public List<UserResponseView> findAll(Long managerId);
}