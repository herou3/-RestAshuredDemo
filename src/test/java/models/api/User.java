package models.api;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends Base {
    private String email;
    private String password;
    private Integer id;
    private String token;
}
