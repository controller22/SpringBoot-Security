package shop.mtcoding.sercurityapp.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.sercurityapp.dto.UserRequest;
import shop.mtcoding.sercurityapp.dto.UserResponse;
import shop.mtcoding.sercurityapp.model.User;
import shop.mtcoding.sercurityapp.model.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * 1. 트랜잭션 관리
     * 2. 영속성 객체 변경 감지
     * 3. RequestDTO 요청받기
     * 4. 비지니스 로직 처리하기
     * 5. ResponseDTO 응답하기
     */

    @Transactional
    public UserResponse.JoinDto 회원가입(UserRequest.JoinDTO joinDto) {
        String rawPassword = joinDto.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);
        joinDto.setPassword(encPassword);
        User userPS = userRepository.save(joinDto.toEntity());
        return new UserResponse.JoinDto(userPS);
    }
}
