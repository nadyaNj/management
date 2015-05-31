package com.home.management.service.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/25/15
 * TIME:    7:38 PM
 */

@Converter(autoApply = true)
public class PersistentLocalDateConverter implements AttributeConverter<LocalDate, Date> {
    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
