package org.sefglobal.core.partnership.dao;

import org.sefglobal.core.partnership.beans.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAO {

    private Logger logger = LoggerFactory.getLogger(EventDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Gets an event by eventId
     * @param id eventId
     * @return Event
     */
    public Event getEvent(int id) {

        String sqlQuery = "" +
                "SELECT " +
                "   * " +
                "FROM " +
                "   event " +
                "WHERE " +
                "   id=? " +
                "   AND " +
                "   status='ACTIVE'";

        try {
            return jdbcTemplate.queryForObject(
                    sqlQuery,
                    new Object[]{id},
                    (rs, rowNum) -> new Event(rs)
            );
        } catch (DataAccessException e) {
            logger.error("Unable to get info of '" + id + "'", e);
        }

        return null;
    }
}
