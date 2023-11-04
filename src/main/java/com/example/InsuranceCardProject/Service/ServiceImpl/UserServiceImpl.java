package com.example.InsuranceCardProject.Service.ServiceImpl;

import com.example.InsuranceCardProject.Entity.Role;
import com.example.InsuranceCardProject.Entity.User;
import com.example.InsuranceCardProject.Repository.UserRepository;
import com.example.InsuranceCardProject.Service.RoleService;
import com.example.InsuranceCardProject.Service.UserService;
import com.example.InsuranceCardProject.dto.RequestUserDTO;
import com.example.InsuranceCardProject.dto.UpdateUserDTO;
import com.example.InsuranceCardProject.dto.UserResponseDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    @Override
    public UserResponseDTO addNewUser(RequestUserDTO requestUserDTO) {
        Role role = roleService.getRoleUser();
        User user = new User();
        user.setName(requestUserDTO.getName());
        user.setUsername(requestUserDTO.getUsername());
        user.setPassword(requestUserDTO.getPassword());
        user.setPhone(requestUserDTO.getPhone());
        user.setDateOfBirth(requestUserDTO.getDateOfBirth());
        user.setGender(requestUserDTO.isGender());
        user.setAddress(requestUserDTO.getAddress());
        user.setEmail(requestUserDTO.getEmail());
        user.setRole(role);
        user =  userRepository.save(user);
        UserResponseDTO userResponseDTO = UserResponseDTO.builder()
                .name(user.getName())
                .username(user.getUsername())
                .phone(user.getPhone())
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.isGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .role(role.getRole())
                .build();
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for(User user : userList){
            UserResponseDTO userResponseDTO = UserResponseDTO.builder()
                    .name(user.getName())
                    .username(user.getUsername())
                    .phone(user.getPhone())
                    .dateOfBirth(user.getDateOfBirth())
                    .gender(user.isGender())
                    .address(user.getAddress())
                    .email(user.getEmail())
                    .role(user.getRole().getRole())
                    .build();
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    @Override
    public UserResponseDTO updateUser(Integer id, UpdateUserDTO requestUserDTO) {
        User user = userRepository.findById(id).get();
        user.setName(requestUserDTO.getName());
        user.setPassword(requestUserDTO.getPassword());
        user.setPhone(requestUserDTO.getPhone());
        user.setDateOfBirth(requestUserDTO.getDateOfBirth());
        user.setGender(requestUserDTO.isGender());
        user.setAddress(requestUserDTO.getAddress());
        user.setEmail(requestUserDTO.getEmail());
        user =  userRepository.save(user);
        UserResponseDTO userResponseDTO = UserResponseDTO.builder()
                .name(user.getName())
                .username(user.getUsername())
                .phone(user.getPhone())
                .dateOfBirth(user.getDateOfBirth())
                .gender(user.isGender())
                .address(user.getAddress())
                .email(user.getEmail())
                .role(user.getRole().getRole()  )
                .build();
        return userResponseDTO;
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
