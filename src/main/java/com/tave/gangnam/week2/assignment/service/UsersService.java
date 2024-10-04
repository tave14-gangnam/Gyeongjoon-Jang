package com.tave.gangnam.week2.assignment.service;

import com.tave.gangnam.week2.assignment.Entity.Users;
import com.tave.gangnam.week2.assignment.dto.UsersDto;
import com.tave.gangnam.week2.assignment.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

//    // UserRepository 필드 선언
//    public final UsersRepository usersRepository;
//
//    // 의존성 주입을 통해 UserRepository를 주입 -> Service에서 Repository 사용 가능
//    public UsersService(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//
//    // 조회
//    public Users show(Long id) {
//        return usersRepository.findById(id).orElse(null);
//    }
//
//    // 저장
//    public Users create(UsersDto dto) {
//        Users users = dto.toEntity();
//        if (users != null) {
//            return null;
//        }
//        return usersRepository.save(users);
//    }
}
