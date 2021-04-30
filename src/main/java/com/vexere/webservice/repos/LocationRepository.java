package com.vexere.webservice.repos;

import com.vexere.webservice.models.trips.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
