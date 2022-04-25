package com.example.tp4.sec.services;

import com.example.tp4.sec.entities.AppRole;
import com.example.tp4.sec.entities.AppUser;

public interface SecurityService  {
    AppUser saveNewUser(String username, String password, String ConfirmPassword);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String userName, String roleName);
    void removeRoleToUser(String userName, String roleName);
    AppUser loadUserByUserName(String userName);
}
