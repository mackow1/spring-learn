package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kowalczyk.maciej.spring.learn.api.exception.user.UserCreateException;
import pl.kowalczyk.maciej.spring.learn.api.exception.user.UserDeleteException;
import pl.kowalczyk.maciej.spring.learn.api.exception.user.UserReadException;
import pl.kowalczyk.maciej.spring.learn.api.exception.user.UserUpdateException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<UserModel> list() {
        LOGGER.info("list()");

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserModel> userModels = userMapper.fromEntities(userEntities);

        LOGGER.info("list(...) = " + userModels);
        return userModels;
    }

    public UserModel create(UserModel userModel) throws UserCreateException {
        LOGGER.info("create(" + userModel + ")");

//        Metoda save sprawdza null

//        if (userModel == null) {
//            throw new UserCreateException("Model must not be NULL");
//        }

        try {
            String passwordEncoded = passwordEncoder.encode(userModel.getPassword());
            userModel.setPassword(passwordEncoded);

            Long roleId = userModel.getRoleId();
            Optional<RoleEntity> optionalRoleEntity = roleRepository.findById(roleId);
            RoleEntity selectedRoleEntity = optionalRoleEntity.orElseThrow(
                    () -> new UserCreateException("Entity does not exist")
            );

            UserEntity userEntity = userMapper.from(userModel);
            userEntity.add(selectedRoleEntity);

            UserEntity savedUserEntity = userRepository.save(userEntity);
            UserModel createdUserModel = userMapper.from(savedUserEntity);

            LOGGER.info("create(...) = " + createdUserModel);
            return createdUserModel;
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Data access exception for user: " + userModel, e);
            throw new UserCreateException("Data access exception for user creation");
        }

    }

    public UserModel read(Long id) throws UserReadException {
        LOGGER.info("read(" + id + ")");

        if (id == null) {
            throw new UserReadException("ID must not be NULL");
        }

        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        UserEntity userEntity = optionalUserEntity.orElseThrow(
                () -> {
                    LOGGER.log(Level.SEVERE, "User not found for given ID: ", id);
                    return new UserReadException("User not found for given ID: " + id);
                });

        UserModel readUserModel = userMapper.from(userEntity);

        LOGGER.info("read(...) = " + readUserModel);
        return readUserModel;
    }

    public UserModel update(UserModel userModel) throws UserUpdateException {
        LOGGER.info("update(" + userModel + ")");

        if (userModel == null) {
            throw new UserUpdateException("Model must not be NULL");
        }

        String passwordEncoded = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(passwordEncoded);

        UserEntity userEntity = userMapper.from(userModel);
        UserEntity updatedUserEntity;

        try {
            updatedUserEntity = userRepository.save(userEntity);
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Data integrity violation when updating user: " + userEntity, e);
            throw new UserUpdateException("Data integrity violation for user update.");
        }

        UserModel updatedUserModel = userMapper.from(updatedUserEntity);

        LOGGER.info("update(...) = " + updatedUserModel);
        return updatedUserModel;
    }

    public void delete(Long id) throws UserDeleteException {
        LOGGER.info("delete(" + id + ")");

        try {
            userRepository.deleteById(id);
        } catch (DataAccessException e) {
            LOGGER.log(Level.SEVERE, "Database access error while deleting user with ID: " + id, e);
            throw new UserDeleteException("error while deleting user with ID: " + id);
        }

        LOGGER.info("delete(...) = ");
    }
}
