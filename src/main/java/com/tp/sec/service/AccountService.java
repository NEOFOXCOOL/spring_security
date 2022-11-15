package com.tp.sec.service;

import com.tp.sec.entities.AppRoles;
import com.tp.sec.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppRoles addroles(AppRoles appRoles);
    AppUser adduser(AppUser appUser);
    AppUser finduserbyusername(String username);
    void addrolesTouser(String user,String roles);
    List<AppUser> listuser();
}
