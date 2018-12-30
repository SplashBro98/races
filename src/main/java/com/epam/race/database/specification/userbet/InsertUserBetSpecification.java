package com.epam.race.database.specification.userbet;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.entity.UserBet;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserBetSpecification implements SQLSpecification {

    private UserBet userBet;

    public InsertUserBetSpecification(UserBet userBet) {
        this.userBet = userBet;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserBetConstant.SQL_USER_BETS_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setString(1,userBet.getUserLogin());
            statement.setInt(2,userBet.getBetId());
            statement.setBigDecimal(3,userBet.getSum());
            statement.setDouble(4,userBet.getCoeff());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
