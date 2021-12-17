package testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.DateUtils;
import utilities.ReadConfigFiles;


public class TestNgMavenExample {
    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenExample.class);



    @Test
    public void  run () {
        System.out.println(DateUtils.returNextMonth());
    }

    }



