package org.cnu.realcoding.riotgamesapi.repository;

import org.cnu.realcoding.riotgamesapi.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentSummonerScoreRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    //Do insert SummonerScore to MongoDB
    public void insertCurrentSummonerScore(LeaguePositionDTO leaguePositionDTO) {
        mongoTemplate.insert(leaguePositionDTO);
    }
}
