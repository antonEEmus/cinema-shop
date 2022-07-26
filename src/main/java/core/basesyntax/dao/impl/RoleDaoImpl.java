package core.basesyntax.dao.impl;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.dao.RoleDao;
import core.basesyntax.model.Role;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Role> query = criteriaBuilder.createQuery(Role.class);
            Role.RoleName role = null;
            for (Role.RoleName roleName1 : Role.RoleName.values()) {
                if (roleName1.getRoleName().equals(roleName)) {
                    role = roleName1;
                    break;
                }
            }
            query.where(criteriaBuilder.equal(query.from(Role.class).get("roleName"), role));
            return session.createQuery(query).uniqueResultOptional();
        }
    }
}
