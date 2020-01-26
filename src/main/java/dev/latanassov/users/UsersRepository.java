package dev.latanassov.users;

import org.springframework.data.repository.PagingAndSortingRepository;

@SuppressWarnings("unused")
public interface UsersRepository extends PagingAndSortingRepository<User, Long> {
}
