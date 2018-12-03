package task.epam.race.specification.horse;

public final class SqlHorseConstant {
    //language=sql
    public static final String SQL_HORSES_SELECT_ALL = "SELECT * from horses";
    //language=sql
    public static final String SQL_HORSES_SELECT_NAME = "SELECT name from horses";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_NAME = "SELECT * from horses where name=?";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_YEAR = "SELECT name, years, wins from horses where years=?";
    //language=sql
    public static final String SQL_HORSES_INSERT = "INSERT INTO horses(name,age, wins) values(?,?,?) ";
    //language=sql
    public static final String SQL_HORSES_DELETE_ALL = "DELETE from horses";
    //language=sql
    public static final String SQL_HORSES_DELETE_BY_NAME = "DELETE from horses where name=?";
    //language=sql
    public static final String SQL_HORSES_SELECT_BY_RACE_ID = "SELECT * from horses JOIN horse_list" +
            " on (horses.horse_id = horse_list.horse_id) where race_id = ?";
}
