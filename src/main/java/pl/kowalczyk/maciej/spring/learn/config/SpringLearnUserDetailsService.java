package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringLearnUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    private static Map<String, String> credentials = new HashMap<>();
//
//    static {
//        credentials.put("admin", "password");
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

//        if (userEntity.getPassword() != null) {
        return User.withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles("USER")
                .build();
//        }
//        return null;
    }
}
