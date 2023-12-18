package com.sp.studypro.controller;

import com.sp.studypro.controller.subjects.AddSubjectsRequest;
import com.sp.studypro.controller.subjects.GetAllSubjectsResponse;
import com.sp.studypro.controller.subjects.UpdateSubjectsRequest;
import com.sp.studypro.mapper.dto.SubjectsDto;
import com.sp.studypro.service.SubjectsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectsController {

    private final SubjectsService subjectsService;

    public SubjectsController(SubjectsService subjectsService) {
        this.subjectsService = subjectsService;
    }

    @PostMapping("/add")
    @ResponseBody
    public SubjectsDto addNewCountry(
            @RequestBody AddSubjectsRequest addSubjectsRequest
    ) {
        return subjectsService.addNewSubjects(
                addSubjectsRequest.getName()
        );
    }

    @GetMapping("/{subjectId}")
    @ResponseBody
    public SubjectsDto getSubjectById(
            @PathVariable Long subjectId
    ) {
        return subjectsService.getSubjectsById(subjectId);
    }

    @GetMapping("/all")
    @ResponseBody
    public GetAllSubjectsResponse getAllSubjects() {
        List<SubjectsDto> subjectsList = subjectsService.getAllSubjects();
        return new GetAllSubjectsResponse(subjectsList);
    }

    @PutMapping("/update")
    @ResponseBody
    public SubjectsDto updateSubjects(
            @RequestBody UpdateSubjectsRequest updateSubjectsRequest
    ) {
        subjectsService.updateSubjects(
                updateSubjectsRequest.getId(),
                updateSubjectsRequest.getName()

        );

        return subjectsService.getSubjectsById(updateSubjectsRequest.getId());
    }

    @DeleteMapping("/delete/{subjectsId}")
    @ResponseBody
    public void deleteSubjects(
            @PathVariable Long subjectsId
    ) {
        subjectsService.deleteSubjectsById(subjectsId);
    }

}
