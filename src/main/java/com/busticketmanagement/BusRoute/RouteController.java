package com.busticketmanagement.BusRoute;

import com.busticketmanagement.BusRoute.BusRoute;
import com.busticketmanagement.BusRoute.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<BusRoute> getRoutes() {
        return routeService.getAllRoutes();
    }
}
