package com.sportgames.dao;

import com.sportgames.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    void delete(UserRole userRole);
    UserRole findByAuthority (String authority);
    List<UserRole> findAll();

}
