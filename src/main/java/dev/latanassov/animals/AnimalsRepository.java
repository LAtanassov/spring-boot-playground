package dev.latanassov.animals;

import org.springframework.data.repository.PagingAndSortingRepository;

interface AnimalsRepository extends PagingAndSortingRepository<Animal, Long> {
}
