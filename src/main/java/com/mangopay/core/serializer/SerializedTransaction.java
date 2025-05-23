package com.mangopay.core.serializer;

import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.mangopay.entities.Transaction;

class SerializedTransaction {

    static JsonObject getTransactionObject(Transaction source, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.add("Id", context.serialize(source.getId()));
        object.add("Tag", context.serialize(source.getTag()));
        object.add("CreationDate", context.serialize(source.getCreationDate()));

        object.add("AuthorId", context.serialize(source.getAuthorId()));
        object.add("CreditedUserId", context.serialize(source.getCreditedUserId()));
        object.add("DebitedFunds", context.serialize(source.getDebitedFunds()));
        object.add("CreditedFunds", context.serialize(source.getCreditedFunds()));
        object.add("Fees", context.serialize(source.getFees()));
        object.add("Status", context.serialize(source.getStatus()));
        object.add("ResultCode", context.serialize(source.getResultCode()));
        object.add("ResultMessage", context.serialize(source.getResultMessage()));
        object.add("ExecutionDate", context.serialize(source.getExecutionDate()));
        object.add("Type", context.serialize(source.getType()));
        object.add("Nature", context.serialize(source.getNature()));
        object.add("DepositId", context.serialize(source.getDepositId()));

        return object;
    }
}
