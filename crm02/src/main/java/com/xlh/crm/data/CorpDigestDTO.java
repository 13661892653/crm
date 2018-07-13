package com.xlh.crm.data;

import java.util.Date;

/**
 * Created by wwz on 2016/11/30.
 */
public class CorpDigestDTO {

    private String name;

    private String id;

    private Date start_date;

    private String oper_name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getOper_name() {
        return oper_name;
    }

    public void setOper_name(String oper_name) {
        this.oper_name = oper_name;
    }
}
