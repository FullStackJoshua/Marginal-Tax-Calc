package edu.citytech.gui.service._13fmanager;
import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.gui.service._13fmanager.model._13FDetails;
import edu.citytech.gui.service._13fmanager.model._13FManagers;

import java.util.List;


public class _13FManagerService {

    private static final String URL = "http://localhost:9215/13F/managers?symbol=$symbol&limit=$limit";

   public static List<_13FDetails> find13FManagers(String symbol, int limit) {
       String dynamicURL = URL.replace("$symbol", symbol)
               .replace("$limit",limit + "");


        var results = JSONGet.submitGet(dynamicURL, _13FManagers.class);
       List<_13FDetails> list = results.getResults();
        return list;
    }
}

