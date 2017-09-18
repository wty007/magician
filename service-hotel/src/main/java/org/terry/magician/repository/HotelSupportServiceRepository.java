package org.terry.magician.repository;

import org.terry.magician.domain.HotelSupportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Terry
 */
@Repository
public interface HotelSupportServiceRepository extends JpaRepository<HotelSupportService, String> {
    @Query("from HotelSupportService a where a.hotel.id = :hotelId")
    List<HotelSupportService> findByHotelId(@Param("hotelId") String hotelId);
}
