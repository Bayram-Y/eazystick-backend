package com.eazybytes.eazystore.config;

import com.stripe.Stripe;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:stripe.properties")
public class StripeConfig {

    private final Dotenv dotenv = Dotenv.load(); // Enviromental Variable

    //    @Value("${stripe.apiKey}")
    //    private String apiKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = dotenv.get("STRIPE_API_KEY"); // get the .env
//        Stripe.apiKey = apiKey;
    }

}
