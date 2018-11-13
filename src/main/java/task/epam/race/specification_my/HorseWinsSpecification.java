package task.epam.race.specification_my;

import task.epam.race.entity.Horse;

import static task.epam.race.constant.SqlConstant.*;

import java.sql.Connection;
import java.sql.SQLException;

public class HorseWinsSpecification extends Specification<Horse> {

    public HorseWinsSpecification(int win,Connection connection) throws SQLException {
        super(connection, SQL_HORSES_SELECT_BY_NAME);
        this.getPreparedStatement().setInt(1,win);
    }

}
