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

    @GetMapping("/by-id/{centerId}")
    @ResponseBody
    public LanguageCoursesDto getCenterById(
            @PathVariable Long centerId
    ){
        return languageCoursesService.getCoursesById(centerId);
    }

    @GetMapping("/by-intakeName")
    @ResponseBody
    public List<LanguageCoursesDto> getAllCenterByIntake(
            @RequestBody Intake intake
            ){
        return languageCoursesService.getAllCoursesByIntake(intake);
    }

    @GetMapping("/by-centerId/{centerId}")
    @ResponseBody
    public GetAllLanguageCentersResponse getCentersListByCountriesId(
            @PathVariable Long centerId
    ){
        return (GetAllLanguageCentersResponse) languageCoursesService.getCoursesByCountryId(centerId);
    }

    @GetMapping("/by-price")
    @ResponseBody
    public GetAllLanguageCentersResponse getAllCentersByPrice(
            @RequestBody Double price
    ){
        return (GetAllLanguageCentersResponse) languageCoursesService.getCoursesByPrice(price);
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
