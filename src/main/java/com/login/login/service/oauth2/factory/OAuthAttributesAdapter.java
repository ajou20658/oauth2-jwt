package com.login.login.service.oauth2.factory;

import com.login.login.service.oauth2.dto.OAuthAttributes;

import java.util.Map;

public interface OAuthAttributesAdapter {
    OAuthAttributes toOAuthAttributes(Map<String,Object> attributes);
    boolean supports(String registrationId);
}
