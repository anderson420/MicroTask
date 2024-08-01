package com.example.microtask.feign;

import com.example.microtask.domain.feign.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="user", url="http://localhost:8080/micro-user")
public interface UserService {
    @GetMapping("user/{id}")
    User findUserById(@PathVariable("id") Long id);
}
