package coztion.springai.core.shared.presentation.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum RestResponseType {
    SUCCESS("success"),
    FAILURE("failure");

    private final String type;
}
