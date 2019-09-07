package org.sefglobal.core.partnership.dao;

import org.sefglobal.core.partnership.beans.University;
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

    public University getUniversity(int id) {
        try {
            University university = jdbcTemplate.queryForObject(
                    "SELECT * FROM university WHERE id = ? AND status='ACTIVE'",
                    new Object[]{id}, (rs, rowNum) -> {
                        University u = new University();
                        u.setId(id);
                        u.setName(rs.getString("name"));
                        u.setAmbassadorName(rs.getString("ambassador_name"));
                        u.setAmbassadorEmail(rs.getString("ambassador_email"));
                        u.setImageUrl(rs.getString("image_url"));
                        u.setStatus(rs.getString("status"));
                        return u;
                    }
            );
            return university;
        } catch (DataAccessException e) {
            logger.error("Unable to get info of '" + id + "'", e);
        }

        return null;
    }

    public List<University> getAllUniversities(){
        try {
            List<University> result = jdbcTemplate.query("SELECT * FROM university WHERE status='ACTIVE'",
                    (rs, rowNum) -> {
                        University u = new University();
                        u.setId(rs.getInt("id"));
                        u.setName(rs.getString("name"));
                        u.setAmbassadorName(rs.getString("ambassador_name"));
                        u.setAmbassadorEmail(rs.getString("ambassador_email"));
                        u.setImageUrl(rs.getString("image_url"));
                        u.setStatus(rs.getString("status"));
                        return u;
                    });

            return result;
        } catch (DataAccessException e) {
            logger.error("Unable to get all university info", e);
        }
        return null;
    }

}
