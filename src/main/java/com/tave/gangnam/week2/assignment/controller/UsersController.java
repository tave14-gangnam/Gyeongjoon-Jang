package com.tave.gangnam.week2.assignment.controller;

import com.tave.gangnam.week2.assignment.Entity.Users;
import com.tave.gangnam.week2.assignment.dto.UsersDto;
import com.tave.gangnam.week2.assignment.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {
//
//    // UsersService 필드 선언
//    private final UsersService usersService;
//
//    // 의존선 주입을 통해 UsersService 주입 -> Controller 에서 Service 사용 가능
//    public UsersController(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//    // 조회
//    @GetMapping("/users/{id}")
//    public Users show(@PathVariable Long id) {
//        return usersService.show(id);
//    }
//
//    // 저장
//    @PostMapping("/users")
//    public Users create(@RequestBody UsersDto dto) {
//        return usersService.create(dto);
//    }
}
