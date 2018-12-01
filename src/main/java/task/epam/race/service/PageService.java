package task.epam.race.service;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface PageService {

    void setAttributes(HttpServletRequest request) throws SQLException;
}
