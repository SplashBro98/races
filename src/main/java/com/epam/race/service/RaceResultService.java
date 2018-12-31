package com.epam.race.service;

import com.epam.race.database.repository.RepositoryException;
import com.epam.race.database.repository.impl.RaceResultRepository;
import com.epam.race.entity.common.RaceResult;

public class RaceResultService {

    public void addResult(RaceResult raceResult) throws ServiceException {
        try{
            RaceResultRepository.getInstance().add(raceResult);
        }catch (RepositoryException e){
            throw new ServiceException(e);
        }
    }
}
