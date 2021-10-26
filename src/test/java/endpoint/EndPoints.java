package endpoint;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EndPoints {

    USERS("/api/users"),
    USER_DETAIL("/api/users/{id}"),
    LOGIN("/api/login"),
    REGISTER("/api/register");

    @Getter
    @NonNull
    private String value;
}