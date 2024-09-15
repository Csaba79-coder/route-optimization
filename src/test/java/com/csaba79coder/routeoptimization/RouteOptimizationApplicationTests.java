package com.csaba79coder.routeoptimization;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "${api.token}")
class RouteOptimizationApplicationTests {

    @Test
    void contextLoads() {
    }

}
