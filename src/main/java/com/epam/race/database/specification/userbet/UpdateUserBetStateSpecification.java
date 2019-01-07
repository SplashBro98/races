package com.epam.race.database.specification.userbet;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.entity.user.UserBet;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserBetStateSpecification implements SQLSpecification {

    private UserBet userBet;


    public UpdateUserBetStateSpecification(UserBet userBet) {
        this.userBet = userBet;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserBetConstant.SQL_USER_BETS_UPDATE_STATE);
            fillStatement(statement);
            return statement;

        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setBoolean(1,userBet.isSuccessful());
            statement.setString(2,userBet.getUserLogin());
            statement.setInt(3,userBet.getBetId());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }

    }
}
