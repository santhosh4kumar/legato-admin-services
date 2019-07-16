/**
 * 
 */
package com.legato.admin.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legato.admin.services.model.UserAccess;

/**
 * @author Af83580
 *
 */

@Repository
public interface UserAccessRepository extends JpaRepository<UserAccess, Long> {
    Optional<UserAccess> findByAccessName(String accessName);
    Optional<UserAccess> findByAccessId(Long accessId);
}
