package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SpringLearnUserDetailsService implements UserDetailsService {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = credentials.get(username);

        if (password != null) {
            return User.withDefaultPasswordEncoder()
                    .username(username)
                    .password(password)
                    .build();
        }

        return null;
    }
}
