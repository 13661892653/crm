package com.xlh.crm;

import com.xlh.crm.dto.mysql.FiTmpExcelJxSmallProfitTable;
import com.xlh.crm.mapper.FiTmpExcelJxSmallProfitTableMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = crmApplication.class)
//@WebAppConfiguration
public class CompareTest {
    @Autowired
    private FiTmpExcelJxSmallProfitTableMapper fiTmpExcelJxSmallProfitTableMapper;

    @Test
    public void test1() throws IllegalAccessException, ClassNotFoundException {
        String pattern="(\\d{4}-\\d{1,2})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher("2017-01");
        if (m.find()) {
            System.out.println( m.group(1));
        }
//        Example example2 = new Example(FiTmpExcelJxSmallProfitTable.class);
//        example2.createCriteria().andEqualTo("fileId", 3).andEqualTo("sheetId", 3);
//        List<FiTmpExcelJxSmallProfitTable> list = fiTmpExcelJxSmallProfitTableMapper.selectByExample(example2);
//        compareTwoClass(list.get(0), list.get(1));
    }

    private  List<Map<String, Object>> compareTwoClass(Object class1, Object class2) throws ClassNotFoundException, IllegalAccessException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//获取对象的class
        Class<?> clazz1 = class1.getClass().getSuperclass();
        Class<?> clazz2 = class2.getClass().getSuperclass();
//获取对象的属性列表
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
//遍历属性列表field1
        for (int i = 0; i < field1.length; i++) {
//遍历属性列表field2
            for (int j = 0; j < field2.length; j++) {
//如果field1[i]属性名与field2[j]属性名内容相同
                if (field1[i].getName().equals(field2[j].getName())) {
                    if (field1[i].getName().equals(field2[j].getName())) {
                        field1[i].setAccessible(true);
                        field2[j].setAccessible(true);
//如果field1[i]属性值与field2[j]属性值内容不相同
                        if (!compareTwo(field1[i].get(class1), field2[j].get(class2))) {
                            Map<String, Object> map2 = new HashMap<String, Object>();
                            map2.put("name", field1[i].getName());
                            map2.put("old", field1[i].get(class1));
                            map2.put("new", field2[j].get(class2));
                            list.add(map2);
                        }
                        break;
                    }
                }
            }
        }
        return list;
    }

    private   boolean compareTwo(Object object1, Object object2) {

        if (object1 == null && object2 == null) {
            return true;
        }
        if (object1 == null && object2 != null) {
            return false;
        }
        if (object1.equals(object2)) {
            return true;
        }
        return false;
    }

}
