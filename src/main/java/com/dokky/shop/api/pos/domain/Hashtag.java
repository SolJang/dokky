package com.dokky.shop.api.pos.domain;

import com.dokky.shop.api.pos.Creator;
import com.dokky.shop.api.pos.Modifier;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table( name = "TB_HASHTAG" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PACKAGE )
@Builder( access = AccessLevel.PRIVATE )
@FieldDefaults( level = AccessLevel.PRIVATE )
@Entity
public class Hashtag {

    @EmbeddedId
    HashtagId id;
    @Column( name = "TAG_NAME" )
    String name;
    @Column(name = "TAG_USE_TYPE")
    String type;
    @Column(name = "TAG_USE_KEY")
    String key;
    @Column( name = "TAG_USE_SUB_KEY" )
    String subKey;
    @Column( name = "USE_FLAG" )
    Boolean enabled;
    @Embedded
    Creator creator;
    @Embedded
    Modifier modifier;
}
