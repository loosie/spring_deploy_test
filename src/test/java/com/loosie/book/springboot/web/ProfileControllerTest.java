package com.loosie.book.springboot.web;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

public class ProfileControllerTest {

	@Test
	public void real_profile_조회(){
		// given
		String expectedProfile = "real";
		MockEnvironment env = new MockEnvironment();
		env.addActiveProfile(expectedProfile);
		env.addActiveProfile("oauth");
		env.addActiveProfile("real-db");

		ProfileController controller = new ProfileController(env);

		// when
		String profile = controller.profile();

		// then
		assertThat(profile).isEqualTo(expectedProfile);
	}
}