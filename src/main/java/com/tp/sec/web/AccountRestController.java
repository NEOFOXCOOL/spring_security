package com.tp.sec.web;

import com.tp.sec.entities.RolesUserForm;
import com.tp.sec.entities.AppRoles;
import com.tp.sec.entities.AppUser;
import com.tp.sec.service.AccountSVC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private AccountSVC accountSVC;

    public AccountRestController(AccountSVC accountSVC) {
        this.accountSVC = accountSVC;
    }

    @GetMapping(path = "/users")
    public List<AppUser> appUsers(){
        return accountSVC.listuser();
    }

    @PostMapping(path = "/addusers")
    public  AppUser adduser(@RequestBody AppUser appUser){
        return  accountSVC.adduser(appUser);
    }

    @PostMapping(path = "/addroles")
    public AppRoles appRoles(@RequestBody AppRoles appRoles){
        return accountSVC.addroles(appRoles);
    }

    @PostMapping(path = "/addrolestousers")
    public void addroletouser(@RequestBody RolesUserForm rolesUserForm){
        accountSVC.addrolesTouser(rolesUserForm.getUser(),rolesUserForm.getRole());

    }
}
