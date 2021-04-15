package com.microservices.users.services;

import com.microservices.users.entities.User;
import com.microservices.users.repositories.UserRepository;
import com.microservices.users.vo.Department;
import com.microservices.users.vo.ResponseTemplateVO;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Log
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    /* private WebClient webClient; */

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id) {
        User user = userRepository.getUserById(id);
        log.info("User=" + user.toString());
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class );
        /*
        Mono<Department> department = webClient.get().uri("http://localhost:9081/departments/" + user.getDepartmentId()).accept(MediaType.ALL).retrieve().bodyToMono(Department.class );
        log.info("Department from mono="+department.block().toString());
        responseTemplateVO.setDepartment(department.block());
        */
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }

}
