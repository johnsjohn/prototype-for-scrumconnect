package com.prototype.scrumconnect.models;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("userdata")
public class UserDataModel {
    @Id
    private String id;

    @NotBlank(message = "Required field: name")
    private String name;

    @NotBlank(message = "Required field: sex")
    private String sex;

    @Min(value =1, message = "Valid age is required")
    private int age;

    @NotBlank(message = "Required field: country")
    private String country;

    @CreatedDate
    private Date dateCreated;

    public UserDataModel(String name, String sex, int age, String country) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.country = country;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getCountry(){
        return country;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public Date getDateCreated(){
        return dateCreated;
    }
}
