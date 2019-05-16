package com.lambdaschool.school;

import com.lambdaschool.school.models.*;
import com.lambdaschool.school.daos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    private UserDao userrepo;
    private RoleDao rolerepo;

    private InstructorDao insrepo;
    private CourseDao courserepo;
    private StudentDao studentrepo;

    public SeedData(UserDao userrepo, RoleDao rolerepo,
            InstructorDao insrepo, CourseDao courserepo, StudentDao studentrepo) {
        this.userrepo = userrepo;
        this.rolerepo = rolerepo;
        this.insrepo = insrepo;
        this.courserepo = courserepo;
        this.studentrepo = studentrepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // create Roles
        Role role1 = new Role("user");
        Role role2 = new Role("ADMIN");
        rolerepo.saveAll(Arrays.asList(role1, role2));

        // set up userRoles
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), role1));
        admins.add(new UserRoles(new User(), role2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), role1));

        // create users
        User u1 = new User("admin", "password", admins);
        User u2 = new User("josh", "josh", users);
        userrepo.saveAll(Arrays.asList(u1, u2));

        // create Instructors and classes
        Instructor ins1 = new Instructor("Hard Knocks");
        Course c1 = new Course("Life", ins1);

        insrepo.save(ins1);
        courserepo.save(c1);

        Instructor ins2 = new Instructor("Youtube");
        Course c2 = new Course ("Whatever you want", ins2);
        Course c3 = new Course ("Reaction Videos", ins2);

        insrepo.save(ins2);
        courserepo.saveAll(Arrays.asList(c2, c3));


        Instructor ins3 = new Instructor("Mom");
        Course c4 = new Course ("I brought you into this world", ins3);
        Course c5 = new Course ("I can take you out", ins3);

        insrepo.save(ins3);
        courserepo.saveAll(Arrays.asList(c4, c5));


    }
}
