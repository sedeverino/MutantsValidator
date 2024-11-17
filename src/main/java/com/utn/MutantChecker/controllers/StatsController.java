package com.utn.MutantChecker.controllers;

import com.utn.MutantChecker.dtos.StatsResponse;
import com.utn.MutantChecker.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private static StatsService statsService;

    @GetMapping
    public StatsResponse getStats(){
        return statsService.getStats();
    }

}
