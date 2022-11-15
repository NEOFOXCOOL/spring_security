package com.tp.sec.service;

import com.tp.sec.repo.AppRolesRepository;
import com.tp.sec.repo.AppUserRepository;
import com.tp.sec.entities.AppRoles;
import com.tp.sec.entities.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AccountSVC implements AccountService {

private PasswordEncoder passwordEncoder;
    private AppUserRepository appUserRepository;
    private AppRolesRepository appRolesRepository;

    public AccountSVC(PasswordEncoder passwordEncoder, AppUserRepository appUserRepository, AppRolesRepository appRolesRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
        this.appRolesRepository = appRolesRepository;
    }


    @Override
    public AppRoles addroles(AppRoles appRoles) {
        return appRolesRepository.save(appRoles);
    }

    @Override
    public AppUser adduser(AppUser appUser) {
String pw = appUser.getUserPssword();
appUser.setUserPssword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser finduserbyusername(String username) {

        return appUserRepository.findByUserName(username);
    }

    @Override
    public void addrolesTouser(String user, String roles) {
AppUser appUser = appUserRepository.findByUserName(user);
AppRoles appRoles = appRolesRepository.findByRole(roles);
appUser.getApproles().add(appRoles);
    }

    @Override
    public List<AppUser> listuser() {

        return appUserRepository.findAll();
    }
}
