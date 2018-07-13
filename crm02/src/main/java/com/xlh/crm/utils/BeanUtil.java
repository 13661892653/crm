package com.xlh.crm.utils;

import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ycp on 2017/3/14.
 */
public class BeanUtil {
    private static ConcurrentHashMap<String, BeanCopier> cache = new ConcurrentHashMap();

    public BeanUtil() {
    }

    public static <T> T copyBeanProperties(Object sourceObj, T target) {
        return copyBeanProperties(sourceObj, target, false);
    }

    private static <T> T copyBeanProperties(Object sourceObj, T target, boolean useConverter) {
        if(sourceObj != null && target != null) {
            String key = sourceObj.getClass().getSimpleName() + target.getClass().getSimpleName();
            BeanCopier copier = (BeanCopier)cache.get(key);
            if(copier == null) {
                copier = createBeanCopier(sourceObj.getClass(), target.getClass(), useConverter, key);
            }

            copier.copy(sourceObj, target, (Converter)null);
            return target;
        } else {
            return null;
        }
    }

    private static BeanCopier createBeanCopier(Class<?> sourceClass, Class<?> targetClass, boolean useConverter, String cacheKey) {
        BeanCopier copier = BeanCopier.create(sourceClass, targetClass, useConverter);
        cache.putIfAbsent(cacheKey, copier);
        return copier;
    }
}
