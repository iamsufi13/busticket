package com.busticketmanagement.BusRoute;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    private List<BusRoute> busRoutes;

    public RouteService() {
        busRoutes = new ArrayList<>();

        busRoutes.add(new BusRoute("Mumbai to Pune", "VRL Travels", 500.0, 50, "2025-02-10"));
        busRoutes.add(new BusRoute("Bangalore to Hyderabad", "SRS Travels", 700.0, 30, "2025-02-12"));
        busRoutes.add(new BusRoute("Delhi to Jaipur", "KSRTC", 450.0, 60, "2025-02-15"));
        busRoutes.add(new BusRoute("Chennai to Coimbatore", "Parveen Travels", 600.0, 40, "2025-02-20"));
        busRoutes.add(new BusRoute("Kochi to Trivandrum", "KPN Travels", 550.0, 45, "2025-02-25"));
    }

    public List<BusRoute> getAllRoutes() {
        return busRoutes;
    }

    public BusRoute getRoute(String routeName) {
        for (BusRoute route : busRoutes) {
            if (route.getRouteName().equalsIgnoreCase(routeName)) {
                return route;
            }
        }
        return null;
    }
}

