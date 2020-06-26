package com.kimgao.bootlauch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource(value = "classpath:employee.properties",encoding = "utf-8")
public class Employee {

    //使用SpEL读取employee.properties配置文件,split表示分隔符
    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> employeeNames;

    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private String firstEmployeeNames;

    @Value ("#{${employee.age}}")
    private Map<String, Integer> employeeAge;

    @Value ("#{${employee.age}.two}")
    // @Value ("#{${employee.age}['two']}")  //这样写也可以
    private String employeeAgeTwo;

    //如果我们不确定，Map中的某个key是否存在，可以使用如下的SpEL表达式。如果key存在就获取对应的value，如果不存在就获得默认值31
    @Value ("#{${employee.age}['five'] ?: 31}")
    private Integer ageWithDefaultValue;

    @Value ("#{systemProperties['java.home']}")
    private String javaHome;

    @Value ("#{systemProperties['user.dir']}")
    private String userDir;

}
