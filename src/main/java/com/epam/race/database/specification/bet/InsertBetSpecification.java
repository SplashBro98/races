package com.epam.race.database.specification.bet;

import com.epam.race.entity.common.Bet;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertBetSpecification implements SQLSpecification {

    private Bet bet;

    public InsertBetSpecification(Bet bet) {
        this.bet = bet;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try {
            PreparedStatement statement = function.apply(SqlBetConstant.SQL_BETS_INSERT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try {
            statement.setInt(1, bet.getRace().getRaceId());
            statement.setInt(2, bet.getHorse().getHorseId());
            statement.setInt(3, bet.getPosition());
            statement.setDouble(4, bet.getCoeff());
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
