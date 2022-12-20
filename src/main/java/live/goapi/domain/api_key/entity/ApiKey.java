package live.goapi.domain.api_key.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "api_key_Id")
    private Long apiKeyId;

    @Column(name = "random_key")
    private String random_key;
}
