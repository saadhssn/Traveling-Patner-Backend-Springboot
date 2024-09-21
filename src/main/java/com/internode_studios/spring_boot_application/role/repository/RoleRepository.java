package com.internode_studios.spring_boot_application.role.repository;

import com.internode_studios.spring_boot_application.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}