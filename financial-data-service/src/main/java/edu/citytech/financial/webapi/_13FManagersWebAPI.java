package edu.citytech.financial.webapi;

import edu.citytech.financial.model._13FManagers;
import edu.citytech.financial.service._13FManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/13F")
public class _13FManagersWebAPI {

    @Autowired
    _13FManagerService service;
    @GetMapping("/managers")
    public Object get(@RequestParam(value = "symbol", defaultValue = "AAPL") String symbol,
                      @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Map<String, Object> map = service.getManagersByStock(symbol, limit);
        List<_13FManagers> list = (List<_13FManagers>) map.get("results");
        return map;
    }
}
