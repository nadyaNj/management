package com.home.management.service.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.YearMonth;


/**
 * Created: Nadya Dainelyan
 * DATE:    5/25/15
 * TIME:    7:39 PM
 */

@Converter(autoApply = true)
public class PersistentYearMonthConverter implements AttributeConverter<YearMonth, Date> {
    @Override
    public Date convertToDatabaseColumn(YearMonth yearMonth) {
        return yearMonth == null ? null : Date.valueOf(yearMonth.atDay(1));
    }

    @Override
    public YearMonth convertToEntityAttribute(Date date) {
        return date == null ? null : YearMonth.from(date.toLocalDate());
    }
}
