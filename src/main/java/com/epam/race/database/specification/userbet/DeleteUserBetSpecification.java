package com.epam.race.database.specification.userbet;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserBetSpecification implements SQLSpecification {

    private int betId;

    public DeleteUserBetSpecification(int betId) {
        this.betId = betId;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlUserBetConstant.SQL_USER_BETS_REMOVE_BY_BET_ID);
            fillStatement(statement);
            return statement;
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setInt(1,betId);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
