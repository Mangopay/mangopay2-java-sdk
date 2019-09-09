package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.RepudiationApi;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Repudiation;

import java.util.List;

/**
 * Created by cosmin on 17-11-2017.
 */
public class RepudiationApiImpl extends ApiBase implements RepudiationApi {

    /**
     * Creates new API instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public RepudiationApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Repudiation getRepudiation(String repudiationId) throws Exception {
        return this.getObject(Repudiation.class, "disputes_repudiation_get", repudiationId);
    }

    @Override
    public List<Refund> getRefunds(String repudiationId) throws Exception {
        return this.getRefunds(repudiationId, null, null);
    }

    @Override
    public List<Refund> getRefunds(String repudiationId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Refund[].class, Refund.class, "repudiation_get_refunds", pagination, repudiationId, sorting);
    }
}
