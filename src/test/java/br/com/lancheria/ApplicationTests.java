package br.com.lancheria;

import br.com.lancheria.enums.PaymentType;
import br.com.lancheria.vo.IngredientVO;
import br.com.lancheria.vo.OrderVO;
import br.com.lancheria.vo.SnackVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static br.com.lancheria.controller.IngredientEndpoints.*;
import static br.com.lancheria.controller.OrderEndpoints.PATH_ORDER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT, properties = {"security.basic.enabled=false"})
@ActiveProfiles("integrationtests")
public class ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBreads() {
        ResponseEntity<IngredientVO[]> response = restTemplate.getForEntity(PATH_INGREDIENTS + PATH_BREADS, IngredientVO[].class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().length, greaterThan(0));
    }

    @Test
    public void testCheeses() {
        ResponseEntity<IngredientVO[]> response = restTemplate.getForEntity(PATH_INGREDIENTS + PATH_CHEESES, IngredientVO[].class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().length, greaterThan(0));
    }

    @Test
    public void testFillings() {
        ResponseEntity<IngredientVO[]> response = restTemplate.getForEntity(PATH_INGREDIENTS + PATH_FILLINGS, IngredientVO[].class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().length, greaterThan(0));
    }

    @Test
    public void testPlaceOrder() {
        ResponseEntity<Long> response = restTemplate.postForEntity(PATH_ORDER, createOrder(), Long.class);
        assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    }

    public OrderVO createOrder() {
        OrderVO order = new OrderVO();
        order.setAddress("Av. Paulista, 1804");
        order.setUserFacebookId("10215610170554164");
        order.setPaymentType(PaymentType.DEBIT);

        SnackVO snack = new SnackVO();
        snack.setBreadId(1L);
        snack.setCheeseId(3L);
        snack.setFillingId(5L);
        snack.setDoubleFilling(true);
        snack.setSaladId(7L);
        snack.addSauce(11L);

        order.addSnack(snack);

        Map<Integer, BigDecimal> paymentSplit = new HashMap<>();
        paymentSplit.put(1, BigDecimal.valueOf(100));
        order.setPaymentSplit(paymentSplit);

        return order;
    }
}
