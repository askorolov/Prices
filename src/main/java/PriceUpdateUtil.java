import exception.NullInputDataException;

import java.util.*;


/**
 * Created by Korolev on 05.02.2017.
 */
public class PriceUpdateUtil {

    public static Map<String, List<Price>> convertListToMap(List<Price> list) {
        Map<String, List<Price>> map = new HashMap<>();
        for (Price p : list) {
            if(p==null){
                continue;
            }
            if (!map.containsKey(p.getProduct_code())) {
                List<Price> prices = new ArrayList<>();
                prices.add(p);
                map.put(p.getProduct_code(), prices);
            } else {
                List<Price> prices = map.get(p.getProduct_code());
                prices.add(p);
                map.put(p.getProduct_code(), prices);
            }
        }
        return map;
    }


    public static List<Price> updatePrices(List<Price> oldPrices, List<Price> newPrices) throws Exception {
        if(oldPrices==null||newPrices==null||oldPrices.isEmpty()||newPrices.isEmpty()){
            throw new NullInputDataException("The can be no null input data");
        }
        Map<String, List<Price>> oldPricesMap = convertListToMap(oldPrices);
        Map<String, List<Price>> newPricesMap = convertListToMap(newPrices);
        List<Price> uP = new ArrayList<>();
        Iterator<Map.Entry<String, List<Price>>> iterator = newPricesMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Price>> entry = iterator.next();

            if (!oldPricesMap.containsKey(entry.getKey())) {
                uP.addAll(entry.getValue());
            } else {
                List<Price> prices = oldPricesMap.get(entry.getKey());
                for (Price oldPrice : prices) {
                    for (Price newPrice : entry.getValue()) {

                        if (oldPrice.getDepart() == newPrice.getDepart() && oldPrice.getNumber() == newPrice.getNumber()) {

                            if (newPrice.getBegin().isBefore(oldPrice.getEnd())) {
                                if (oldPrice.getValue() == newPrice.getValue()) {
                                    oldPrice.setEnd(newPrice.getEnd());
                                    uP.add(oldPrice);
                                } else {
                                    uP.add(newPrice);
                                    if (oldPrice.getEnd().isAfter(newPrice.getEnd())) {
                                        uP.add(new Price(oldPrice.getProduct_code(),
                                                oldPrice.getNumber(), oldPrice.getDepart(), newPrice.getEnd(),
                                                oldPrice.getEnd(), oldPrice.getValue()));
                                    }

                                    oldPrice.setEnd(newPrice.getBegin());
                                    uP.add(oldPrice);
                                }
                            } else {
                                uP.add(newPrice);
                                uP.add(oldPrice);
                            }
                        }
                    }
                }
            }
        }
        return uP;

    }
}
