package com.epam.race.service;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.RaceResultRepository;
import com.epam.race.database.specification.raceresult.SelectAllResultsSpecification;
import com.epam.race.entity.common.RaceResult;

import java.util.List;

public class RaceResultService {

    public void addResult(RaceResult raceResult) throws ServiceException {
        try{
            RaceResultRepository.getInstance().add(raceResult);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }

    public List<RaceResult> findAllResults() throws ServiceException {
        try{
            return RaceResultRepository.getInstance().query(new SelectAllResultsSpecification());
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
}
