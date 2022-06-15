package com.example.nobodycanstopus.Controller;

import com.example.nobodycanstopus.Model.User;
import com.example.nobodycanstopus.dto.LoginRequetsDto;
import com.example.nobodycanstopus.dto.UserRequestsDto;
import com.example.nobodycanstopus.exception.ApiResponseMessage;
import com.example.nobodycanstopus.jwt.JwtTokenProvider;
import com.example.nobodycanstopus.repository.UserRepository;
import com.example.nobodycanstopus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원 가입
    @PostMapping("/api/signup")
    public ResponseEntity<ApiResponseMessage> createUser(@RequestBody UserRequestsDto requestsDto) {
        userService.createUser(requestsDto);


        ApiResponseMessage message = new ApiResponseMessage("Success", "회원가입이 완료되었습니다", "", "");
        return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.OK);

    }
    // 아이디 중복 체크
    @PostMapping ("/api/singup/usernameck")
    public Optional<User> usernameck(@PathVariable String username) {
      return userRepository.findByUsername(username);
    }
    //닉네임 중복체크
    @PostMapping("/api/singup/nicknameck")
    public Optional<User>nicknameck(@PathVariable String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @PostMapping("/api/login")
    public String login(@RequestBody LoginRequetsDto loginRequestDto) {
        if (userService.login(loginRequestDto)) {
            String token = jwtTokenProvider.createToken(loginRequestDto.getUsername());
            System.out.println(token);
            return token;
        } else {
            return "닉네임 또는 패스워드를 확인해주세요";
        }
    }

}
