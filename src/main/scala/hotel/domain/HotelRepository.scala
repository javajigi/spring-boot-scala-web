package hotel.domain

import java.lang.Long

import org.springframework.data.repository.CrudRepository

import hotel.domain.Hotel._

trait HotelRepository extends CrudRepository[Hotel, Long]