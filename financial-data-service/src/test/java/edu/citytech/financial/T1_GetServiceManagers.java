package edu.citytech.financial;

import edu.citytech.financial.model._13FManagers;
import edu.citytech.financial.service._13FManagerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class T1_GetServiceManagers {
    @Autowired
    _13FManagerService service;

    @Test
    @DisplayName("Query 13F Managers, By Joshua Lim")
    public void t1() {
        Map<String, Object> map = service.getManagersByStock("AAPL", 10);

        List<_13FManagers> list = (List<_13FManagers>) map.get("results");
        list.stream().map(_13FManagers::simplePrint)
                .forEach(System.out::println);
    }

}
