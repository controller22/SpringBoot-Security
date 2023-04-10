package shop.mtcoding.sercurityapp.dto;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.sercurityapp.core.util.MyDateUtils;
import shop.mtcoding.sercurityapp.model.User;

public class UserResponse {

    @Getter
    @Setter
    public static class JoinDto {
        private Long id;
        private String username;
        private String eamil;
        private String role;
        private String createdAt;

        public JoinDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.eamil = user.getEmail();
            this.role = user.getRole();
            this.createdAt = MyDateUtils.toStringFormat(user.getCreatedAt());
        }
    }
}
