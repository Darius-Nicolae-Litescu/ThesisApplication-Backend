package darius.licenta.backend.service.user;

import darius.licenta.backend.configuration.security.JwtTokenProvider;
import darius.licenta.backend.mapper.normal.story.StoryMapper;
import darius.licenta.backend.mapper.normal.user.UserMapper;
import darius.licenta.backend.persistence.jpa.EmployeeRepository;
import darius.licenta.backend.persistence.jpa.StoryRepository;
import darius.licenta.backend.persistence.jpa.UserRepository;
import darius.licenta.backend.service.person.PersonService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    UserService userService;
    @Mock
    UserRepository userRepository;
    @Mock
    StoryRepository storyRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    UserMapper userMapper;
    @Mock
    StoryMapper storyMapper;
    @Mock
    PasswordEncoder passwordEncoder;
    @Mock
    JwtTokenProvider jwtTokenProvider;
    @Mock
    AuthenticationManager authenticationManager;

    @BeforeEach
    void setUp()
    {
        this.userService= new UserServiceImpl(userRepository, storyRepository,
                employeeRepository, userMapper, storyMapper, passwordEncoder,
                jwtTokenProvider, authenticationManager);
    }

    @Test
    void testGetUserById() {
        userService.getUserById(1L);
        verify(userRepository).findById(1L);
    }


}