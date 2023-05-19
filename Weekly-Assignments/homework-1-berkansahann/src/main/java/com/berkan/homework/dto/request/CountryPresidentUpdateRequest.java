package com.berkan.homework.dto.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CountryPresidentUpdateRequest {

    private String president;
}
