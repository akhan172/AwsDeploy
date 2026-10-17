package com.module8.AwsDemo.service;

import com.module8.AwsDemo.entity.Dept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {
    private String name;
    private Dept dept;
    private Double sal;

}
