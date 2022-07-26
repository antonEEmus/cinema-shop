package core.basesyntax.service.impl;

import core.basesyntax.model.User;
import core.basesyntax.service.AuthenticationService;
import core.basesyntax.service.RoleService;
import core.basesyntax.service.ShoppingCartService;
import core.basesyntax.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getByName("USER")));
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
