package com.legato.admin.services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.legato.admin.services.model.UserAuthority;


@Repository
public interface AuthorityRepository extends JpaRepository<UserAuthority, Long> {
	Optional<UserAuthority> findByAuthorityId(Long roleId);
    Optional<UserAuthority> findByAuthorityName(String roleName);
    Boolean existsByAuthorityId(Long authorityId);
    Boolean existsByAuthorityName(String authorityName);
}