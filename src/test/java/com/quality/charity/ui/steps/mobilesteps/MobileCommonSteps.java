package com.quality.charity.ui.steps.mobilesteps;

import com.quality.charity.utilities.Context;
import com.quality.charity.utilities.DataLoader;
import com.quality.charity.factory.drivers.ApplicationSetup;
import cucumber.api.java8.En;

public class MobileCommonSteps implements En {

    private final ApplicationSetup applicationSetup;
    private  final DataLoader dataLoader;
    private final Context context;

    public MobileCommonSteps(ApplicationSetup applicationSetup, DataLoader dataLoader, Context context) {
        this.applicationSetup = applicationSetup;
        this.dataLoader = dataLoader;
        this.context = context;

        Given("^open amazon website in mobile browser$", () -> {
        });
    }
}
