package com.lambdaschool.school.daos;

import com.lambdaschool.school.models.Instructor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface InstructorDao extends CrudRepository<Instructor, Long>
{
    ArrayList<Instructor> findInstructorsByInstructnameEquals (String name);
}
