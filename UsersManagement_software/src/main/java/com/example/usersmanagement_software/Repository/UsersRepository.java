package com.example.usersmanagement_software.Repository;

import com.example.usersmanagement_software.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    Users findUserById(Integer id);
    Users findUsersByUsernameAndPassword(String username, String password);
    Users findByEmail(String email);
    List<Users> findAllByRole(String role);
    List<Users> findAllByAgeGreaterThanEqual(Integer age);

}
