package com.vexere.webservice.repos;

import com.vexere.webservice.models.trips.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
