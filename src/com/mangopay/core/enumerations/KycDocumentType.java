package com.mangopay.core.enumerations;

/**
 * KYC document type enumeration.
 */
public enum KycDocumentType {
    /**
     * Not specified.
     */ 
    NotSpecified,

    /**
     * Only for natural users. ID of the individual duly empowered to act on 
     * behalf of the legal entity.
     */ 
    IDENTITY_PROOF,

    /**
     * Only for legal users. Extract from the relevant register of commerce 
     * issued within the last three months.
     */ 
    REGISTRATION_PROOF,

    /**
     * Only for legal users. It’s the Statute. Formal memorandum stated by 
     * the entrepreuneurs, in which the following information is mentioned: 
     * business name, activity, registered address, shareholding.
     */ 
    ARTICLES_OF_ASSOCIATION,

    /**
     * Only for legal users (business company).
     */ 
    SHAREHOLDER_DECLARATION,

    /**
     * Only for natural users.
     */ 
    ADDRESS_PROOF
}
