package darius.licenta.backend.service.user;

import darius.licenta.backend.domain.User;
import darius.licenta.backend.dto.user.UserDto;
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

import javax.transaction.Transactional;
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

    @Transactional
    @Override
    public void saveOrUpdateUserPublicDetails(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public boolean deleteUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        } else
        {
            throw new UserNotFoundException("Username " + username + " cannot be found in database");
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        } else
        {
            throw new UserNotFoundException("Id " + id + " cannot be found in database");
        }
    }

    @Override
    public PaginatedResponse<UserDto> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, USERNAME);
        Page<User> allUsers = userRepository.findAll(pageable);
        if (allUsers.getNumberOfElements() == 0) {
            return new PaginatedResponse<>(allUsers.getNumber(), allUsers.getSize(), allUsers.getNumberOfElements(),
                    new ArrayList<>(), allUsers.getTotalElements(), allUsers.getTotalPages());
        }
        List<UserDto> allUsersDto = new ArrayList<>();
        allUsers.getContent().forEach(user -> allUsersDto.add(userMapper.userToUserDto(user)));
        return new PaginatedResponse<>(allUsers.getNumber(), allUsers.getSize(), allUsers.getNumberOfElements(),
                allUsersDto, allUsers.getTotalElements(), allUsers.getTotalPages());
    }

    @Override
    public ApiResponse<UserDto> getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        UserDto userDto = userMapper.userToUserDto(user);
        return new ApiResponse<>(userDto, HttpStatus.OK);
    }

    @Override
    public void insertUser(User user) {
        userRepository.save(user);
    }
}