package com.epam.race.service;

import com.epam.race.database.specification.SQLSpecification;
import com.epam.race.database.specification.race.*;
import com.epam.race.entity.common.Race;
import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.RaceRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RaceService {

    private static List<Race> allRaces = new ArrayList<>();
    private int currentPage;
    private int recordsPerPage;
    private int numberOfPages;

    public RaceService() {
    }

    public RaceService(int currentPage, int recordsPerPage) {
        this.currentPage = currentPage;
        this.recordsPerPage = recordsPerPage;
    }

    public List mainAttributes() throws ServiceException {

        findAllUpcomingRaces();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(this.currentPage);
        result.add(this.numberOfPages);
        return result;
    }


    public List<Race> findAllUpcomingRaces() throws ServiceException {

        try {
            List<Race> races = RaceRepository.getInstance().query(new SelectUpcomingRacesSpecification());
            allRaces = races;
            if (recordsPerPage != 0) {
                numberOfPages = allRaces.size() / recordsPerPage;
                if (allRaces.size() % recordsPerPage != 0) {
                    numberOfPages += 1;
                }
            }
            return races;
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }
    public List<Race> findAllRaces() throws ServiceException {

        try {
           return RaceRepository.getInstance().query(new SelectAllRacesSpecification());

        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }


    public void updateRaceState(int raceId) throws ServiceException {
        try {
            SQLSpecification sqlSpecification = new UpdateRaceHeldSpecification(raceId);
            RaceRepository.getInstance().update(sqlSpecification);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public List<Race> findCurrentRaces() {
        int start = (currentPage - 1) * recordsPerPage;
        int end = start + recordsPerPage < allRaces.size() ? start + recordsPerPage : allRaces.size();
        numberOfPages = allRaces.size() / recordsPerPage + 1;
        return allRaces.subList(start, end);
    }

    public Optional<Race> findRace(String raceName) throws ServiceException {
        try {
            List<Race> races = RaceRepository.getInstance().query(new SelectRaceByNameSpecification(raceName));
            if (races.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(races.get(0));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public void addRace(Race race) throws ServiceException {
        try {
            RaceRepository.getInstance().add(race);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public int findRaceId(String raceName) throws ServiceException {
        try {
            return RaceRepository.getInstance().findRaceId(new SelectRaceIdSpecification(raceName));
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public Race findRaceWithBetsAndHorses(String raceName) throws ServiceException {
        try {
            return RaceRepository.getInstance().findRaceWithBetsAndHorses(raceName);
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public static List<Race> getAllRaces() {
        return Collections.unmodifiableList(allRaces);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

}
