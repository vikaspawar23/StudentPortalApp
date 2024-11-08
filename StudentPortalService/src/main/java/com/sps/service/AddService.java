package com.sps.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;



@Service
public class AddService {

	public List<String> getAllStates() {
		List<String> stateList = Arrays.asList("Maharashtra", "Gujrat", "Delhi","Telangana");
		return stateList;
	}

	public Optional<List<String>> getCitiesByState(String state) {
		
		List<String> stateList = Arrays.asList("Delhi");
		if (state.equalsIgnoreCase("Maharashtra")) {
			stateList = Arrays.asList("Beed", "Pune", "Mumbai");
			return Optional.of(stateList);
		}
		if (state.equalsIgnoreCase("Gujrat")) {
			stateList = Arrays.asList("Ahmedabad", "aaa", "bbb");
			return Optional.of(stateList);
		}
		
		if (state.equalsIgnoreCase("Telangana")) {
			stateList = Arrays.asList("Hyderabad", "Sikandrabad", "GGG");
			return Optional.of(stateList);
		}

		return Optional.of(stateList);
	}

}
