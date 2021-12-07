package darius.licenta.backend.testingdata;

import darius.licenta.backend.domain.Role;
import darius.licenta.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingData implements ApplicationRunner {

    private final RoleService roleService;


    @Autowired
    public TestingData(RoleService roleService) {
        this.roleService = roleService;
    }

    public void run(ApplicationArguments args) {
        Role normalUserRole = new Role();
    }
}