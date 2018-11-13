package task.epam.race.specification_my;

import task.epam.race.entity.Horse;

import static task.epam.race.constant.SqlConstant.*;

import java.sql.Connection;
import java.sql.SQLException;


public class AllHorsesSpecification extends Specification<Horse> {

    public AllHorsesSpecification(Connection connection)throws SQLException {
        super(connection,SQL_HORSES_SELECT_ALL);
    }
}
