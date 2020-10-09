package com.cosmetic.backend.entity;

import com.cosmetic.backend.validation.EMEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
//    private String roleName;
    EMEnum.RoleName roleName;
    public Role() {
        super();
    }

    public Role(EMEnum.RoleName roleName) {
        this.roleName = roleName;
    }
    @OneToMany(mappedBy = "role")
    private List<User> listUsers = new ArrayList<>();
}
