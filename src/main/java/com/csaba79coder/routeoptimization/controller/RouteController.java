package com.csaba79coder.routeoptimization.controller;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.util.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RouteController {

    private final GraphHopper graphHopper;

    @GetMapping("/route")
    public String getRoute(@RequestParam double startLat, @RequestParam double startLon,
                           @RequestParam double endLat, @RequestParam double endLon) {
        GHRequest request = new GHRequest(startLat, startLon, endLat, endLon)
                .setProfile("car")
                .setAlgorithm(Parameters.Algorithms.DIJKSTRA_BI); // E.g Dijkstra algorithm

        GHResponse response = graphHopper.route(request);
        if (response.hasErrors()) {
            return "Error: " + response.getErrors();
        }

        return response.getBest().getPoints().toString();
    }
}
