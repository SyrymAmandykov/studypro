package com.sp.studypro.controller;

import com.sp.studypro.controller.languageCourses.AddLanguageCenterRequest;
import com.sp.studypro.controller.languageCourses.GetAllLanguageCentersResponse;
import com.sp.studypro.controller.languageCourses.UpdateLanguageCoursesRequest;
import com.sp.studypro.enum_package.Intake;
import com.sp.studypro.mapper.dto.LanguageCoursesDto;
import com.sp.studypro.service.LanguageCoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languageCourses")
public class LanguageCoursesController {

    private final LanguageCoursesService languageCoursesService;

    public LanguageCoursesController(LanguageCoursesService languageCoursesService) {
        this.languageCoursesService = languageCoursesService;
    }

    @PostMapping("/add")
    @ResponseBody
    public LanguageCoursesDto addNewCourses(
            @RequestBody AddLanguageCenterRequest center
            ){

        return languageCoursesService.addNewCourse(
                center.getName(),
                center.getDescription(),
                center.getPrice(),
                center.getCountriesId(),
                center.getIntake(),
                center.getTotalClients()
        );

    }

    @GetMapping(value = "/by-id/{languageCenterId}")
    @ResponseBody
    public LanguageCoursesDto getCenterById(
            @PathVariable Long languageCenterId
    ){
        return languageCoursesService.getCoursesById(languageCenterId);
    }

    @GetMapping("/by-countryId/{countryId}")
    @ResponseBody
    public List<LanguageCoursesDto> getCentersListByCountriesId(
            @PathVariable Long countryId
    ){
        return languageCoursesService.getCoursesByCountryId(countryId);
    }

    @GetMapping("/by-intakeName/{intakeName}")
    @ResponseBody
    public List<LanguageCoursesDto> getAllCenterByIntake(
            @PathVariable Intake intakeName
            ){
        return languageCoursesService.getAllCoursesByIntake(intakeName);
    }


    @GetMapping("/by-price/{price}")
    @ResponseBody
    public List<LanguageCoursesDto> getAllCentersByPrice(
            @PathVariable Double price
    ){
        return languageCoursesService.getCoursesByPrice(price);
    }

    @GetMapping("/allCenters")
    @ResponseBody
    public GetAllLanguageCentersResponse getAllCenters(){
        List<LanguageCoursesDto> centersList = languageCoursesService.getAllCourses();
        return new GetAllLanguageCentersResponse(centersList);
    }

    @PutMapping("/update")
    @ResponseBody
    public LanguageCoursesDto updateLanguageCourses(
            @RequestBody UpdateLanguageCoursesRequest centerUpdate
            ){
        return languageCoursesService.updateCourses(
                centerUpdate.getId(),
                centerUpdate.getName(),
                centerUpdate.getDescription(),
                centerUpdate.getPrice(),
                centerUpdate.getCountries()
                        .getId(),
                centerUpdate.getIntake(),
                centerUpdate.getTotalClients()
        );
    }

    @DeleteMapping("/delete/{deleteById}")
    @ResponseBody
    public void deleteCenterById(
            @PathVariable Long deleteById
    ){
        languageCoursesService.deleteCoursesById(deleteById);
    }

}
