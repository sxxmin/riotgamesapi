package org.cnu.realcoding.riotgamesapi.repository;

import org.cnu.realcoding.riotgamesapi.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import javax.management.Query;

@Repository
public class CurrentSummonerScoreRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    //Do insert SummonerScore to MongoDB
    void insertCurrentSummonerScore(LeaguePositionDTO leaguePositionDTO) {
        mongoTemplate.insert(leaguePositionDTO);
    }

    //Update Method in MongoDB

    void updateCurrentSummonerScore(LeaguePositionDTO leaguePositionDTO){
        Query query = new Query();
        Criteria criteria = new Criteria();

    }
}
