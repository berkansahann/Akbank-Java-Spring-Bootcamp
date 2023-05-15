package com.berkan.homework.dto.request;

import lombok.*;

@Getter
@Builder
public class CountryCreateRequest {

    private String name;
    private String president;
}
