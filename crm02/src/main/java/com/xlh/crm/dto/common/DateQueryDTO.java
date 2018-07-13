package com.xlh.crm.dto.common;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ycp on 2017/3/17.
 */
public class DateQueryDTO {
    private Integer year;
    private Integer month;
    private Integer day;

    public DateQueryDTO(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH) + 1;
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
