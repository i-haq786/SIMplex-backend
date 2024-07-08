package com.inzi.customer_service;

import com.inzi.customer_service.controller.CustomerController;
import com.inzi.customer_service.dto.CustomerDTO;
import com.inzi.customer_service.dto.CustomerDto2;
import com.inzi.customer_service.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(CustomerController.class)
@ContextConfiguration(classes = {CustomerController.class})
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testVerificationProcess() throws Exception {
        String email = "test@example.com";
        String dob = "1990-01-01";
        String expectedResult = "valid";

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail(email);
        customerDTO.setDob(dob);

        when(customerService.validate(email, dob)).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/Customer/verify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"test@example.com\", \"dob\": \"1990-01-01\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().string(expectedResult));
    }

    @Test
    public void testCustomerDetailsPageValidation() throws Exception {
        String expectedResult = "validation result";

        CustomerDto2 customerDTO = new CustomerDto2();

        when(customerService.customerDetailsPageValidation(any(CustomerDto2.class))).thenReturn(expectedResult);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/Customer/us04")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"field1\": \"value1\", \"field2\": \"value2\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResult));
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        when(customerService.fetchAllCustomers()).thenReturn(Collections.emptyList());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/Customer")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(0));
    }
}
