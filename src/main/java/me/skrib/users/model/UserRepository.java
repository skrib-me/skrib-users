package me.skrib.users.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);

    User findOneByOktaId(String oktaId);

    User findOneByUsername(String username);
}
