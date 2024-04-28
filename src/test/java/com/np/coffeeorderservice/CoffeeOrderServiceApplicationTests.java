package com.np.coffeeorderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
class CoffeeOrderServiceApplicationTests {

    @Test
    void mainStartsApplication() {
        assertThatCode(() -> CoffeeOrderServiceApplication.main(new String[] {})).doesNotThrowAnyException();
    }

}
