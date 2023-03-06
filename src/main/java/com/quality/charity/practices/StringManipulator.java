package com.quality.charity.practices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringManipulator {


    public String getFirstNoDuplicateCharacter(String x)
    {
        x = x.replace(" ", "");
        String   nonDuplicate ="";
        int size = x.length() - 1;

        for(int i = 0; i <x.length() ; i++) {
            String key = String.valueOf(x.charAt(i));
            String trimmed = x.replace(key, "");

            if(trimmed.length() == size)
            {
                nonDuplicate = nonDuplicate + key;
            }
        }

        if(nonDuplicate != null)
        {
            return nonDuplicate.substring(0,1);
        }
        return "No non-duplicate character found";
    }

    public HashMap<String,Integer> getDuplicateCount(String x)
    {
        HashMap<String,Integer> map = new HashMap<>();

        x = x.replace(" ", "");

        for(int i = 0; i <x.length() ; i++) {

            String y = String.valueOf(x.charAt(i));
            Integer z = map.get(y);
            map.put(String.valueOf(x.charAt(i)), map.get(y) != null ? z + 1 : 1);

        }
        return map;
    }

    public List<Integer> getDigitsFromString(String x)
    {

        List<Integer> digits = new ArrayList<>();
        for(int i = 0; i <x.length() ; i++) {
            String key = String.valueOf(x.charAt(i));

            try
            {
              int y = Integer.parseInt(key);
               digits.add(y);
            }catch (Exception e)
            {
            }
        }
        return  digits;
    }

}
