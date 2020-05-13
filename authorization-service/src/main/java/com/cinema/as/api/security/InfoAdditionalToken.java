package com.cinema.as.api.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.cinema.as.api.entity.User;
import com.cinema.as.api.service.UserService;

/**
 * Class responsible to set additional information in the token
 * @author j.a.vasconcelos
 *
 */
@Component
public class InfoAdditionalToken implements TokenEnhancer {

	@Autowired
	private UserService userService;

	/**
	 * Method responsible to put aditionalInformation in the token
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();

		User user = (User) userService.loadUserByUsername(authentication.getName());
		info.put("name", user.getName());
		// info.put("email", usuario.getEmail());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		return accessToken;
	}

}
