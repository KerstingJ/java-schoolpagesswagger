package com.lambdaschool.school;

import com.lambdaschool.school.model.*;
import com.lambdaschool.school.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    private UserRepository userrepo;
    private RoleRepository rolerepo;

    private InstructorRepository insrepo;
    private CourseRepository courserepo;
    private StudentRepository studentrepo;

    public SeedData(UserRepository userrepo, RoleRepository rolerepo,
            InstructorRepository insrepo, CourseRepository courserepo, StudentRepository studentrepo) {
        this.userrepo = userrepo;
        this.rolerepo = rolerepo;
        this.insrepo = insrepo;
        this.courserepo = courserepo;
        this.studentrepo = studentrepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // create users
        Role role1 = new Role("user");
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), role1));
        rolerepo.save(role1);

        User u1 = new User("admin", "password", users);
        userrepo.save(u1);

        // create an Instructor

        Instructor ins1 = new Instructor("Hard Knocks");
        Course c1 = new Course("Life", ins1);
        ins1.getCourses().add(c1);

        insrepo.save(ins1);

    }
}
