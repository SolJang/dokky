package com.dokky.shop.api.pos;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PreUpdate;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
public @Getter class Modifier implements Serializable {
    @Serial
    private static final long serialVersionUID = 1962126428484123288L;

    @LastModifiedDate
    @Column(name = "MOD_DT")
    private String dateTime;
    @Column(name = "MOD_ID")
    private String id;
    @Column(name = "MOD_IP")
    private String ip;

    public static Modifier of(String id, String ip) {
        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return new Modifier(dt, id, ip);
    }

    @PreUpdate
    public void onPreUpdate() {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
