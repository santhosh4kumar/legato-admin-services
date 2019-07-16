/**
 * 
 */
package com.legato.admin.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.legato.admin.services.exception.DuplicateFieldException;
import com.legato.admin.services.model.UserAuthority;
import com.legato.admin.services.repository.AuthorityRepository;
import com.legato.admin.services.service.AuthorityService;
import com.legato.admin.services.view.request.AuthorityRequestView;
import com.legato.admin.services.view.response.AuthorityResponseView;

/**
 * @author Af83580
 *
 */

@Service
public class AuthorityServiceImpl implements AuthorityService {
	@Autowired
	private AuthorityRepository authorityRepository;
	private static final Logger logger = LoggerFactory.getLogger(AuthorityServiceImpl.class);

	@Override
	@Transactional
	public List<AuthorityResponseView> findAll() {
		List<UserAuthority> authorities = authorityRepository.findAll();
		List<AuthorityResponseView> responseViews = new ArrayList<>();
		authorities.forEach(user -> responseViews.add(getResponseView(user)));
		return responseViews;
	}
	
	@Override
	@Transactional
	public UserAuthority save(AuthorityRequestView request) {
		if (authorityRepository.existsByAuthorityId(request.getAuthorityId())) {
			logger.error("Authority exists with same authority ID!");
			throw new DuplicateFieldException("Authority exists with same authority ID!");
		}
		if (authorityRepository.existsByAuthorityName(request.getAuthorityName())) {
			logger.error("Authority exists with same authority name!");
			throw new DuplicateFieldException("Authority exists with same authority name!");
		}
		UserAuthority authority = new UserAuthority();
		authority.setAuthorityId(request.getAuthorityId());
		authority.setAuthorityName(request.getAuthorityName());
		return authorityRepository.save(authority);
	}

	@Override
	@Transactional
	public UserAuthority update(AuthorityRequestView request) {
		return null;
	}
	
	@Override
	public AuthorityResponseView getResponseView(UserAuthority authority) {
		AuthorityResponseView response = new AuthorityResponseView();
		response.setId(authority.getId());
		response.setAuthorityId(authority.getAuthorityId());
		response.setAuthorityName(authority.getAuthorityName());
		return response;
	}
}