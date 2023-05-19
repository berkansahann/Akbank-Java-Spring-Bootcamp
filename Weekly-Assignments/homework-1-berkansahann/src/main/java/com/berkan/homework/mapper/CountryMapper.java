package com.berkan.homework.mapper;

import com.berkan.homework.dto.request.CountryCreateRequest;
import com.berkan.homework.dto.response.CountryCreateResponse;
import com.berkan.homework.dto.response.CountryFindResponse;
import com.berkan.homework.dto.response.CountryPresidentUpdateResponse;
import com.berkan.homework.entity.Country;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CountryMapper {

    CountryFindResponse countryToCountryFindResponse(Country country);

    CountryPresidentUpdateResponse countryToCountryPresidentUpdateResponse(Country country);

    CountryCreateResponse countryToCountryCreateResponse(Country country);

    Country countryCreateRequestToCountry(CountryCreateRequest request);
}
