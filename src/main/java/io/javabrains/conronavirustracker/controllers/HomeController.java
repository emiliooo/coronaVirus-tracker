package io.javabrains.conronavirustracker.controllers;


import io.javabrains.conronavirustracker.models.LocationStats;
import io.javabrains.conronavirustracker.services.coronaVirusServiceData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    coronaVirusServiceData coronaVirusServiceData;

    @GetMapping("/")
    public String home(Model model) {
         List<LocationStats> allStats = coronaVirusServiceData.getAllStats();
         int totalReportedCases = allStats.stream().mapToInt( stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationStats",allStats);
        model.addAttribute("totalReportedCases",totalReportedCases);
        return "home";
    }
}
