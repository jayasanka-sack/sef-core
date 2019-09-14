package org.sefglobal.core.partnership.dao;

import org.sefglobal.core.partnership.beans.CensoredUniversity;
import org.sefglobal.core.partnership.beans.University;
import org.sefglobal.core.partnership.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UniversityDAO {

    private Logger logger = LoggerFactory.getLogger(UniversityDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Gets an university by universityId
     * @param id universityId
     * @return University
     */
    public University getUniversity(int id) throws ResourceNotFoundException{

        String sqlQuery = "" +
                "SELECT " +
                "   * " +
                "FROM " +
                "   university " +
                "WHERE " +
                "   id = ? " +
                "AND " +
                "   status='ACTIVE'";

        try {
            return jdbcTemplate.queryForObject(
                    sqlQuery,
                    new Object[]{id},
                    (resultSet, rowNum) -> new University(resultSet)
            );
        } catch (DataAccessException e) {
            logger.error("Unable to get info of '" + id + "'", e);
            throw new ResourceNotFoundException("University not found");
        }
    }
    /**
     * Gets an university with hidden data by universityId
     * @param id universityId
     * @return University
     */
    public CensoredUniversity getCensoredUniversity(int id) {

        String sqlQuery = "" +
                "SELECT " +
                "   * " +
                "FROM " +
                "   university " +
                "WHERE " +
                "   id = ? " +
                "AND " +
                "   status='ACTIVE'";

        try {
            return jdbcTemplate.queryForObject(
                    sqlQuery,
                    new Object[]{id},
                    (resultSet, rowNum) -> new CensoredUniversity(resultSet)
            );
        } catch (DataAccessException e) {
            logger.error("Unable to get info of '" + id + "'", e);
        }

        return null;
    }

    /**
     * Gets all active universities
     * @return List of University
     */
    public List<University> getAllUniversities() {

        String sqlQuery ="" +
                "SELECT " +
                "   * " +
                "FROM " +
                "   university " +
                "WHERE " +
                "status='ACTIVE'";

        try {
            return jdbcTemplate.query(
                    sqlQuery,
                    (resultSet, rowNum) -> new University(resultSet)
            );
        } catch (DataAccessException e) {
            logger.error("Unable to get all university info", e);
        }
        return null;
    }

}
