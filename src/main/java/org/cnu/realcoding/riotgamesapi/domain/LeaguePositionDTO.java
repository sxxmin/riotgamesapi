package org.cnu.realcoding.riotgamesapi.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LeaguePositionDTO {
    private List<LeaguePosition> array = new ArrayList<>();

    @Data
    private class LeaguePosition{
        private String tier;
        private String summonerName;
        private boolean hotStreak;
        private int wins;
        private boolean veteran;
        private int losses;
        private String rank;
        private String leagueName;
        private boolean inacive;
        private boolean freshBlood;
        private String position;
        private String leaqgueId;
        private String queueType;
        private String summonerId;
        private int leaguePoints;
    }
}
