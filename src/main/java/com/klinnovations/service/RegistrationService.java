package com.klinnovations.service;

import java.util.Map;

import com.klinnovations.bindings.User;

public interface RegistrationService {

	public boolean uniqueEmail(String email);

	public Map<Integer, String> getCountries();

	public Map<Integer, String> getStates(Integer countryId);

	public Map<Integer, String> getCities(Integer stateId);

	public boolean registerUser(User user);

}