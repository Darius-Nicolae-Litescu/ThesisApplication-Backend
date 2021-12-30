package darius.licenta.backend.service.user;

import darius.licenta.backend.domain.User;
import darius.licenta.backend.dto.user.*;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.user.UserMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class UserServiceImpl implements UserService {
    private final String USERNAME = "username";

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository roleRepository, UserMapper userMapper) {
        this.userRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public ApiResponse<ResponseUserDto> getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        ResponseUserDto userDto = userMapper.userToResponseUserDto(user);
        return new ApiResponse<>(userDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, USERNAME);
        Page<User> allUsers = userRepository.findAll(pageable);
        if (allUsers.getNumberOfElements() == 0) {
            PaginatedResponse<ResponseUserDto> paginatedResponse = new PaginatedResponse<>(allUsers.getNumber(), allUsers.getSize(), allUsers.getNumberOfElements(),
                    new ArrayList<>(), allUsers.getTotalElements(), allUsers.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<ResponseUserDto> allUsersDto = new ArrayList<>();

        allUsers.getContent().forEach(user -> allUsersDto.add(userMapper.userToResponseUserDto(user)));

        PaginatedResponse<ResponseUserDto> paginatedResponse = new PaginatedResponse<>(allUsers.getNumber(), allUsers.getSize(), allUsers.getNumberOfElements(),
                allUsersDto, allUsers.getTotalElements(), allUsers.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<ResponseUserDto> insert(CreateUserDto createUserDto) {
        User user = userMapper.createUserDtoToUser(createUserDto);

        userRepository.save(user);

        ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user);
        return new ApiResponse<>(responseUserDto, HttpStatus.OK);
    }

    @Override
    public ApiResponse<ResponseUserDto> changePassword(UpdateUserPasswordDto updateUserPasswordDto) {
        Optional<User> user = userRepository.findByUsername(updateUserPasswordDto.getUsername());
        if (user.isPresent()) {
            user.get().setPassword(updateUserPasswordDto.getPassword());
            userRepository.save(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<ResponseUserDto> changeEmail(UpdateUserEmailDto updateUserEmailDto) {
        Optional<User> user = userRepository.findByUsername(updateUserEmailDto.getUsername());
        if (user.isPresent()) {
            user.get().setEmail(updateUserEmailDto.getEmail());
            userRepository.save(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<ResponseUserDto> changeProfilePicture(UpdateUserProfilePictureDto updateUserProfilePictureDto) {
        Optional<User> user = userRepository.findByUsername(updateUserProfilePictureDto.getUsername());
        if (user.isPresent()) {
            user.get().setProfilePicture(updateUserProfilePictureDto.getProfilePicture());
            userRepository.save(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<ResponseUserDto> deleteUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.ACCEPTED);
        } else {
            throw new UserNotFoundException("Username " + username + " cannot be found in database");
        }
    }

    @Override
    public ApiResponse<ResponseUserDto> deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.ACCEPTED);
        } else {
            throw new UserNotFoundException("Id " + id + " cannot be found in database");
        }
    }

}