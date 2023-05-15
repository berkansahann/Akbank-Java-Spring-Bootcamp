package com.berkan.homework.controller;

import com.berkan.homework.dto.request.CountryCreateRequest;
import com.berkan.homework.dto.request.CountryPresidentUpdateRequest;
import com.berkan.homework.dto.response.CountryCreateResponse;
import com.berkan.homework.dto.response.CountryFindResponse;
import com.berkan.homework.dto.response.CountryPresidentUpdateResponse;
import com.berkan.homework.entity.Country;
import com.berkan.homework.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @PostMapping("/create")
    public ResponseEntity<CountryCreateResponse> createCountry(
            @RequestBody CountryCreateRequest request
            ) {
        return ResponseEntity.ok(countryService.createCountry(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryFindResponse> getCountryById(
            @PathVariable long id)
    {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryPresidentUpdateResponse> updateCountryPresident(
        @PathVariable long id ,@RequestBody CountryPresidentUpdateRequest request
    ) {
        return ResponseEntity.ok(countryService.updateCountryPresident(id, request));
    }
}
