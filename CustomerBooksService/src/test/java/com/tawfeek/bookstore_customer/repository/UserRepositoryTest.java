package com.tawfeek.bookstore_customer.repository;

import com.tawfeek.bookstore_customer.entity.CustomerUser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private CustomerUserRepository userRepository;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }
    @Test
    void shouldReturnUserByName() {
        CustomerUser user=new CustomerUser();
        user.setEmail("t.shalash1@gmail.com");
        user.setPassword("1234");
        user.setUserName("tawfeek");
        userRepository.save(user);
        List<CustomerUser> result = userRepository.findByUserName("tawfeek").get();
        assertThat(Objects.equals(result.get(0).getEmail(), "t.shalash1@gmail.com")&&result.get(0).getUsername().equals("tawfeek"));
        assertThat(result.size()).isEqualTo(1);
    }
}