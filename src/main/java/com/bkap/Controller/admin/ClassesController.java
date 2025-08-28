package com.bkap.Controller.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.dto.ClassesDTO;
import com.bkap.repository.ClassesRepository;

@RestController
@RequestMapping("/class")
public class ClassesController {
    @Autowired
    private ClassesRepository classesRepository;

    @GetMapping
    public List<ClassesDTO> getAll() {
        return classesRepository.findAll()
                .stream()
                .map(ClassesDTO::new)
                .collect(Collectors.toList());
    }

}
