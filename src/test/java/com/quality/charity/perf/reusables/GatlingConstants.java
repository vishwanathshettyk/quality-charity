package com.quality.charity.perf.reusables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

public class GatlingConstants {

    public static int RAMP_USER = 10;
    public static long TEST_DURATION = 10;

}
