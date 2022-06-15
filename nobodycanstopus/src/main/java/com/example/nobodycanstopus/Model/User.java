package com.example.nobodycanstopus.Model;

import com.example.nobodycanstopus.dto.UserRequestsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor // 기본 생성자 만듬.
@Getter // 조회를 하기 위해 있어야 됨.
@Entity
@Table(name = "Users")
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNumber;

    @JsonBackReference
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Post> postList = new ArrayList<>();


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String passwordCk;


    public User(UserRequestsDto requestDto) {

        this.username = requestDto.getUsername();
        this.nickname = requestDto.getNickname();
        this.password = requestDto.getPassword();
        this.passwordCk = requestDto.getPasswordCk();
    }


    public User(String nickname, String username, String password, String passwordCk) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.passwordCk = passwordCk;
    }
}
