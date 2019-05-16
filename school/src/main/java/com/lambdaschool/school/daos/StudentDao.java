package com.lambdaschool.school.daos;

import com.lambdaschool.school.models.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentDao extends PagingAndSortingRepository<Student, Long>
{
    List<Student> findByStudnameContainingIgnoreCase(String name, Pageable pageable);
}
