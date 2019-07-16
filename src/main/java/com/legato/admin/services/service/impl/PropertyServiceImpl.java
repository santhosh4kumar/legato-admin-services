/**
 * 
 */
package com.legato.admin.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.legato.admin.services.constants.MessageConstants;
import com.legato.admin.services.exception.DuplicateFieldException;
import com.legato.admin.services.model.ApplicationProperty;
import com.legato.admin.services.repository.PropertyRepository;
import com.legato.admin.services.service.PropertyService;
import com.legato.admin.services.view.request.PropertyRequestView;
import com.legato.admin.services.view.response.PropertyResponseView;

/**
 * @author AF83580
 *
 */

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public List<PropertyResponseView> findAll() {
		List<PropertyResponseView> responses = new ArrayList<>();
		propertyRepository.findAll().forEach(property -> {
			PropertyResponseView view = getResponse(property);
			responses.add(view);
		});
		return responses;
	}
	
	@Override
	@Transactional
	public ApplicationProperty findById(long id){
		return propertyRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public ApplicationProperty save(PropertyRequestView request) {
		if (propertyRepository.existsByPropertyName(request.getPropertyName())) {
			throw new DuplicateFieldException(MessageConstants.DUPLICATE_PROPERTY_NAME_MSG);
		}
		ApplicationProperty property = new ApplicationProperty();
		property.setPropertyName(request.getPropertyName());
		property.setPropertyDesc(StringUtils.isBlank(request.getPropertyDesc()) ? request.getPropertyName() : request.getPropertyDesc());
		property.setPropertyDesc(StringUtils.isBlank(request.getPropertyId()) ? request.getPropertyName() : request.getPropertyId());
		property.setPropertyValue(request.getPropertyValue());
		return propertyRepository.save(property);
	}
	
	private PropertyResponseView getResponse(ApplicationProperty property) {
		PropertyResponseView view = new PropertyResponseView();
		view.setId(property.getId());
		view.setPropertyId(property.getPropertyId());
		view.setPropertyName(property.getPropertyName());
		view.setPropertyDesc(property.getPropertyDesc());
		view.setPropertyValue(property.getPropertyValue());
		return view;
	}
}