package com.quality.charity.practices;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class CalculateHECS {


        public static Double getMonthlyRepayment(double grossIncome, double additionalIncome)
        {
            double monthlyRepayment = 0.00;
            grossIncome = grossIncome + additionalIncome;

            for (Map.Entry<String,Double> entry : getInterestRateRange().entrySet()) {
                String[] range = entry.getKey().split("-");
                DecimalFormat format = new DecimalFormat("##.00");

                if (!(grossIncome >= Double.valueOf(range[0])) || !(grossIncome <= Double.valueOf(range[1]))) {
                    if(grossIncome > 100000)
                    {
                        monthlyRepayment = grossIncome * 0.07/12;
                        monthlyRepayment = Double.parseDouble(format.format(monthlyRepayment));
                    }
                } else {

                    monthlyRepayment = grossIncome * entry.getValue()/12;
                    monthlyRepayment = Double.parseDouble(format.format(monthlyRepayment));
                    break;
                }
            }

            System.out.println(monthlyRepayment);
            return monthlyRepayment;
        }



        private static Map<String, Double> getInterestRateRange()
        {
            Map<String, Double> map = new HashMap<>();

            map.put("48000-55000", 0.02);
            map.put("55500-65500", 0.01);
            map.put("96000-100000", 0.07);

            return map;
        }
}
