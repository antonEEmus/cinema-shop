package core.basesyntax.service;

import core.basesyntax.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
