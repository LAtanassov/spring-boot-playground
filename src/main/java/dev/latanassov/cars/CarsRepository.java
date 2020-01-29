package dev.latanassov.cars;

import dev.latanassov.animals.Animal;
import org.springframework.data.repository.PagingAndSortingRepository;

interface CarsRepository extends PagingAndSortingRepository<Animal, Long> {
}
