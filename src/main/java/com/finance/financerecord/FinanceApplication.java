package com.finance.financerecord;

import com.finance.financerecord.core.PriceDAO;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.DBIHealthCheck;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.finance.financerecord.resources.FinanceResource;
import org.skife.jdbi.v2.DBI;


public class FinanceApplication extends Application<FinanceConfiguration> {
    public static void main(String[] args) throws Exception {
        new FinanceApplication().run(args);
    }

    @Override
    public String getName() {
        return "finance-record-service";
    }

    @Override
    public void initialize(Bootstrap<FinanceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(FinanceConfiguration configuration,
                    Environment environment) {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mariadb");
        final PriceDAO dao = jdbi.onDemand(PriceDAO.class);

        final FinanceResource resource = new FinanceResource(dao);
        environment.jersey().register(resource);

        final DBIHealthCheck healthCheck = new DBIHealthCheck(
                jdbi,
                "SELECT 1"
        );
        environment.healthChecks().register("template", healthCheck);
    }

}