package com.dokky.shop.api.domain.user;

import com.dokky.shop.api.domain.user.entity.DateOfBirth;
import com.dokky.shop.api.domain.user.entity.Password;
import com.dokky.shop.api.domain.user.entity.UserId;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
@Builder( access = AccessLevel.PUBLIC )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@FieldDefaults( level = AccessLevel.PRIVATE )
public @Getter @Setter class Users  {
    // implements Persistable< UserId >
    @EmbeddedId
    UserId id;
    @Embedded
    Password password;
    String email;
    String name;
    String mobileNumber;
    String sex;
    @Embedded
    DateOfBirth dateOfBirth;
}
