package com.dokky.shop.api.users.domain.entity;

import com.dokky.shop.api.users.application.CreateUsersCommand;
import com.dokky.shop.api.users.domain.DateOfBirth;
import com.dokky.shop.api.users.domain.Password;
import com.dokky.shop.api.users.domain.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class Users {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    UserId id;
    @Embedded
    Password password;
    String email;
    String name;
    String mobileNumber;
    String sex;
    @Embedded
    DateOfBirth dateOfBirth;

    public Users(){}
    public Users(CreateUsersCommand command){
        this.id = command.id();
        this.password = new Password(command.password().getValue());
        this.email = command.email();
        this.name = command.name();
        this.mobileNumber = command.mobileNumber();
        this.sex = command.sex();
        this.dateOfBirth = new DateOfBirth(command.birth().getYear(), command.birth().getMonth(), command.birth().getDay());
    }
}
