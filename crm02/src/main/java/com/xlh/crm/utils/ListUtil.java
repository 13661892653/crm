package com.xlh.crm.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ycp on 2017/3/14.
 */
public class ListUtil{
    public ListUtil() {
    }

    public static <T> List<T> pluck(List orginList, String fieldName, Class<T> c) {
        Field field = null;
        ArrayList returnList = new ArrayList();
        Iterator i$ = orginList.iterator();

        while(i$.hasNext()) {
            Object o = i$.next();
            if(field == null) {
                field = ReflectionUtils.findField(o.getClass(), fieldName);
                field.setAccessible(true);
            }

            Object val = ReflectionUtils.getField(field, o);
            if(val != null) {
                returnList.add(val);
            } else {
                returnList.add((Object)null);
            }
        }

        return returnList;
    }
}