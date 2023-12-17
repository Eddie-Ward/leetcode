package daily;

import java.util.HashSet;
import java.util.List;

class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> citySet = new HashSet<>();

        for (List<String> cities : paths) {
            citySet.add(cities.get(1));
        }
        for (List<String> cities : paths) {
            citySet.remove(cities.get(0));
        }
        return citySet.iterator().next();
    }
}
