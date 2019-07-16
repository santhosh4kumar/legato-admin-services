/**
 * 
 */
package com.legato.admin.services.service;

import java.util.List;

import com.legato.admin.services.model.ApplicationProperty;
import com.legato.admin.services.view.request.PropertyRequestView;
import com.legato.admin.services.view.response.PropertyResponseView;

/**
 * @author AF83580
 *
 */
public interface PropertyService {

	List<PropertyResponseView> findAll();

	ApplicationProperty findById(long id);

	ApplicationProperty save(PropertyRequestView request);
}