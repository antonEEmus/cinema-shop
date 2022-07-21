package core.basesyntax.dao.impl;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.dao.TicketDao;
import core.basesyntax.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
