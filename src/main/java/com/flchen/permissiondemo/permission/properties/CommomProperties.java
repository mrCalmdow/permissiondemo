package com.flchen.permissiondemo.permission.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author feilongchen
 * @since 2018-08-15 2:58 PM
 */
@Component
@ConfigurationProperties(prefix = "settings")
@Data
public class CommomProperties {

	private boolean dev = false;
	private String tokenHeader = "X-User-Token";
	private String permissionHeader = "mobile";
}
