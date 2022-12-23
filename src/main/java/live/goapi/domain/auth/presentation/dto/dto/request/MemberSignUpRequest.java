package live.goapi.domain.auth.presentation.dto.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberSignUpRequest {

    @NotBlank(message = "이메일은 공백이나 null 값을 허용하지 않습니다.")
    private String email;

    @NotBlank(message = "비밀번호는 공백이나 null 값을 허용하지 않습니다.")
    @Pattern(regexp="(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 특수문자 1개 이상 글자 수는 8 ~ 16자 사이여야 합니다.")
    private String password;

    @NotBlank(message = "이름은 공백이나 null 값을 허용하지 않습니다.")
    private String name;

    @NotBlank(message = "학번은 공백이나 null 값을 허용하지 않습니다.")
    private String studentNumber;

    @NotBlank(message = "전공은 공백이나 null 값을 허용하지 않습니다.")
    private String major;

    @NotBlank(message = "역할은 공백이거나 null 값을 허용하지 않습니다.")
    private String role;
}
