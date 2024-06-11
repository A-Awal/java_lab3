package com.example.JavaLab3;

import com.example.JavaLab3.Part_1.P1_UserRepository;
import com.example.JavaLab3.Part_1.P1_UserService;
import com.example.JavaLab3.Domain.UserDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;



class JavaLab3ApplicationTests {
	 P1_UserRepository repository = mock(P1_UserRepository.class);
	 P1_UserService service = new P1_UserService(repository);
	@Test
	void testGetUser() {
		//arrange
		UserDTO userDTO = new UserDTO();
		userDTO.setAge(10);
		userDTO.setName("hello");

		//Act
		var newUser = service.createUser(userDTO );

		//Assert
		assertThat(newUser).isInstanceOf(Integer.class);

	}

	@Test
	void FindAllUsers (){
		//Arrange

		// Act
		var users = service.getAllUsers();

		//Assert
		assertThat(users).isInstanceOf(Iterable.class);
	}



}
