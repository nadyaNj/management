package com.home.management.service.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/25/15
 * TIME:    7:39 PM
 */

@Converter(autoApply = true)
public class PersistentLocalTimeConverter implements AttributeConverter<LocalTime, Time> {
    @Override
    public Time convertToDatabaseColumn(LocalTime localTime) {
        return localTime == null ? null : Time.valueOf(localTime);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time time) {
        return time == null ? null : time.toLocalTime();
    }
}
