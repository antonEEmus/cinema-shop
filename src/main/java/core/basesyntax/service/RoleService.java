package core.basesyntax.service;

import core.basesyntax.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
