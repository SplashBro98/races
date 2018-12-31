package com.epam.race.service;

import com.epam.race.entity.common.Horse;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.HorseRepository;
import com.epam.race.database.specification.horse.SelectAllHorsesSpecification;
import com.epam.race.database.specification.horse.SelectHorseByNameSpecification;
import com.epam.race.database.specification.horse.SelectHorseIdSpecification;
import com.epam.race.database.specification.horse.SelectHorsesByRaceSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void addHorseToHorseList(int raceId, int horseId) throws ServiceException {
        try{
            HorseRepository.getInstance().addHorseToHorseList(raceId, horseId);

        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public Optional<Horse> findHorse(String horseName) throws ServiceException {
        try {
            List<Horse> horses = HorseRepository.getInstance().query(new SelectHorseByNameSpecification(horseName));
            if (horses.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(horses.get(0));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public int findHorseId(String horseName) throws ServiceException {
        try{
            return HorseRepository.getInstance().findHorseId(new SelectHorseIdSpecification(horseName));
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
