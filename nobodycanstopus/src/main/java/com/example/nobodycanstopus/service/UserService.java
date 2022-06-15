package com.example.nobodycanstopus.service;


import com.example.nobodycanstopus.Model.User;
import com.example.nobodycanstopus.dto.LoginRequetsDto;
import com.example.nobodycanstopus.dto.UserRequestsDto;
import com.example.nobodycanstopus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void createUser(UserRequestsDto requestsDto) {
        String nickname = requestsDto.getNickname();
        String username = requestsDto.getUsername();
        String password = requestsDto.getPassword();
        String passwordCk = requestsDto.getPasswordCk();;
        System.out.println("passwordCk = " + passwordCk);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("nickname = " + nickname);

        if(!password.equals(passwordCk)){
            throw new IllegalArgumentException("비밀번호와 비밀번호 확인이 같지않습니다 확인해주세요");

        }
            //패스워드 암호화
            password = passwordEncoder.encode(requestsDto.getPassword());
            passwordCk = passwordEncoder.encode(requestsDto.getPasswordCk());


            User user = new User(nickname, username, password, passwordCk);
            System.out.println("user = " + user);
            userRepository.save(user);

    }
    public Boolean login(LoginRequetsDto loginRequetsDto){
        User user = userRepository.findByUsername(loginRequetsDto.getUsername())
                .orElse(null);
        if (user != null) {
            if (!passwordEncoder.matches(loginRequetsDto.getPassword(), user.getPassword())) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
