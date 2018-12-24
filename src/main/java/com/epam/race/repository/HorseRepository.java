package com.epam.race.repository;

public class HorseRepository  {
//    private static HorseRepository instance;
//
//    private HorseRepository(){
//
//    }
//
//    public static HorseRepository getInstance(){
//        if(instance == null){
//            instance = new HorseRepository();
//        }
//        return instance;
//    }
//
//
//    @Override
//    public void add(Horse horse) throws RepositoryException {
//        nonSelectQuery(new InsertHorseSpecification(horse));
//    }
//
//    @Override
//    public void remove(Horse horse) throws RepositoryException {
//        nonSelectQuery(new DeleteHorseSpecification(horse.getName()));
//    }
//
//    @Override
//    public void update(Horse horse) throws RepositoryException {
//
//    }
//
//    @Override
//    public List<Horse> query(SQLSpecification specification) throws SQLException {
//        return selectQuery(specification);
//    }
//
//    @Override
//    public Horse createItem(ResultSet resultSet) throws SQLException{
//        Horse newHorse = new Horse();
//        newHorse.setHorseId(resultSet.getInt("horse_id"));
//        newHorse.setName(resultSet.getString("name"));
//        newHorse.setAge(resultSet.getInt("age"));
//        newHorse.setWins(resultSet.getInt("wins"));
//        return newHorse;
//    }
}
