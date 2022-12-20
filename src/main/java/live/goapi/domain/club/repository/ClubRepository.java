package live.goapi.domain.club.repository;

import live.goapi.domain.club.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club , Long> {
    Optional<Club> findByClubName(String clubName);
}
