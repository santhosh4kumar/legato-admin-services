/**
 * 
 */
package com.legato.admin.services.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legato.admin.services.constants.MessageConstants;
import com.legato.admin.services.exception.DuplicateFieldException;
import com.legato.admin.services.exception.InvalidFormatException;
import com.legato.admin.services.model.ApplicationProperty;
import com.legato.admin.services.service.PropertyService;
import com.legato.admin.services.util.LogDetail;
import com.legato.admin.services.util.LoggingUtil;
import com.legato.admin.services.view.request.PropertyRequestView;
import com.legato.admin.services.view.response.PropertyResponseView;
import com.legato.admin.services.view.response.SimpleResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author AF83580
 *
 */

@Api(value = "Property")
@RestController
@RequestMapping("/property")
public class AplctnPrptyController {
	@Autowired
	private PropertyService propertyService;
	
	@ApiOperation(value = "View a list of available properties", response = List.class)
	@GetMapping
	public ResponseEntity<SimpleResponseEntity> findAll(Principal principal) {
		List<PropertyResponseView> views = propertyService.findAll();
		Map<String, String> response = new LinkedHashMap<>();
		views.forEach(view -> {
			response.put(view.getPropertyName(), view.getPropertyValue());
		});
		return new ResponseEntity<>(
				new SimpleResponseEntity(HttpStatus.OK.value(), MessageConstants.SUCCESS_MSG, response),
				HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Add a new property", response = PropertyRequestView.class)
	@PostMapping
	public ResponseEntity<SimpleResponseEntity> save(HttpServletRequest httpRequest, 
			@Valid @RequestBody PropertyRequestView request) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		try {
			ApplicationProperty user = propertyService.save(request);
			request.setId(user.getId());
		} catch (DuplicateFieldException | InvalidFormatException exception) {
			LoggingUtil.logError(this.getClass(), new LogDetail(username, httpRequest.getRequestURI(), exception), exception);
			return ResponseEntity.ok()
					.body(new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), ""));
		} catch (Exception exception) {
			LoggingUtil.logError(this.getClass(), new LogDetail(username, httpRequest.getRequestURI(), exception), exception);
			return ResponseEntity.ok().body(
					new SimpleResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstants.INTERNAL_SERVER_ERR_MSG, ""));
		}
		return ResponseEntity.ok()
				.body(new SimpleResponseEntity(HttpStatus.OK.value(), MessageConstants.SUCCESS_MSG, request));
	}
}