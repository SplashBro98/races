package com.epam.race.database.specification.user;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.specification.SQLFunction;
import com.epam.race.database.specification.SQLSpecification;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAmountSpecification implements SQLSpecification {

    private BigDecimal sum;
    private String login;

    public UpdateAmountSpecification() {

    }

    public UpdateAmountSpecification(BigDecimal sum, String login) {
        this.sum = sum;
        this.login = login;
    }

    @Override
    public PreparedStatement getStatement(SQLFunction<String, PreparedStatement, SQLException> function)
            throws RepositoryException {
        try{
            PreparedStatement statement = function.apply(SqlUserConstant.SQL_USERS_UPDATE_AMOUNT);
            fillStatement(statement);
            return statement;
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }

    @Override
    public void fillStatement(PreparedStatement statement) throws RepositoryException {
        try{
            statement.setBigDecimal(1,sum);
            statement.setString(2,login);
        }catch (SQLException e){
            throw new RepositoryException(e);
        }
    }
}
