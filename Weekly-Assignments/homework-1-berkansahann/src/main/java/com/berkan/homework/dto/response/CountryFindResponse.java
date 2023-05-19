package com.berkan.homework.dto.response;

import lombok.*;

@Getter
@Builder
public class CountryFindResponse {
    private long id;
    private String name;
    private String president;
}
