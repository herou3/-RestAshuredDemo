package statuscode;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatusCode {
    SUCCESS_CODE(200),
    SUCCESS_CREATE_CODE(201),
    SUCCESS_DELETE_CODE(204),
    NOT_FOUND_CODE(404);

    @Getter
    @NonNull
    private int value;
}
