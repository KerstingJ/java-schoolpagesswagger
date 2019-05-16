package com.lambdaschool.school.services;

import com.lambdaschool.school.daos.InstructorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "instructorService")
public class InstructorServiceImpl implements InstructorService
{
    @Autowired
    private InstructorDao instructrepos;
}
