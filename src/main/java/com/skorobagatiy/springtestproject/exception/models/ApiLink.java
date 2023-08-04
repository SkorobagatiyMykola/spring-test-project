package com.skorobagatiy.springtestproject.exception.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class ApiLink {
    private final String type;
    private final String rel;
    private final String href;

}
