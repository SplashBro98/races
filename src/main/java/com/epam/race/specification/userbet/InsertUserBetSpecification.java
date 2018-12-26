package com.epam.race.specification.userbet;

import com.epam.race.repository.RepositoryException;
import com.epam.race.entity.UserBet;
import com.epam.race.specification.SQLFunction;
import com.epam.race.specification.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserBetSpecification implements SQLSpecification {

    private UserBet userBet;

    public InsertUserBetSpecification(UserBet userBet) {
        this.userBet = userBet;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function) throws RepositoryException {
        return null;
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {

    }
}
