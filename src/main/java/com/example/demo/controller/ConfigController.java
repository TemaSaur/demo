package com.example.demo.controller;

import com.example.demo.config.properties.MyProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigController {
	final MyProperties myCustomProperties;

	@GetMapping("/check-profile")
	public HashMap<String, String> getConfigInfo(){
		HashMap<String, String> profileData = new HashMap<>();

		profileData.put("env", myCustomProperties.getMyEnv());
		profileData.put("app", myCustomProperties.getMyApp());
		profileData.put("my-list", myCustomProperties.getMyList().toString());

		return profileData;
	}
}
