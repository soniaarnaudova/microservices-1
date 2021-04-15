package com.microservices.users.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department{
    private Long departmentId;
    private String name;
    private String address;
    private String code;
}
