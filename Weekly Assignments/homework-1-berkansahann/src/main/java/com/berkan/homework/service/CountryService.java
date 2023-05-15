package com.berkan.homework.service;

import com.berkan.homework.dto.request.CountryCreateRequest;
import com.berkan.homework.dto.request.CountryPresidentUpdateRequest;
import com.berkan.homework.dto.response.CountryCreateResponse;
import com.berkan.homework.dto.response.CountryFindResponse;
import com.berkan.homework.dto.response.CountryPresidentUpdateResponse;
import com.berkan.homework.entity.Country;
import com.berkan.homework.mapper.CountryMapper;
import com.berkan.homework.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryCreateResponse createCountry(CountryCreateRequest request) {
        Country country = countryMapper.countryCreateRequestToCountry(request);
        countryRepository.save(country);
        return countryMapper.countryToCountryCreateResponse(country);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public CountryPresidentUpdateResponse updateCountryPresident(long id, CountryPresidentUpdateRequest request) {
        Country country = countryRepository.findById(id)
                .orElseThrow();
        country.setPresident(request.getPresident());
        countryRepository.save(country);
        return countryMapper.countryToCountryPresidentUpdateResponse(country);
    }

    public CountryFindResponse getCountryById(long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow();
        return countryMapper.countryToCountryFindResponse(country);
    }

}
