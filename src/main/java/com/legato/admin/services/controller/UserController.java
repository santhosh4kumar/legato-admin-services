/**
 * 
 */
package com.legato.admin.services.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legato.admin.services.constants.MessageConstants;
import com.legato.admin.services.exception.DuplicateFieldException;
import com.legato.admin.services.exception.InvalidFormatException;
import com.legato.admin.services.exception.ResourceNotFoundException;
import com.legato.admin.services.model.UserProfile;
import com.legato.admin.services.repository.AuthorityRepository;
import com.legato.admin.services.repository.UserRepository;
import com.legato.admin.services.service.UserService;
import com.legato.admin.services.util.LogDetail;
import com.legato.admin.services.util.LoggingUtil;
import com.legato.admin.services.view.request.UserRequestView;
import com.legato.admin.services.view.response.SimpleResponseEntity;
import com.legato.admin.services.view.response.UserResponseView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Niranjan
 *
 */

@Api(value = "User")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthorityRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "View a list of available users", response = List.class)
	@GetMapping
	public ResponseEntity<SimpleResponseEntity> findAll(Principal principal) {
		List<UserResponseView> views = userService.findAll();
		return new ResponseEntity<>(
				new SimpleResponseEntity(HttpStatus.OK.value(), MessageConstants.SUCCESS_MSG, views),
				HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "View a list of available users for a particular manager.", response = List.class)
	@GetMapping("/{managerId}")
	public ResponseEntity<SimpleResponseEntity> findAll(Principal principal, 
			@PathVariable("managerId") Long managerId) {
		// List<UserResponseView> views = userService.findAll(managerId);
		List<UserResponseView> views = userService.findAll();
		return new ResponseEntity<>(
				new SimpleResponseEntity(HttpStatus.OK.value(), MessageConstants.SUCCESS_MSG, views),
				HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Add a new user", response = UserRequestView.class)
	@PostMapping
	public ResponseEntity<SimpleResponseEntity> save(HttpServletRequest httpRequest, 
			@Valid @RequestBody UserRequestView request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.info("{} trying to register user.", username);
		try {
			UserProfile user = userService.save(request);
			request.setId(user.getId());
		} catch (DuplicateFieldException | InvalidFormatException exception) {
			LoggingUtil.logError(this.getClass(), new LogDetail(username, httpRequest.getRequestURI(), exception), exception);
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ""));
		} catch (Exception exception) {
			LoggingUtil.logError(this.getClass(), new LogDetail(username, httpRequest.getRequestURI(), exception), exception);
			return ResponseEntity.ok().body(
					new SimpleResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal server error !", ""));
		}
		logger.info("{} registered user successfully.", username);
		return ResponseEntity.ok()
				.body(new SimpleResponseEntity(HttpStatus.OK.value(), MessageConstants.SUCCESS_MSG, request));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Update an existing user", response = UserRequestView.class)
	@PutMapping
	public ResponseEntity<SimpleResponseEntity> updateUser(Principal principal, 
			HttpServletRequest httpRequest, 
			@Valid @RequestBody UserRequestView request) {
		logger.info("User trying to update {}", request.getUsername());
		try {
			userService.update(request);
		} catch(ResourceNotFoundException exception) {
			LoggingUtil.logError(this.getClass(), new LogDetail(principal.getName(), httpRequest.getRequestURI(), exception), exception);
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.NOT_FOUND.value(), exception.getMessage(), ""));
		} catch(DuplicateFieldException exception) {
			LoggingUtil.logError(this.getClass(), new LogDetail(principal.getName(), httpRequest.getRequestURI(), exception), exception);
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ""));
		}
		logger.info("{} updated successfully.", request.getUsername());
		return ResponseEntity.ok()
				.body(new SimpleResponseEntity(HttpStatus.OK.value(), MessageConstants.SUCCESS_MSG, request));
	}
}