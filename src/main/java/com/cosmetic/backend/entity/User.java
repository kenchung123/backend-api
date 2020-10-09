package com.cosmetic.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
//@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @NotNull(message = "fullname can not empty")
    @Column(name = "fullname")
    private String fullName;

    @NotNull(message = "password can not empty")
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @Pattern(regexp = "^(09|07|03|08|05)\\d{8}$")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "Date of birth is not null")
//    @Past(message = "Date of birth greater than now day")
//    @Column(name = "birth_date")
    private Date birthDate;

    @Email(message = "email wrong")
    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "image_profile")
    private String imageProfile;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL})
    private List<OrderEntity> orderEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CartEntity> cartEntities = new ArrayList<>();

    public User() {
        super();
    }
}
