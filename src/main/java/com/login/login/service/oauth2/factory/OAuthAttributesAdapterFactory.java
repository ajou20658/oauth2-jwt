package com.login.login.service.oauth2.factory;

import com.login.login.service.oauth2.factory.adapter.NotSupportedOAuthVendorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OAuthAttributesAdapterFactory {
    private final List<OAuthAttributesAdapter> oAuthAttributesAdapters;
    public OAuthAttributesAdapter factory(String registrationId){
        return oAuthAttributesAdapters.stream()
                .filter(oAuthAttributesAdapter ->
                        oAuthAttributesAdapter.supports(registrationId))
                .findFirst()
                .orElseThrow(()->new NotSupportedOAuthVendorException("해당 OAuth2 벤더는 지원되지 않습니다."));
    }
}
