package task.epam.race.service;

import task.epam.race.entity.Race;
import task.epam.race.repository.RaceRepository;
import task.epam.race.specification.race.SelectAllRacesSpecification;
import task.epam.race.util.constant.StringAttributes;
import task.epam.race.util.constant.StringConstant;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class MainPageService implements PageService {

    @Override
    public void setAttributes(HttpServletRequest request) throws SQLException {

        List<Race> allRaces = RaceRepository.getInstance().query(new SelectAllRacesSpecification());
        request.setAttribute("allRaces",allRaces);
        request.setAttribute(StringAttributes.LOGIN, request.getSession().
                getAttribute(StringAttributes.LOGIN));

    }
}
