package com.vexere.webservice.repos;

import com.vexere.webservice.models.promos.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoRepository extends JpaRepository<Promo, Long> {
}
