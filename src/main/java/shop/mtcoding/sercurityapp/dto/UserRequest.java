package shop.mtcoding.sercurityapp.dto;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.sercurityapp.model.User;

public class UserRequest {

    @Getter
    @Setter
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;
        private String role;

        public User toEntity() {
            return User.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .role(role)
                    .status(true)
                    .build();
        }
    }
}
