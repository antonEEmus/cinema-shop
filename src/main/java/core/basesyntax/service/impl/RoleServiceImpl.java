package core.basesyntax.service.impl;

import core.basesyntax.dao.RoleDao;
import core.basesyntax.model.Role;
import core.basesyntax.service.RoleService;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleDao.getByName(roleName).orElseThrow(
                () -> new NoSuchElementException("No such role by name: " + roleName));
    }
}
