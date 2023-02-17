package com.quality.charity.factory.restassuredfactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
public enum ApiConstants {

    APPLICATION_JSON("application/json"),
    APPLICATION_XML("application/xml"),
    TEXT_HTML("text/htlm"),
    X_ING_ACCESS_TOKEN("X-ING-Accesstoken"),
    X_ING_COUNTRY_CODE("x-ing-country-code"),
    X_ING_LAST_UPDATE_USER("X-ING-LastUpdateUser");

    private  String value;
}
