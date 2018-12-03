package task.epam.race.specification.horse;

import task.epam.race.entity.Horse;
import task.epam.race.specification.SQLFunction;
import task.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertHorseSpecification {

//    private Horse horse;
//
//    public InsertHorseSpecification(Horse horse) {
//        this.horse = horse;
//    }
//
//    @Override
//    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement> function) throws SQLException {
//        PreparedStatement statement = function.apply(SqlHorseConstant.SQL_HORSES_INSERT);
//        fillStatement(statement);
//        return statement;
//    }
//
//    @Override
//    public void fillStatement(PreparedStatement statement) throws SQLException {
//        statement.setString(1,horse.getName());
//        statement.setInt(2,horse.getAge());
//        statement.setInt(3,horse.getWins());
//    }
}
