package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.models.User;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)
@Rollback(false)

public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){

        User user = new User();
        user.setUserName("testUserWithRoles");
        user.setPassword("testPassword");
        user.setActive(true);
        user.setRoles("ROLE_USER,ROLE_ADMIN");

        // Save the user using the repository
        User savedUser = repo.save(user);

        // Retrieve the user from the entity manager
        User existUser = entityManager.find(User.class, savedUser.getId());

        // Verify that the user was saved correctly
        assertThat(existUser.getUserName()).isEqualTo("testUserWithRoles");
        assertThat(existUser.getPassword()).isEqualTo("testPassword");
        assertThat(existUser.isActive()).isTrue();
        assertThat(existUser.getRoles()).isEqualTo("ROLE_USER,ROLE_ADMIN");
    }


}