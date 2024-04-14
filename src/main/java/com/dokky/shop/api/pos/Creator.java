package com.dokky.shop.api.pos;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
public class Creator implements Serializable {

    @Serial
    private static final long serialVersionUID = -5172150739053627785L;

    @CreatedDate

    @Column(name = "reg_dt")
    private String dateTime;


    @Column(name = "reg_id")
    private String id;


    @Column(name = "reg_ip")
    private String ip;

    public static Creator of(String id) {
        return of(id, "");
    }

    public static Creator of(String id, String ip) {
        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return new Creator(dt, id, ip);
    }

    public static Creator of( Modifier modifier ){
        return new Creator( modifier.getDateTime(), modifier.getId(), modifier.getIp() );
    }

    @PrePersist
    public void onPrePersist() {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }
}
