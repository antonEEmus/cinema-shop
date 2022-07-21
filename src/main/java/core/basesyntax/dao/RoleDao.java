package core.basesyntax.dao;

import core.basesyntax.model.Role;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);
}
