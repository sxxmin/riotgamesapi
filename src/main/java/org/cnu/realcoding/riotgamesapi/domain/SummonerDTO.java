package org.cnu.realcoding.riotgamesapi.domain;

import lombok.Data;

@Data
public class SummonerDTO {
    private int profileIconId;
    private String name;
    private String puuid;
    private int summonerLevel;
    private String accountId;
    private String id;
    private Long revisionDate;
}
