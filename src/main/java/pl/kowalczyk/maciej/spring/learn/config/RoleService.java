package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RoleService {

    private static final Logger LOGGER = Logger.getLogger(RoleService.class.getName());

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleModel> list() {
        LOGGER.info("list()");

        List<RoleEntity> roleEntities = roleRepository.findAll();
        List<RoleModel> roleModels = roleMapper.fromEntities(roleEntities);

        LOGGER.info("list(...) = " + roleModels);
        return roleModels;
    }

}
