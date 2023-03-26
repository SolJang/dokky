package com.dokky.shop.api.user.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DateOfBirth {
    @Column(name = "date_of_year")
    int year;
    @Column(name = "date_of_month")
    int month;
    @Column(name = "date_of_day")
    int day;

    public DateOfBirth() {
    }

    public DateOfBirth(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }
}
