package live.goapi.domain.email.repository;

import live.goapi.domain.email.entity.EmailAuth;
import org.springframework.data.repository.CrudRepository;

public interface EmailAuthRepository extends CrudRepository<EmailAuth, String> {
}
