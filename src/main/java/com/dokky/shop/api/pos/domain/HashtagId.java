package com.dokky.shop.api.pos.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class HashtagId implements Serializable {

    @Serial
    private static final long serialVersionUID = 7780887638595334461L;

    @Column(name = "TAG_NO")
    String value;

    public static HashtagId of(String id) {
        return new HashtagId( id );
    }
}
