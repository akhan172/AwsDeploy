package com.module8.AwsDemo.repository;

import com.module8.AwsDemo.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<EmpEntity, Long> {
}
