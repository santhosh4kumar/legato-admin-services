/**
 * 
 */
package com.legato.admin.services.service;

import java.util.List;

import com.legato.admin.services.model.UserAuthority;
import com.legato.admin.services.view.request.AuthorityRequestView;
import com.legato.admin.services.view.response.AuthorityResponseView;

/**
 * @author Af83580
 *
 */
public interface AuthorityService {
	/**
	 * @param authority
	 * @return
	 */
	public AuthorityResponseView getResponseView(UserAuthority authority);

	/**
	 * @param request
	 * @return
	 */
	UserAuthority save(AuthorityRequestView request);

	/**
	 * @return
	 */
	List<AuthorityResponseView> findAll();

	/**
	 * @param request
	 * @return
	 */
	UserAuthority update(AuthorityRequestView request);
}