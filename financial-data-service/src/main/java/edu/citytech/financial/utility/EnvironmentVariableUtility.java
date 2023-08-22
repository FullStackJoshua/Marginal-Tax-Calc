package edu.citytech.financial.utility;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EnvironmentVariableUtility {

    public record Pair(String key, String value){};
    public static void getVariables(Consumer<Pair> consumer){
      Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            Pair pair = new Pair(envName, env.get(envName));
            consumer.accept(pair);
        }
    }
    public static String getVariable(String variableName){
        List<Pair> list = new ArrayList<>();
        getVariables(list::add);

        Pair pair = list.stream().filter(e -> e.key().equals(variableName))
                .findFirst().get();

        return pair.value();
    }

}
