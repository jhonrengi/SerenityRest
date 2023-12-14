package io.petstore.swagger.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUserModel {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("username")
    public String username;

    @JsonProperty("firstName")
    public String firstName;

    @JsonProperty("lastName")
    public String lastName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("password")
    public String password;

    @JsonProperty("phone")
    public String phone;

    @JsonProperty("userStatus")
    public Integer userStatus;
}
