package com.sportgames.service;

import com.sportgames.model.UserRole;

import java.util.List;

public interface UserRoleService {

    void add(UserRole userRole);
    UserRole findByAuthority (String authority);
    List<UserRole> gelAll();
}
