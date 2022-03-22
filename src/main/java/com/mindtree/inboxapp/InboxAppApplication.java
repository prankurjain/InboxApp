package com.mindtree.inboxapp;

import java.nio.file.Path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class InboxAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InboxAppApplication.class, args);
	}

	@RequestMapping(value = "/user")
	public String user(@AuthenticationPrincipal OAuth2User principal) {
		System.out.println("Principal " + principal);
		return principal.getAttribute("name");
	}
	// @Bean
	// public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties){
	// 	Path bundle=astraProperties.getSecureConnectBundle().toPath();
	// 	return builder-> builder.withCloudSecureConnectBundle(bundle).withKeyspace("main").build();
	// }

}
