package com.adobe.numberservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.adobe.numberservice.utils.NumberServiceTestUtils;

@RunWith(SpringRunner.class)
@WebMvcTest
public class NumberServiceApplicationWebLayerTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
    public void shouldHaveTextPlainResponseType() throws Exception {
        this.mockMvc.perform(get(NumberServiceTestUtils.TEST_ENDPOINT+"/{number}", "number")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(NumberServiceTestUtils.TEXT_PLAIN_UTF8));
    }
}
