package StoneBridgeStudios.MythMachine.MythMachine.repository;

import StoneBridgeStudios.MythMachine.MythMachine.model.MMUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MMUserRepository extends JpaRepository<MMUser, Long> {

    @Query(value = "SELECT * FROM mm_user u WHERE u.user_email = :email", nativeQuery = true)
    MMUser findByEmail(String email);

}