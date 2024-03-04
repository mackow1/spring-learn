package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel create() {
        LOGGER.info("create()");

        UserModel result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
