package com.epam.race.database.specification.horse;

public final class SqlHorseConstant {
    //language=sql
    public static final String SQL_HORSES_SELECT_ALL = "SELECT * from horses";
    //language=sql
    public static final String SQL_HORSES_SELECT_NAME = "SELECT name from horses";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_NAME = "SELECT * from horses where name=?";
    //language=sql
    public static final String SQL_HORSES_SELECT_ID_BY_NAME = "SELECT horse_id from horses where name=?";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_YEAR = "SELECT name, years, wins from horses where years=?";
    //language=sql
    public static final String SQL_HORSES_INSERT = "INSERT INTO horses(name,age, wins) values(?,?,?) ";
    //language=sql
    public static final String SQL_HORSES_DELETE_ALL = "DELETE from horses";
    //language=sql
    public static final String SQL_HORSES_DELETE_BY_NAME = "DELETE from horses where name=?";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_RACE_ID = "SELECT * from horses h JOIN horse_list hl" +
            " on (h.horse_id = hl.horse_id) where hl.race_id = ?";

    //language=sql
    public static final String SQL_HORSE_LIST_INSERT = "INSERT INTO horse_list(race_id, horse_id) VALUES " +
            "(?,?)";
}
