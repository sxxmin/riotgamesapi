package org.cnu.realcoding.riotgamesapi.api;

import org.cnu.realcoding.riotgamesapi.domain.LeaguePositionDTO;
import org.cnu.realcoding.riotgamesapi.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RiotGamesApiClient {

    @Autowired
    private RestTemplate restTemplate;
    private static String APIKEY = "RGAPI-acc0822f-5c0f-4870-9184-f2f3a484f832";
    private String requestSummonerDTO = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key="+APIKEY;
    private String requestLeaguePositionDTO = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/{encryptedSummonerId}?api_key="+APIKEY;

    public SummonerDTO getCurrentSummonerDTO(String summonerName) {
        return restTemplate.exchange(requestSummonerDTO, HttpMethod.GET, null, SummonerDTO.class, summonerName).getBody();
    }

    public LeaguePositionDTO getCurrentLeaguePositionDTO(String encryptedSummonerId) {
        return restTemplate.exchange(requestLeaguePositionDTO, HttpMethod.GET, null, LeaguePositionDTO.class, encryptedSummonerId).getBody();
    }

}
