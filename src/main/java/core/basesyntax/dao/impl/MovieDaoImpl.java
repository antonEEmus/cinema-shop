package core.basesyntax.dao.impl;

import core.basesyntax.dao.AbstractDao;
import core.basesyntax.dao.MovieDao;
import core.basesyntax.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
