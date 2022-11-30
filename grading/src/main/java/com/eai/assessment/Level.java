package com.eai.assessment;


public enum Level {
    EXEMPLARY(4L),
    ACCOMPLISHED(3L),
    DEVELOPING(2L),
    BEGINNING(1L);

    private Long value;

    private Level(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
