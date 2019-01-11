package com.univ.dto.validation;

import java.io.Serializable;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.sun.istack.internal.NotNull;

/**
 * @author univ
 * @date 2019/1/11 8:18 PM
 * @description dubbo中使用validate功能
 *
 * 注意
 *  1. dto必须实现Serializable接口，如此才能进行远程传输
 */
public class ValidateDTO implements Serializable{

    @NotNull
    private Long id;

    @NotBlank(message = "name不允许为空")
    private String name;

    @javax.validation.constraints.NotNull
    @Email(message = "email字段不符合邮件格式")
    private String email;

    @javax.validation.constraints.NotNull
    @Min(value = 10, message = "age不能小于10")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ValidateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
