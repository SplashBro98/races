package com.epam.race.database.specification.race;

public final class SqlRaceConstant {
    //language=sql
    static final String SQL_RACES_SELECT_ALL = "SELECT * from races";

    //language=sql
    static final String SQL_RACES_SELECT_ALL_UPCOMING = "SELECT * from races where is_held = false";

    //language=sql
    public static final String SQL_RACES_SELECT_BY_NAME = "SELECT * from races where name  = ?";

    //language=sql
    static final String SQL_RACES_SELECT_ID_BY_NAME = "SELECT races.race_id from races where name  = ?";

    //language=sql
    static final String SQL_RACES_INSERT = "INSERT INTO races(name, place, date, time, is_held) VALUES " +
            "(?,?,?,?,false )";
    //language=sql
    static final String SQL_RACES_DELETE_BY_NAME = "DELETE from races where name = ?";

    //language=sql
    static final String SQL_RACES_HELD_RACE = "update races set is_held = true where race_id = ?";


}
