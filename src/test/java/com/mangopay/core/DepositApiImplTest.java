package com.mangopay.core;

import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.entities.Deposit;
import com.mangopay.entities.Transaction;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
    public void createDepositCheckCardInfo() {
        try {
            Deposit deposit = this.createNewDeposit();

            assertNotNull(deposit.getCardInfo());
//            assertNotNull(deposit.getCardInfo().getBrand());
//            assertNotNull(deposit.getCardInfo().getType());
//            assertNotNull(deposit.getCardInfo().getIssuingBank());
//            assertNotNull(deposit.getCardInfo().getBin());
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

    @Test
    public void getAllDepositsForUser() throws Exception {
        Deposit deposit = this.createNewDeposit();
        List<Deposit> result = this.api.getDepositApi().getAllForUser(deposit.getAuthorId(), null, null, null);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void getAllDepositsForCard() throws Exception {
        Deposit deposit = this.createNewDeposit();
        List<Deposit> result = this.api.getDepositApi().getAllForCard(deposit.getCardId(), null, null, null);

        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
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

    @Test
    public void getTransactions() throws Exception {
        Deposit deposit = this.createNewDeposit();
        this.createDepositPreAuthorizedPayInWithoutComplement(deposit.getId());
        Thread.sleep(1000);
        List<Transaction> transactions = this.api.getDepositApi().getTransactions(deposit.getId(), null, null, null);
        assertFalse(transactions.isEmpty());
    }
}
