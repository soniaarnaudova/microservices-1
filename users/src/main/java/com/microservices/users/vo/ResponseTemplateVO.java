package com.microservices.users.vo;

import com.microservices.users.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//wrapper class to facilitate our task
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseTemplateVO{
    private Department department;
    private User user;
}