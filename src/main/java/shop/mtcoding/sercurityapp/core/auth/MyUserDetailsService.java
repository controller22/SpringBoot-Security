package shop.mtcoding.sercurityapp.core.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.sercurityapp.model.User;
import shop.mtcoding.sercurityapp.model.UserRepository;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // login + post + FormUrlEncoded + username, password
    // Authentication 객체 만들어짐

    @Override
    public UserDetails loadUserByUsername(String userename) throws UsernameNotFoundException {
        Optional<User> userOP = userRepository.findByUsername(userename);
        if (userOP.isPresent()) {
            return new MyUserDetails(userOP.get());
        } else {
            return null;
        }
    }
}
