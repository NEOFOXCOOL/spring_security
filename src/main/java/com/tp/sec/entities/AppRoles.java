package com.tp.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity @AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
public class AppRoles {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roles_id;
    private String role;

}
