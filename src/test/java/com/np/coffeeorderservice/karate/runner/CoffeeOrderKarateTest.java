package com.np.coffeeorderservice.karate.runner;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.junit5.Karate;

@KarateOptions(features = "classpath:karate/features/order-controller.feature")
public class CoffeeOrderKarateTest
{
    @Karate.Test
    Karate testOrderController() {
        return Karate.run("classpath:karate/features/order-controller.feature").relativeTo(getClass());
    }
}
