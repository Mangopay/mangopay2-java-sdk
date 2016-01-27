package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.PayOutPaymentDetailsBankWire;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiIdempotency test methods.
 */
public class ApiIdempotencyTest extends BaseTest {
    
    @Test
    public void test_Idempotency() {
        
        Calendar c = Calendar.getInstance();
        String key = Long.toString(c.getTimeInMillis());
        key = key + "abcdef";   // <- to make the key string at least 16 characters long

        PayOut payOut = null;

        // create bankwire
        try
        {
            Wallet wallet = this.getJohnsWallet();
            UserNatural user = this.getJohn();
            BankAccount account = this.getJohnsAccount();

            PayOut payOutPost = new PayOut();
            payOutPost.AuthorId = user.Id;
            payOutPost.DebitedWalletId = wallet.Id;
            Money debitedFunds = new Money();
            debitedFunds.Amount = 10;
            debitedFunds.Currency = CurrencyIso.EUR;
            payOutPost.DebitedFunds = debitedFunds;
            Money fees = new Money();
            fees.Amount = 5;
            fees.Currency = CurrencyIso.EUR;
            payOutPost.Fees = fees;
            PayOutPaymentDetailsBankWire paymentDetails = new PayOutPaymentDetailsBankWire();
            paymentDetails.BankAccountId = account.Id;
            paymentDetails.BankWireRef = "Johns bank wire ref";
            paymentDetails.Communication = "Communication text";
            payOutPost.MeanOfPaymentDetails = paymentDetails;
            
            payOutPost.Tag = "DefaultTag";
            payOutPost.CreditedUserId = user.Id;

            payOut = this._api.PayOuts.create(key, payOutPost);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        assertNotNull(payOut);


        // test existing key
        IdempotencyResponse result = null;
        try
        {
            result = this._api.Idempotency.get(key);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        assertNotNull(result);


        // test not existing key
        result = null;
        try
        {
            result = this._api.Idempotency.get(key + "_no");

            // expect a response error
            Assert.fail();
        }
        catch (Exception ex)
        {
            /* catch block intentionally left empty */
        }
        
    }
    
}
