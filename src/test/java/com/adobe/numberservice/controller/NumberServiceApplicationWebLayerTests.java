package com.adobe.numberservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adobe.numberservice.controller.NumberServiceController;
import com.adobe.numberservice.serv.RomanService;
import com.adobe.numberservice.utils.Constants;

/**
 * This class tests the application web layer.
 * @author Madhav Pandey
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class NumberServiceApplicationWebLayerTests {
	
    private MockMvc mockMvc;
    
    @Mock
	private RomanService mockRomanService;

	@InjectMocks
	private NumberServiceController mockNumberServiceController;

	/**
	 * This is a pre-test setup method responsible for injecting context into mockMvc
	 */
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(mockNumberServiceController).build();
	}
	
	/**
	 * This method is responsible for testing the endpoint response status and type
	 * by actually invoking the endpoint.
	 * @throws Exception base exception object
	 */
	@Test
    public void shouldHaveTextPlainResponseType() throws Exception {
		
		Mockito.when(mockRomanService.getRomanValue(Mockito.any(Object.class))).thenReturn(Mockito.anyString());
		
        this.mockMvc.perform(get(Constants.TEST_ENDPOINT+"/2")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(Constants.TEXT_PLAIN_ISO));
        
        Mockito.verify(mockRomanService).getRomanValue(Mockito.any(Object.class));
    }
}
