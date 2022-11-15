package com.tp.sec;

import com.tp.sec.entities.AppRoles;
import com.tp.sec.entities.AppUser;
import com.tp.sec.service.AccountSVC;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder (){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AccountSVC acountService){
        return args -> {
            acountService.addroles(new AppRoles(null,"ADMIN"));
            acountService.addroles(new AppRoles(null,"USER"));
            acountService.addroles(new AppRoles(null,"COSTOMER_MANAGER"));
            acountService.addroles(new AppRoles(null,"PRODUCT_MANAGER"));
            acountService.addroles(new AppRoles(null,"BILLS_MANAGER"));

            acountService.adduser(new AppUser(null,"ADMIN","123", new ArrayList<>()));
            acountService.adduser(new AppUser(null,"user1","123", new ArrayList<>()));
            acountService.adduser(new AppUser(null,"user2","123", new ArrayList<>()));
            acountService.adduser(new AppUser(null,"user3","123", new ArrayList<>()));
            acountService.adduser(new AppUser(null,"user4","123", new ArrayList<>()));

            acountService.addrolesTouser("ADMIN","ADMIN");
            acountService.addrolesTouser("user1","USER");
            acountService.addrolesTouser("user2","COSTOMER_MANAGER");
            acountService.addrolesTouser("user2","USER");
            acountService.addrolesTouser("user3","PRODUCT_MANAGER");
            acountService.addrolesTouser("user3","USER");
            acountService.addrolesTouser("user4","BILLS_MANAGER");
            acountService.addrolesTouser("user4","USER");
        };
    }
}
