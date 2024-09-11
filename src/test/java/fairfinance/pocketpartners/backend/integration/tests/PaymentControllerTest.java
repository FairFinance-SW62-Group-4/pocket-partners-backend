package fairfinance.pocketpartners.backend.integration.tests;

import fairfinance.pocketpartners.backend.operations.domain.services.PaymentCommandService;
import fairfinance.pocketpartners.backend.operations.domain.services.PaymentQueryService;
import fairfinance.pocketpartners.backend.operations.interfaces.rest.resources.CreatePaymentResource;
import fairfinance.pocketpartners.backend.operations.interfaces.rest.resources.PaymentResource;
import fairfinance.pocketpartners.backend.shared.interfaces.rest.resources.MessageResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaymentQueryService paymentQueryService;

    @Autowired
    private PaymentCommandService paymentCommandService;

    @BeforeEach
    public void setUp() {
        // Perform any setup needed before each test, such as clearing database or initializing data.
    }

    @Test
    public void testCreatePayment() throws Exception {
        // Arrange
        String url = "http://localhost:" + port + "/api/v1/payments";
        CreatePaymentResource request = new CreatePaymentResource("KFC", BigDecimal.TEN, 2L, 5L);

        // Act
        ResponseEntity<PaymentResource> response = restTemplate.postForEntity(url, request, PaymentResource.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        // Add more assertions based on expected behavior after creating a payment
    }

    @Test
    public void testCompletePayment() throws Exception {
        // Arrange
        Long paymentId = 1L;
        String url = "http://localhost:" + port + "/api/v1/payments/" + paymentId + "/completed";

        // Act
        ResponseEntity<MessageResource> response = restTemplate.postForEntity(url, null, MessageResource.class);

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();


        // Additional assertions based on expected behavior after completing a payment
    }

    // Add more tests for other endpoints like getAllPayments, getPaymentByUserId, etc.
}
