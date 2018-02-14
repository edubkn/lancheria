package br.com.lancheria.model.repository;

import br.com.lancheria.model.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "User.detail", type = EntityGraph.EntityGraphType.LOAD)
    User findByFacebookId(String facebookId);
}
