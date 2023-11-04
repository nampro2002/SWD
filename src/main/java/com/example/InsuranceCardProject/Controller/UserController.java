package com.example.InsuranceCardProject.Controller;

import com.example.InsuranceCardProject.Service.UserService;
import com.example.InsuranceCardProject.dto.RequestUserDTO;
import com.example.InsuranceCardProject.dto.UpdateUserDTO;
import com.example.InsuranceCardProject.dto.UserResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/addUser")
    public UserResponseDTO addUser(@RequestBody RequestUserDTO requestUserDTO) {
        System.out.println("add");
        return userService.addNewUser(requestUserDTO);
    }
    @GetMapping("/getUser")
    public List<UserResponseDTO> getUser() {
        System.out.println("get");
        return userService.getAllUsers();
    }
    @PutMapping("/user/{id}")
    public UserResponseDTO updateUser(@PathVariable Integer id, @RequestBody UpdateUserDTO updateUserDTO) {
        System.out.println("update");
        return userService.updateUser(id, updateUserDTO);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        System.out.println("delete");
        userService.deleteUser(id);
       return ResponseEntity.ok("delete ok");
    }
}
