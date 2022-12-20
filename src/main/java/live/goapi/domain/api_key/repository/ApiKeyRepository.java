package live.goapi.domain.api_key.repository;

import live.goapi.domain.api_key.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository extends JpaRepository<ApiKey, Long> {

    boolean existsByRandomKey(String randomKey);
}
