/**
 * 
 */
package com.legato.admin.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legato.admin.services.model.ApplicationProperty;

/**
 * @author AF83580
 *
 */

@Repository
public interface PropertyRepository extends JpaRepository<ApplicationProperty, Long>{
	boolean existsByPropertyName(String propertyName);
}