package core.basesyntax.dao.impl;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.dao.CinemaHallDao;
import core.basesyntax.model.CinemaHall;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory factory) {
        super(factory, CinemaHall.class);
    }
}
