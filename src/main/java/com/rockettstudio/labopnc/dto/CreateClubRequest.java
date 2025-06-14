package com.rockettstudio.labopnc.dto;


import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class CreateClubRequest {
    private String name;

    private String country;

    private String coach;

    private Integer titles;
}
