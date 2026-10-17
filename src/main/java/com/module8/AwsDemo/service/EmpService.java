package com.module8.AwsDemo.service;

import com.module8.AwsDemo.entity.EmpEntity;
import com.module8.AwsDemo.repository.EmpRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpService {
    private final EmpRepo empRepo;
    private final ModelMapper modelMapper;

    //Create
    public EmpDto create(EmpDto empDto){
        EmpEntity emp = modelMapper.map(empDto, EmpEntity.class);
        EmpEntity saveEmp = empRepo.save(emp);
        return modelMapper.map(saveEmp, EmpDto.class);
    }

    //Read
    public List<EmpDto> readAll(){
        List<EmpEntity> empEntities = empRepo.findAll();
        return empEntities.stream()
                .map(emp->modelMapper.map(emp, EmpDto.class))
                .toList();
    }
    public EmpDto readById(Long id){
        EmpEntity emp = empRepo.findById(id).orElseThrow(()->new RuntimeException("No Such Record Exist"));
        return modelMapper.map(emp, EmpDto.class);
    }

    //Update
   /* public EmpDto update(EmpDto empDto, Long id){
        EmpEntity empEntity = empRepo.findById(id).orElseThrow(()->new RuntimeException("No such Record Exist"));
        modelMapper.map(empDto, empEntity);
        EmpEntity newEmp = empRepo.save(empEntity);
        return modelMapper.map(newEmp, EmpDto.class);

    }*/
    public EmpDto update(EmpDto empDto, Long id) {

        EmpEntity empEntity = empRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No such Record Exist"));

        //modelMapper.typeMap(EmpDto.class, EmpEntity.class)
        //        .addMappings(mapper -> mapper.skip(EmpEntity::setId));

        modelMapper.map(empDto, empEntity);

        EmpEntity savedEmp = empRepo.save(empEntity);

        return modelMapper.map(savedEmp, EmpDto.class);
    }

    //Delete
    public Boolean delete(Long id){
        EmpEntity emp = empRepo.findById(id).orElseThrow(()->new RuntimeException("No such record Exist"));
        empRepo.delete(emp);
        return true;
    }

}
