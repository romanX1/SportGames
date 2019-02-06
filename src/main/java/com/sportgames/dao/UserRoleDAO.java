package com.sportgames.dao;

import com.sportgames.model.UserRole;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface UserRoleDAO {


    void add(UserRole userRole);
    void delete(UserRole userRole);
    UserRole findByAuthority (String authority);
    List<UserRole> gelAll();

}
