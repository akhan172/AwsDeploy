package com.module8.AwsDemo.contoller;

import com.module8.AwsDemo.service.EmpDto;
import com.module8.AwsDemo.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@RequiredArgsConstructor
public class EmpController {
    private final EmpService empService;

    @PostMapping
    public ResponseEntity<EmpDto> createRecord(@RequestBody EmpDto emp){
        EmpDto empDto=empService.create(emp);
        return ResponseEntity.ok(empDto);
    }

    @GetMapping
    public ResponseEntity<List<EmpDto>> getAllRecord(){
        List<EmpDto> enpData = empService.readAll();
        return ResponseEntity.ok(enpData);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpDto> getRecord(@PathVariable Long id){
        EmpDto emp = empService.readById(id);
        return ResponseEntity.ok(emp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpDto> updateRecord(@PathVariable Long id, @RequestBody EmpDto empDto){
        EmpDto updateEmp = empService.update(empDto, id);
        return ResponseEntity.ok(updateEmp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecord(@PathVariable Long id){
        Boolean res = empService.delete(id);
        return ResponseEntity.ok(res);
    }

}
