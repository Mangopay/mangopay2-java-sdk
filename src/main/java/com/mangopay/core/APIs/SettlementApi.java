package com.mangopay.core.APIs;

import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.entities.SettlementTransfer;

import java.util.List;

public interface SettlementApi {


    SettlementTransfer get(String id) throws Exception;

    /**
     * Get a list of all settlements
     *
     * @param pagination Pagination object
     * @param sorting    Sorting object
     * @return list of {@link SettlementTransfer}s
     * @throws Exception
     */
    List<SettlementTransfer> getAll(Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Get a list of all settlements
     *
     * @return list of {@link SettlementTransfer}s
     * @throws Exception
     */
    List<SettlementTransfer> getAll() throws Exception;

}
