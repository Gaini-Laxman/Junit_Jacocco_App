package com.klinnovations.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.klinnovations.entities.UserEntity;
import com.klinnovations.props.AppProperties;
import com.klinnovations.repositories.CityRepository;
import com.klinnovations.repositories.CountryRepository;
import com.klinnovations.repositories.StateRepository;
import com.klinnovations.repositories.UserRepository;
import com.klinnovations.service.RegistrationServiceImpl;
import com.klinnovations.util.EmailUtils;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistrationServiceImplTest {

	@MockBean
	private UserRepository userRepo;

	@MockBean
	private CountryRepository countryRepo;

	@MockBean
	private StateRepository stateRepo;

	@MockBean
	private CityRepository cityRepo;

	@MockBean
	private EmailUtils emailUtils;

	@MockBean
	private AppProperties appProps;

	@InjectMocks
	private RegistrationServiceImpl service;

	@Test
	public void uniqueEmailTest1() {
		when(userRepo.findByUserEmail("ashok@gmail.com")).thenReturn(new UserEntity());
		boolean uniqueEmail = service.uniqueEmail("ashok@gmail.com");
		assertFalse(uniqueEmail);
	}
	
	@Test
	public void uniqueEmailTest2() {
		when(userRepo.findByUserEmail("ashok@gmail.com")).thenReturn(null);
		boolean uniqueEmail = service.uniqueEmail("ashok@gmail.com");
		assertTrue(uniqueEmail);
	}

}
