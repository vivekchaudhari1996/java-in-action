package com.koko.problems.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class treeMap {

    public static void main(String[] args) {
        // Creating a HashMap
        TreeMap<String, String> newHashMap = new TreeMap<>();

        // 1. Addition of key and value
        newHashMap.put("Key1", "Java");
        newHashMap.put("Key2", "C++");
        newHashMap.put("Key3", "Python");
        System.out.println(newHashMap);

        // 2. Get
        String a = newHashMap.get("Key1");

        // 3. Clear the map.
        newHashMap.clear();
        System.out.println("After clear:" + newHashMap);

        // 4. Addition of new key and value
        newHashMap.putIfAbsent("Key4", "Ruby");
        System.out.println(newHashMap);

        // 5. Contains Key
        System.out.println(newHashMap.containsKey("Key4"));

        // 6. Remove
        newHashMap.remove("Key4","Ruby");
        System.out.println(newHashMap);


        // 7. KeySet
        for (String key : newHashMap.keySet()) {
            System.out.println("Key: " + key + " Value: " + newHashMap.get(key));
        }

        // 8. Addition of null key
        // NullPointerException – if the specified key is null and this map uses natural ordering,
        // or its comparator does not permit null keys

        // newHashMap.put(null, "Sony");


        newHashMap.putIfAbsent("Key4", "Ruby");

        // 9. PutAll: copy contains of one Hashmap to another
        Map<String, String> copyHashMap = new HashMap<>();
        copyHashMap.putAll(newHashMap);
        // Or Map<String, String> copyHashMap = new HashMap<>(newHashMap);

        System.out.println("copyHashMap mappings= " + copyHashMap);

        //Removal of null key
        String nullKeyValue = copyHashMap.remove(null);
        System.out.println("copyHashMap null key value = " + nullKeyValue);


        // 9. Iteration using EntrySet
        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<String,String> entry : newHashMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());


        // using keySet() for iteration over keys
        for (String name : newHashMap.keySet())
            System.out.println("key: " + name);

        // 10. using values() for iteration over values
        for (String url : newHashMap.values())
            System.out.println("value: " + url);


        // 11. using iterators
        Iterator<Map.Entry<String, String>> itr = newHashMap.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String, String> entry = itr.next();
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        }


        // 12. forEach(action) method to iterate map
        newHashMap.forEach((k,v) -> System.out.println("Key = "
                + k + ", Value = " + v));

        // 13. containsValue
        System.out.println(newHashMap.containsValue("Java"));

        // 14. computeifAbsent
        newHashMap.computeIfAbsent("Key4", k-> "Java");
        System.out.println(newHashMap.get("Key4"));

        // 15. computeIfPresent
        newHashMap.computeIfPresent("Key4", (k,v) -> v.concat("8"));
        System.out.println(newHashMap.get("Key4"));

        newHashMap.put("Key1", "Java");
        newHashMap.put("Key2", "C++");
        newHashMap.put("Key3", "Python");

        copyHashMap = newHashMap.descendingMap();
        System.out.println(copyHashMap);
        System.out.println(newHashMap);

        copyHashMap.put("Key3", "Python1");
        System.out.println(copyHashMap);
        System.out.println(newHashMap);

        Iterator<String> itre = newHashMap.descendingKeySet().iterator();
        while (itre.hasNext()){
            String sa = itre.next();
            System.out.println(newHashMap.get(sa));
        }
    }
}
