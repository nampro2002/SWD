package com.example.InsuranceCardProject.Service;

import com.example.InsuranceCardProject.dto.RequestUserDTO;
import com.example.InsuranceCardProject.dto.UpdateUserDTO;
import com.example.InsuranceCardProject.dto.UserResponseDTO;
import java.util.List;

public interface UserService {

    UserResponseDTO addNewUser(RequestUserDTO addUserDTO);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Integer id, UpdateUserDTO requestUserDTO);

    void deleteUser(Integer id);
}
