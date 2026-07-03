package utils;

import base.BaseTest;

public class DemoUtil extends BaseTest {

    public static void demoDelay() {

        try {

            if (prop.getProperty("demoMode").equalsIgnoreCase("true")) {

                Thread.sleep(
                        Integer.parseInt(prop.getProperty("demoDelay"))
                );

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}