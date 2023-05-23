package com.example.usersmanagement_software.Service;

import com.example.usersmanagement_software.ApiException.ApiException;
import com.example.usersmanagement_software.Model.Users;
import com.example.usersmanagement_software.Repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public void addUsers(Users users){
        usersRepository.save(users);
    }
    public boolean updateUsers(Integer id, Users users ) {
        Users oldUsers = usersRepository.findUserById(id);
        if (oldUsers == null) {
            return false;
        }

        oldUsers.setId(users.getId());
        oldUsers.setName(users.getName());
        oldUsers.setUsername(users.getUsername());
        oldUsers.setPassword(users.getPassword());
        oldUsers.setEmail(users.getEmail());
        oldUsers.setRole(users.getRole());
        oldUsers.setAge(users.getAge());


        usersRepository.save(oldUsers);
        return true;
    }

    public boolean deleteUsers(Integer id){
        Users oldUsers = usersRepository.findUserById(id);
        if (oldUsers==null){
            return true;
        }
        return false;
    }

    public Users findUserById(Integer id){
        Users users=usersRepository.findUserById(id);
        if (users==null) {
            throw new ApiException("not found");
        }
        return users;
    }

    public Users findUsersByUsernameAndPassword(String username,String password){
       Users users=usersRepository.findUsersByUsernameAndPassword(username,password);
if (users==null){
           throw new ApiException("not correct");
       }
       return users;
    }
    public Users getUserByEmail(String email){
        Users users=usersRepository.findByEmail(email);
        if (users==null){
            throw new ApiException("Email not found");
        }
        return users;    }

    public List<Users> getAllByRole(String role){
        List<Users>users=usersRepository.findAllByRole(role);
        if (users==null){
            throw new ApiException("Role not found");
        }
        return users;
    }

    public List<Users> getAllByAge(Integer age){
        List<Users>users=usersRepository.findAllByAgeGreaterThanEqual(age);
        if (users==null){
            throw new ApiException("Wrong Age");
        }
        return users;

}
}
