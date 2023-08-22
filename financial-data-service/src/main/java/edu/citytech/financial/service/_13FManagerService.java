package edu.citytech.financial.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import edu.citytech.financial.model._13FManagers;
import edu.citytech.financial.model._13FManagers$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class _13FManagerService {
    @Autowired
    JPAStreamer jpaStreamer;

    public Map<String,Object>  getManagersByStock(final String symbol, int limit) {
        var list = jpaStreamer.stream(_13FManagers.class)
                .filter(_13FManagers$.stock.equal(symbol))
                .limit(limit)
                .collect(Collectors.toList());

        Map<String,Object> map = new HashMap<>();
        map.put("results", list);
        map.put("size",list.size());

        return map;
    }
}
