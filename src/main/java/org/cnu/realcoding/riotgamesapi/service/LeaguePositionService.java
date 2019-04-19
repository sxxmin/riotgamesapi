package org.cnu.realcoding.riotgamesapi.service;

import org.cnu.realcoding.riotgamesapi.domain.LeaguePositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class LeaguePositionService {
    @Autowired
    private RiotGamesApiClient riotGamesApiClient;
    @Autowired
    private SummonerService summonerService;
    @Autowired
    private CurrentSummonerServiceScoreRepo currentSummonerServiceScoreRepo;

    private LinkedList<String> encryptedSummonerIdQueue = new LinkedList<>();

    public LeaguePositionDTO getLeaguePosition(String summonerName){
        if(){ //todo Is there summonerName in database?
            //todo Then return database information.
        } else {
            String encryptedSummonerId = summonerService.getEncryptedSummonerId(summonerName);
            LeaguePositionDTO currentLeaguePositionDTO = riotGamesApiClient.getLeaguePositionDTO(encryptedSummonerId);
            currentSummonerServiceScoreRepo.insertCurrentSummonerScore(LeaguePositionDTO);
            return currentLeaguePositionDTO;
        }
    }

    public void setEncryptedSummonerIdQueue(){
        this.encryptedSummonerIdQueue = currentSummonerServiceScoreRepo.findAllEncryptedSummonerId();
    }

    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void updateLeaguePositionPeriodically(){
        if(encryptedSummonerIdQueue.isEmpty()){
            this.setEncryptedSummonerIdQueue();
        }

        String target = encryptedSummonerIdQueue.pop();
        encryptedSummonerIdQueue.add(target);

        LeaguePositionDTO updatedLeaguePositionDTO = riotGamesApiClient.getLeaguePositionDTO(target);
        currentSummonerServiceScoreRepo.updateCurrentSummonerScore(updatedLeaguePositionDTO);
    }
}

//summonerService.getEncryptedSummonerId(summonerName)