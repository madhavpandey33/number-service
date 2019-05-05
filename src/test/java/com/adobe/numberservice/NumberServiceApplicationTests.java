package com.adobe.numberservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adobe.numberservice.controller.NumberServiceController;

/**
 * This class is responsible for testing numberservice application context load.
 * @author Madhav Pandey
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberServiceApplicationTests {

	@Autowired
    private NumberServiceController controller;

  /**
	 * Checks context load by checking if the controller instance is null or not.
	 * @throws Exception base Exception object
	 */
    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    
  /**
	 * Call main method from NumberServiceApplication
	 * 
	 */
    @Test
    public void applicationContextTest() {
    	NumberServiceApplication.main(new String[] {});
    }

}
