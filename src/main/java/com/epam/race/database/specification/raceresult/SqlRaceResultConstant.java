package com.epam.race.database.specification.raceresult;

public final class SqlRaceResultConstant {

    //language=sql
    static final String SQL_RACE_RESULTS_SELECT_ALL = "select r.name,r.place, rr.first_horse_name," +
            " rr.second_horse_name," +
            "       rr.third_horse_name, rr.fourth_horse_name from race_results rr " +
            "  join races r on (r.race_id = rr.race_id)";

    //language=sql
    static final String SQL_RACE_RESULTS_SELECT_BY_RACE = "select r.name,r.place, rr.first_horse_name," +
            " rr.second_horse_name, rr.third_horse_name, rr.fourth_horse_name from race_results rr " +
            " join races r on (r.race_id = rr.race_id) where rr.race_id = ?";

    //language=sql
    static final String SQL_RACE_RESULTS_INSERT = "insert into race_results " +
            "(race_id, first_horse_name, second_horse_name," +
            "                          third_horse_name, fourth_horse_name) VALUES " +
            "(?,?,?,?,?)";
}
