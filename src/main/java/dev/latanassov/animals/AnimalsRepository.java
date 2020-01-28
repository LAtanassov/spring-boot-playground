package dev.latanassov.animals;

import org.springframework.data.repository.PagingAndSortingRepository;

@SuppressWarnings("unused")
interface AnimalsRepository extends PagingAndSortingRepository<Animal, Long> {
}
