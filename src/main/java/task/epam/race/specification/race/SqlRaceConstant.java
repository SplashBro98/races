package task.epam.race.specification.race;

public final class SqlRaceConstant {
    //language=sql
    public static final String SQL_RACES_SELECT_ALL = "SELECT * from races";

    //language=sql
    public static final String SQL_RACES_SELECT_BY_NAME = "SELECT * from races where name  = ?";

    //language=sql
    public static final String SQL_RACES_SELECT_ID_BY_NAME = "SELECT races.race_id from races where name  = ?";

    //language=sql
    public static final String SQL_RACES_INSERT = "INSERT INTO races(name, place, date, time) VALUES " +
            "(?,?,?,?)";
    //language=sql
    public static final String SQL_RACES_DELETE_BY_NAME = "DELETE from races where name = ?";
}
