package task.epam.race.service;

import task.epam.race.entity.Race;
import task.epam.race.exception.RepositoryException;
import task.epam.race.repository.RaceRepository;
import task.epam.race.specification.race.SelectAllRacesSpecification;
import task.epam.race.specification.race.SelectRaceByNameSpecification;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public class RaceService {

    public List<Race> findAllRaces() throws RepositoryException {

        return RaceRepository.getInstance().query(new SelectAllRacesSpecification());
    }

    public Optional<Race> findRace(String raceName) throws RepositoryException {
        List<Race> races = RaceRepository.getInstance().query(new SelectRaceByNameSpecification(raceName));
        if(races.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(races.get(0));
    }
}
