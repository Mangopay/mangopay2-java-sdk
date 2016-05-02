package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.TransactionStatus;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Repudiation entity.
 */
public class Repudiation extends EntityBase {
    
    /**
     * The Id of the origin payin author.
     */
    public String AuthorId;

    /**
     *The funds repudiated from the wallet.
     */
    public Money DebitedFunds;

    /**
     * The fees taken on the repudiation – will always be 0 at this stage.
     */
    public Money Fees;

    /**
     * The amount of credited funds – since there are currently no fees, 
     * this will be equal to the DebitedFunds.
     */
    public Money CreditedFunds;

    /**
     * The wallet from where the repudiation was taken.
     */
    public String DebitedWalletId;

    /**
     * The status of the transfer.
     */
    public TransactionStatus Status;

    /**
     * The transaction result code.
     */
    public String ResultCode;

    /**
     * The transaction result message.
     */
    public String ResultMessage;

    /**
     * The execution date of the repudiation.
     */
    public Long ExecutionDate;

    /**
     * The Id of the dispute to which this repudiation corresponds. 
     * Note that this value may be null (if it was created before the Dispute 
     * objects started to be used – October 2015).
     */
    public String DisputeId;

    /**
     * The Id of the transaction that was repudiated.
     */
    public String InitialTransactionId;

    /**
     * The initial transaction type.
     */
    public String InitialTransactionType;
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        return new HashMap<String, Type>() {{ 
            put("DebitedFunds", Money.class);
            put("Fees", Money.class);
            put("CreditedFunds", Money.class);
        }};
    }
}
