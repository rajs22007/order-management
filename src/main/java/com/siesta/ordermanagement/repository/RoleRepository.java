package com.siesta.ordermanagement.repository;

import com.siesta.ordermanagement.entity.Role;
import com.siesta.ordermanagement.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
