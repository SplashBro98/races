package task.epam.race.specification.horse;

import task.epam.race.entity.Race;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SelectHorseByRaceSpecification {

//    private Race race;
//
//    public SelectHorseByRaceSpecification(Race race) {
//        this.race = race;
//    }
//
//    @Override
//    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
//        PreparedStatement statement = function.apply(SqlHorseConstant.SQL_HORSES_SELECT_BY_RACE_ID);
//        fillStatement(statement);
//        return statement;
//    }
//
//    @Override
//    public void fillStatement(PreparedStatement statement) throws SQLException {
//        statement.setInt(1,race.getRaceId());
//    }
}
