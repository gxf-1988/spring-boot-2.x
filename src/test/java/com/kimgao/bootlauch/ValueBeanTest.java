package com.kimgao.bootlauch;


import com.kimgao.bootlauch.model.Employee;
import com.kimgao.bootlauch.model.Family;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ValueBeanTest {
    @Resource
    Family family;

    @Resource
    Employee employee;

    @Test
    public void valueBeanTest() throws Exception{
        System.out.println(family.toString());
    }

    @Test
    public void valueBeanTest2() throws Exception{
        System.out.println(employee.toString());
    }
}
