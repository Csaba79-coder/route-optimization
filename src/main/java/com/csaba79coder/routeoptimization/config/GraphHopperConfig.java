package com.csaba79coder.routeoptimization.config;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class GraphHopperConfig {

    // https://www.graphhopper.com/developers/
    // https://download.geofabrik.de/europe.html (Europe)

    @Bean
    public GraphHopper graphHopper() {
        GraphHopper hopper = new GraphHopper();

        Path graphHopperDirPath = Paths.get("src/main/resources/graphhopper-files");

        try {
            if (Files.notExists(graphHopperDirPath)) {
                Files.createDirectories(graphHopperDirPath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create GraphHopper directory", e);
        }

        hopper.setGraphHopperLocation(graphHopperDirPath.toString());

        hopper.setOSMFile("src/main/resources/data/hungary-latest.osm.pbf");

        hopper.setProfiles(new Profile("car").setVehicle("car").setWeighting("fastest"));

        hopper.importOrLoad();

        return hopper;
    }
}
