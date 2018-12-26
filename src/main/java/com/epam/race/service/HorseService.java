package com.epam.race.service;

import com.epam.race.entity.Horse;
import com.epam.race.repository.RepositoryException;
import com.epam.race.repository.impl.HorseRepository;
import com.epam.race.specification.horse.SelectAllHorsesSpecification;
import com.epam.race.specification.horse.SelectHorseByNameSpecification;
import com.epam.race.specification.horse.SelectHorsesByRaceSpecification;

import java.util.ArrayList;
import java.util.List;

public class HorseService {

    public List<String> findHorseNames() throws ServiceException {
        try{
            List<Horse> horses = HorseRepository.getInstance().query(new SelectAllHorsesSpecification());
            List<String> names = new ArrayList<>();
            horses.forEach(h -> names.add(h.getName()));
            return names;
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public void addHorse(Horse horse) throws ServiceException {
        try{
            HorseRepository.getInstance().add(horse);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public void addHorseToHorseList(String horseName) throws ServiceException {
        try{
            Horse horse = HorseRepository.getInstance().query(new SelectHorseByNameSpecification(horseName)).get(0);


        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public List<Horse> findHorsesByRace(int raceId) throws ServiceException {
        try{
            return HorseRepository.getInstance().query(new SelectHorsesByRaceSpecification(raceId));
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
}
