package edu.citytech.gui.service;


import edu.citytech.gui.service._13fmanager._13FManagerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class T2_WebAPI {

    private String URL = "http://localhost:9215/13F/managers?symbol=AAPL";

    @Test
    @DisplayName("WebAPI Connection")
    void t1_addition() {

        String stock = "AAPL";
        int limit = 15;

        var results =  _13FManagerService.find13FManagers(stock,limit);
        var actual = results.size();
        var expected = limit;

        results.forEach(System.out::println);


        assertEquals(expected, actual);
    }


}

