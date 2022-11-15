package com.tp.sec.repo;

import com.tp.sec.entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRolesRepository extends JpaRepository<AppRoles,Long> {
    AppRoles findByRole(String role);
}
