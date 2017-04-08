package com.finance.financerecord.resources;

import com.finance.financerecord.core.Price;
import com.finance.financerecord.core.PriceDAO;
import com.finance.financerecord.core.PriceInput;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;


@Path("/price-record")
@Produces(MediaType.APPLICATION_JSON)
public class FinanceResource {
    private final PriceDAO dao;
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceResource.class);

    public FinanceResource(PriceDAO dao) {
        this.dao = dao;

    }

    @GET
    @Path("/{id}")
    @Timed
    public Price getTicker(@PathParam("id") int id) {
        final Price price = dao.findTickerById(id);
        return price;
    }

    @POST
    @Timed
    public Price insertTicker(PriceInput priceInput) {
        LOGGER.debug("Tried to insert {}", priceInput.getTicker());
        int id = dao.insert(priceInput.getTicker());

        final Price price = dao.findTickerById(id);
        return price;
    }
}