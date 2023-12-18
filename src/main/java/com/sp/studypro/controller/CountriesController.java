package com.sp.studypro.controller;

import com.sp.studypro.controller.countries.AddCountriesRequest;
import com.sp.studypro.controller.countries.GetAllCountriesResponse;
import com.sp.studypro.mapper.dto.CountriesDto;
import com.sp.studypro.service.CountriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountriesController {
    private final CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }


    @PostMapping("/add")
    @ResponseBody
    public CountriesDto addNewCountry(
            @RequestBody AddCountriesRequest addCountriesRequest
    ) {
        return countriesService.addNewCountries(
                addCountriesRequest.getCountries()
        );
    }

    @GetMapping("/{countryId}")
    @ResponseBody
    public CountriesDto getCountryById(
            @PathVariable Long countryId
    ) {
        return countriesService.getCountriesById(countryId);
    }

    @GetMapping("/all")
    @ResponseBody
    public GetAllCountriesResponse getAllCountries() {
        List<CountriesDto> countries = countriesService.getAllCountries();
        return new GetAllCountriesResponse(countries);
    }

    @PutMapping("/update")
    @ResponseBody
    public CountriesDto updateCountries(
            @RequestBody CountriesDto updateCountriesDto
    ) {
        countriesService.updateCountries(
                updateCountriesDto.getId(),
                updateCountriesDto.getCountries()

        );

        return countriesService.getCountriesById(updateCountriesDto.getId());
    }

    @DeleteMapping("/delete/{countryId}")
    @ResponseBody
    public void deleteUser(
            @PathVariable Long countryId
    ) {
        countriesService.deleteCountriesById(countryId);
    }
}
