package com.finance.financerecord;

import com.google.common.base.Optional;

import com.finance.financerecord.core.Price;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    private static final String CONFIG_PATH = ResourceHelpers.resourceFilePath("hello-world.yml");

    @ClassRule
    public static final DropwizardAppRule<FinanceConfiguration> RULE =
            new DropwizardAppRule<>(FinanceApplication.class, CONFIG_PATH);

    private Client client;

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

    @After
    public void tearDown() {
        client.close();
    }

    @Test
    public void testHelloWorld() {
        final Optional<String> name = Optional.of("TestName");
        final Price price = client.target("http://localhost:" + RULE.getLocalPort() + "/price-record/1")
                .request()
                .get(Price.class);
        assertEquals("qvca", price.getTicker());
    }
}