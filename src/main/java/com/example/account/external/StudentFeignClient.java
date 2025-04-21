package com.example.account.external;

import com.example.account.dtos.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "studentDetail", url = "http://192.168.1.130", path = "asarfi/student")
public interface StudentFeignClient {

    @GetMapping
    List<StudentDTO> getStudents();

    @GetMapping("/{id}")
    StudentDTO getStudentById(@PathVariable int id);
}
