package darius.licenta.backend.service.user;

import darius.licenta.backend.configuration.security.JwtTokenProvider;
import darius.licenta.backend.domain.sql.Employee;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.dto.normal.story.response.table.TableUserDto;
import darius.licenta.backend.dto.normal.user.*;
import darius.licenta.backend.exception.InvalidUsernameAndPasswordException;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.normal.story.StoryMapper;
import darius.licenta.backend.mapper.normal.user.UserMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.jpa.EmployeeRepository;
import darius.licenta.backend.persistence.jpa.StoryRepository;
import darius.licenta.backend.persistence.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
class UserServiceImpl implements UserService, UserAccountOperationsService {
    private final static String USERNAME = "username";
    private final static String REGEX_EMAIL_PATTERN = "^[^@]+@[^@]+\\.[^@]{2}[^@]*$";

    private final UserRepository userRepository;
    private final StoryRepository storyRepository;
    private final EmployeeRepository employeeRepository;
    private final UserMapper userMapper;
    private final StoryMapper storyMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, StoryRepository storyRepository, EmployeeRepository employeeRepository, UserMapper userMapper, StoryMapper storyMapper, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.storyRepository = storyRepository;
        this.employeeRepository = employeeRepository;
        this.userMapper = userMapper;
        this.storyMapper = storyMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ApiResponse<List<UserStoryActivityDto>> getUserLatestActivity(Long id) {
        Pageable topTenResults = PageRequest.of(0, 10);
        List<Story> stories = storyRepository.findByCreatedBy_IdOrderByModificationDateAsc(id, topTenResults);
        List<UserStoryActivityDto> userStoryActivityDtos = new ArrayList<>();
        for (Story story : stories) {
            UserStoryActivityDto userStoryActivityDto = storyMapper.storyToUserStoryActivityDto(story);
            userStoryActivityDtos.add(userStoryActivityDto);
        }

        return new ApiResponse<>(userStoryActivityDtos, HttpStatus.OK);
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
            PaginatedResponse<TableUserDto> paginatedResponse = new PaginatedResponse<>(allUsers.getNumber(), allUsers.getSize(), allUsers.getNumberOfElements(),
                    new ArrayList<>(), allUsers.getTotalElements(), allUsers.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<TableUserDto> allUsersDto = new ArrayList<>();

        allUsers.getContent().forEach(user -> allUsersDto.add(userMapper.userToTableUserDto(user)));

        PaginatedResponse<TableUserDto> paginatedResponse = new PaginatedResponse<>(allUsers.getNumber(), allUsers.getSize(), allUsers.getNumberOfElements(),
                allUsersDto, allUsers.getTotalElements(), allUsers.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<List<UserBasicInfoDto>> getAllUsersBasicInfo() {
        return new ApiResponse<>(userRepository.getAllUsersBasicInfo(), HttpStatus.OK);
    }

    @Override
    public ApiResponse<ResponseUserWithJwtDto> insert(CreateUserDto createUserDto) {
        User user = userMapper.createUserDtoToUser(createUserDto);
        if (Boolean.FALSE.equals(userRepository.existsByUsername(user.getUsername()))) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            ResponseUserDto responseUserDtoWithoutJwt = userMapper.userToResponseUserDto(user);
            List<UserRole> userRoles = user.getUserRoles();
            String jwtToken = jwtTokenProvider.createToken(user.getUsername(), userRoles);
            ResponseUserWithJwtDto responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, jwtToken, userRoles);
            return new ApiResponse<>(responseUserWithJwtDto, HttpStatus.OK);
        } else {
            throw new InvalidUsernameAndPasswordException("Username is already in use");
        }
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

    @Override
    public ApiResponse<ResponseUserWithJwtDto> signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()) {
                List<UserRole> userRoles = user.get().getUserRoles();
                String jwtToken = jwtTokenProvider.createToken(username, userRoles);
                ResponseUserDto responseUserDtoWithoutJwt = userMapper.userToResponseUserDto(user.get());
                Optional<Employee> employee = employeeRepository.findByUser_Username(username);
                ResponseUserWithJwtDto responseUserWithJwtDto;
                if (employee.isPresent()) {
                    String firstName = employee.get().getPerson().getFirstName();
                    String lastname = employee.get().getPerson().getLastName();
                    String positionName = employee.get().getPosition().getName();
                    String positionSeniority = employee.get().getPosition().getSeniorityLevel();
                    responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, jwtToken, userRoles,
                            firstName, lastname, positionName, positionSeniority);

                } else {
                    responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, jwtToken, userRoles);
                }
                return new ApiResponse<>(responseUserWithJwtDto, HttpStatus.OK);
            } else {
                throw new UserNotFoundException("Cannot find username");
            }
        } catch (AuthenticationException e) {
            throw new InvalidUsernameAndPasswordException("Invalid username/password supplied");
        }
    }

    @Override
    public ApiResponse<ResponseUserDto> updateUserBio(UpdateUserBioDto updateUserBioDto, String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().setBioDescription(updateUserBioDto.getBioDescription());
            userRepository.save(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<ResponseUserDto> updateUserEmail(String jwtUsername, UpdateUserEmailDto updateUserEmailDto) {
        if (!jwtUsername.equals(updateUserEmailDto.getUsername())) {
            return new ApiResponse<>("Cannot update email on the current user", null, HttpStatus.BAD_REQUEST);
        }
        if (!checkIfMailIsValid(updateUserEmailDto.getEmail())) {
            return new ApiResponse<>("Email is not valid", null, HttpStatus.BAD_REQUEST);
        }

        Optional<User> user = userRepository.findByUsername(updateUserEmailDto.getUsername());
        if (user.isPresent()) {
            user.get().setEmail(updateUserEmailDto.getEmail());
            userRepository.save(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.OK);
        }

        return new ApiResponse<>("Could not find user with username" + updateUserEmailDto.getUsername(), null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<ResponseUserDto> updateUserPassword(String jwtUsername, UpdateUserPasswordDto updateUserPasswordDto) {
        if (!jwtUsername.equals(updateUserPasswordDto.getUsername())) {
            return new ApiResponse<>("Cannot update password on the current user", null, HttpStatus.BAD_REQUEST);
        }

        Optional<User> user = userRepository.findByUsername(updateUserPasswordDto.getUsername());
        if (user.isPresent()) {
            user.get().setPassword(passwordEncoder.encode(updateUserPasswordDto.getPassword()));
            userRepository.save(user.get());
            ResponseUserDto responseUserDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(responseUserDto, HttpStatus.OK);
        }
        String reason = "Password could not be changed";
        if (updateUserPasswordDto.getPassword().length() < 8) {
            reason = "Password must be at least 8 characters long";
        }
        return new ApiResponse<>(reason, null, HttpStatus.BAD_REQUEST);
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
    public ApiResponse<ResponseUserDto> search(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            ResponseUserDto userDto = userMapper.userToResponseUserDto(user.get());
            return new ApiResponse<>(userDto, HttpStatus.OK);
        } else {
            throw new InvalidUsernameAndPasswordException("Username not found");
        }

    }

    @Override
    public ApiResponse<ResponseUserWithJwtDto> whoami(HttpServletRequest req) {
        String username = jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req));
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            List<UserRole> userRoles = user.get().getUserRoles();
            String jwtToken = jwtTokenProvider.createToken(username, userRoles);
            ResponseUserDto responseUserDtoWithoutJwt = userMapper.userToResponseUserDto(user.get());
            Optional<Employee> employee = employeeRepository.findByUser_Username(username);
            ResponseUserWithJwtDto responseUserWithJwtDto;
            if (employee.isPresent()) {
                String firstName = employee.get().getPerson().getFirstName();
                String lastname = employee.get().getPerson().getLastName();
                String positionName = employee.get().getPosition().getName();
                String positionSeniority = employee.get().getPosition().getSeniorityLevel();
                responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, jwtToken, userRoles,
                        firstName, lastname, positionName, positionSeniority);

            } else {
                responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, jwtToken, userRoles);
            }
            return new ApiResponse<>(responseUserWithJwtDto, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Cannot find username");
        }
    }

    @Override
    public ApiResponse<ResponseUserWithJwtDto> getUserProfileDetailsById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            List<UserRole> userRoles = user.get().getUserRoles();
            ResponseUserDto responseUserDtoWithoutJwt = userMapper.userToResponseUserDto(user.get());
            Optional<Employee> employee = employeeRepository.findByUser_Id(id);
            ResponseUserWithJwtDto responseUserWithJwtDto;
            if (employee.isPresent()) {
                String firstName = employee.get().getPerson().getFirstName();
                String lastname = employee.get().getPerson().getLastName();
                String positionName = employee.get().getPosition().getName();
                String positionSeniority = employee.get().getPosition().getSeniorityLevel();
                responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, null, userRoles,
                        firstName, lastname, positionName, positionSeniority);
            } else {
                responseUserWithJwtDto = new ResponseUserWithJwtDto(responseUserDtoWithoutJwt, null, userRoles);
            }
            return new ApiResponse<>(responseUserWithJwtDto, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Cannot find id");
        }
    }

    @Override
    public String refreshJwtToken(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
        return jwtTokenProvider.createToken(username, user.getUserRoles());
    }


    private boolean checkIfMailIsValid(String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}