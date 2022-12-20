package com.mangopay.core;

import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * DepositApiImpl test methods.
 */
public class DepositApiImplTest extends BaseTest {

    @Test
    public void createDeposit() {
        try {
            Deposit deposit = this.createNewDeposit();

            Assert.assertNotNull(deposit);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void getDeposit() {
        try {
            Deposit deposit = this.createNewDeposit();
            Deposit fetchedDeposit = this.api.getDepositApi().get(deposit.getId());

            Assert.assertNotNull(fetchedDeposit);
            Assert.assertEquals(deposit.getId(), fetchedDeposit.getId());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Ignore("Manual deposit confirmation needed")
    @Test
    public void cancelDeposit() {
        try {
            Deposit deposit = this.createNewDeposit();
            this.api.getDepositApi().cancel(deposit.getId());

            Deposit canceledDeposit = this.api.getDepositApi().get(deposit.getId());

            Assert.assertNotNull(canceledDeposit);
            Assert.assertEquals(PaymentStatus.CANCELED, canceledDeposit.getPaymentStatus());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
