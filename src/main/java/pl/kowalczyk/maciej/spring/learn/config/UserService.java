package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserModel> list() {
        LOGGER.info("list()");

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> userModels = userMapper.fromEntities(userEntities);

        LOGGER.info("list(...) = " + userModels);
        return userModels;
    }

    public UserModel create() {
        LOGGER.info("create()");

        UserModel result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
