package live.goapi.domain.api_key.repository;

import live.goapi.domain.api_key.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Long> {

    boolean existsByRandomKey(String randomKey);
    Optional<ApiKey> findByRandomKey(String randomKey);
}
