package dev.latanassov.customers;

import org.springframework.data.repository.PagingAndSortingRepository;

@SuppressWarnings("unused")
public interface CustomersRepository extends PagingAndSortingRepository<Customer, Long> {
}
