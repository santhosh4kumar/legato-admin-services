package com.legato.admin.services.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.legato.admin.services.model.UserProfile;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUsername(String username);
    @Query("SELECT u FROM UserProfile u WHERE LOWER(u.username)= LOWER(:username) AND (CURRENT_DATE >= u.validFrom and COALESCE(u.validTo, STR_TO_DATE('8888-12-31','%Y-%d-%m')) > CURRENT_DATE) AND u.active = true")
	public UserProfile findActiveUserByUsername(@Param("username") String userId);
    @Query("SELECT u FROM UserProfile u WHERE u.managerId = :manager")
	public List<UserProfile> findAll(@Param("manager") UserProfile manager);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM UserProfile u WHERE u.email = :email and u.id != :id")
    Boolean existsByEmailExceptUser(@Param("id") Long id, @Param("email") String email);
    Boolean existsByMobile(String mobile);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM UserProfile u WHERE u.mobile = :mobile and u.id != :id")
    Boolean existsByMobileExceptUser(@Param("id") Long id, @Param("mobile") String mobile);
}