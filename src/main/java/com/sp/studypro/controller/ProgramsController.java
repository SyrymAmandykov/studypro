package com.sp.studypro.controller;

import com.sp.studypro.controller.programs.AddProgramsRequest;
import com.sp.studypro.controller.programs.GetAllProgramsResponse;
import com.sp.studypro.enum_package.ProgramType;
import com.sp.studypro.mapper.dto.ProgramsDto;
import com.sp.studypro.service.ProgramsService;
import com.sp.studypro.service.SubjectsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramsController {

    private final ProgramsService programsService;

    public ProgramsController(ProgramsService programsService) {
        this.programsService = programsService;
    }

    @PostMapping("/add")
    @ResponseBody
    public ProgramsDto addNewProgram(
            @RequestBody AddProgramsRequest addProgramsRequest
    ) {
        return programsService.addNewPrograms(
                addProgramsRequest.getTitle(),
                addProgramsRequest.getDescription(),
                addProgramsRequest.getPrice(),
                addProgramsRequest.getProgramType(),
                addProgramsRequest.getSubjectsModel()
        );
    }

    @GetMapping("/by-programType")
    @ResponseBody
    public List<ProgramsDto> getProgramsByProgramType(
            @RequestBody ProgramType programsType
    ) {
        return programsService.getAllProgramsByProgramType(programsType);
    }

    @GetMapping("/all")
    @ResponseBody
    public GetAllProgramsResponse getAllPrograms() {
        List<ProgramsDto> programsList = programsService.getAllPrograms();
        return new GetAllProgramsResponse(programsList);
    }

    @GetMapping("/{programId}")
    @ResponseBody
    public ProgramsDto getProgramById(
            @PathVariable Long programId
    ) {
        return programsService.getProgramsById(programId);
    }

    @GetMapping("/by-subjectsName")
    @ResponseBody
    public List<ProgramsDto> getProgramsBySubjectName(
            @RequestBody String name
    ) {
        return programsService.getAllProgramsBySubjectsName(name);
    }


    @PutMapping("/update")
    @ResponseBody
    public ProgramsDto updatePrograms(
            @RequestBody ProgramsDto programs
    ) {
        programsService.updateProgram(
                programs.getId(),
                programs.getTitle(),
                programs.getDescription(),
                programs.getPrice(),
                programs.getProgramType(),
                programs.getSubjectsModel()
        );

        return programsService.getProgramsById(programs.getId());
    }

    @DeleteMapping("/delete/{programId}")
    @ResponseBody
    public void deleteProgram(
            @PathVariable Long programId
    ) {
        programsService.getProgramsById(programId);
    }

}
