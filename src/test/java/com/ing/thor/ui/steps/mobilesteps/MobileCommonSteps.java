package com.ing.thor.ui.steps.mobilesteps;

import com.ing.thor.ui.utilities.Context;
import com.ing.thor.ui.utilities.DataLoader;
import com.ing.thor.ui.webdriver.factory.drivers.ApplicationSetup;
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
