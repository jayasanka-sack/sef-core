package org.sefglobal.core.partnership.dao;

import org.sefglobal.core.partnership.beans.RankedUniversity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class EngagementDAO {

    private Logger logger = LoggerFactory.getLogger(EngagementDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RankedUniversity> getUniversityRanking() {

        String query = "" +
                "SELECT " +
                "   u.id," +
                "   u.name," +
                "   u.ambassador_name," +
                "   u.image_url, " +
                "   COUNT(v.event_id) as engagement  " +
                "FROM " +
                "   university u " +
                "INNER JOIN " +
                "   society s " +
                "ON " +
                "   u.id = s.university_id " +
                "INNER JOIN " +
                "   engagement v " +
                "ON " +
                "   s.id = v.society_id " +
                "WHERE " +
                "   u.status='ACTIVE' " +
                "GROUP BY " +
                "   u.id " +
                "ORDER BY " +
                "   engagement DESC";
        try {
            List<RankedUniversity> result = jdbcTemplate.query(query,
                    (rs, rowNum) -> {
                        RankedUniversity u = new RankedUniversity();
                        u.setId(rs.getInt("id"));
                        u.setName(rs.getString("name"));
                        u.setAmbassadorName(rs.getString("ambassador_name"));
                        u.setImageUrl(rs.getString("image_url"));
                        u.setEngagement(rs.getInt("engagement"));
                        return u;
                    });
            return result;
        } catch (DataAccessException e) {
            logger.error("Unable to get all university info", e);
        }
        return null;
    }

    public void addEngagement(int eventId, int societyId, String ip) {

        String query = "" +
                "INSERT INTO " +
                "   engagement(" +
                "       event_id, " +
                "       society_id, " +
                "       ip, " +
                "       interval_value " +
                "   ) " +
                "VALUES " +
                "   (?,?,?,?)";

        int intervalValue = (int) (new Date().getTime() / 10000);

        System.out.println((int) (new Date().getTime() / 10000));

        try {
            jdbcTemplate.update(query, eventId, societyId, ip, intervalValue);
        }catch (DataAccessException e){
            logger.error("Unable to add engagement", e);
        }
    }

}
