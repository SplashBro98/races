package com.epam.race.service;

import com.epam.race.entity.Race;
import com.epam.race.exception.RepositoryException;
import com.epam.race.exception.ServiceException;
import com.epam.race.repository.RaceRepository;
import com.epam.race.specification.race.SelectAllRacesSpecification;
import com.epam.race.specification.race.SelectRaceByNameSpecification;
import com.epam.race.specification.race.SelectRaceIdSpecification;

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


    public List<Object> mainAttributes() throws ServiceException {

        this.findAllRaces();
        ArrayList<Object> result = new ArrayList<>();
        result.add(this.currentPage);
        result.add(this.numberOfPages);
        return result;
    }

    public List<Race> findAllRaces() throws ServiceException {

        try {
            List<Race> races = RaceRepository.getInstance().query(new SelectAllRacesSpecification());
            allRaces = races;
            numberOfPages = allRaces.size() / recordsPerPage + 1;
            return races;
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    public List<Race> findCurrentRaces() {
        int start = (currentPage - 1) * recordsPerPage;
        int end = start + recordsPerPage < allRaces.size() ? start + recordsPerPage : allRaces.size();
        numberOfPages = allRaces.size() / recordsPerPage + 1;
        List<Race> currentRaces = allRaces.subList(start, end);
        return currentRaces;
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

    public static List<Race> getAllRaces() {
        return Collections.unmodifiableList(allRaces);
    }

    public void setAllRaces(List<Race> allRaces) {
        this.allRaces = allRaces;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
