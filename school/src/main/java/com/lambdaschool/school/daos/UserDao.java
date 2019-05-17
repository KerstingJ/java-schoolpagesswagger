package com.lambdaschool.school.daos;

import com.lambdaschool.school.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
