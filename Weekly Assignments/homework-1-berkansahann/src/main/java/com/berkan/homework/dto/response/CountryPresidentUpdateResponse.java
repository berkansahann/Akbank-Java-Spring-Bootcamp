package com.berkan.homework.dto.response;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CountryPresidentUpdateResponse {

    private String name;
    private String president;
}
