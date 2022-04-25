package com.example.tp4.sec.services;

import com.example.tp4.sec.entities.AppRole;
import com.example.tp4.sec.entities.AppUser;
import com.example.tp4.sec.repositories.AppRoleRepository;
import com.example.tp4.sec.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
//pour loger
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public AppUser saveNewUser(String username, String password, String ConfirmPassword) {
        if(!password.equals(ConfirmPassword)) throw new RuntimeException("password not match");
        String hachPWD=passwordEncoder.encode(password);
        AppUser appUser = new AppUser();
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hachPWD);
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole!=null) throw new RuntimeException("Role "+roleName+"Already exist");
        appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        AppRole savedAppRole = appRoleRepository.save(appRole);
        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(userName);
        if(appUser==null) throw new RuntimeException("User Not Found");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException("Role Not Found");
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public void removeRoleToUser(String userName, String roleName) {
        AppUser appUser=appUserRepository.findByUsername(userName);
        if(appUser==null) throw new RuntimeException("User Not Found");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException("Role Not Found");
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByUsername(userName);
    }
}
