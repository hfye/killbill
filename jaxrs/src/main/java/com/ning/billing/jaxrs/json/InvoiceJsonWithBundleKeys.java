package com.ning.billing.jaxrs.json;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

import com.ning.billing.invoice.api.Invoice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

public class InvoiceJsonWithBundleKeys extends InvoiceJsonSimple {

    private final String bundleKeys;

    public InvoiceJsonWithBundleKeys() {
        super();
        this.bundleKeys = null;
    }

    @JsonCreator
    public InvoiceJsonWithBundleKeys(@JsonProperty("amount") final BigDecimal amount,
                                     @JsonProperty("cba") final BigDecimal cba,
                                     @JsonProperty("creditAdj") final BigDecimal creditAdj,
                                     @JsonProperty("refundAdj") final BigDecimal refundAdj,
                                     @JsonProperty("invoiceId") final String invoiceId,
                                     @JsonProperty("invoiceDate") final LocalDate invoiceDate,
                                     @JsonProperty("targetDate") final LocalDate targetDate,
                                     @JsonProperty("invoiceNumber") final String invoiceNumber,
                                     @JsonProperty("balance") final BigDecimal balance,
                                     @JsonProperty("accountId") final String accountId,
                                     @JsonProperty("externalBundleKeys") final String bundleKeys) {
        super(amount, cba, creditAdj, refundAdj, invoiceId, invoiceDate, targetDate, invoiceNumber, balance, accountId);
        this.bundleKeys = bundleKeys;
    }

    public InvoiceJsonWithBundleKeys(final Invoice input, final String bundleKeys) {
        super(input);
        this.bundleKeys = bundleKeys;
    }

    public String getBundleKeys() {
        return bundleKeys;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final InvoiceJsonWithBundleKeys that = (InvoiceJsonWithBundleKeys) o;

        if (bundleKeys != null ? !bundleKeys.equals(that.bundleKeys) : that.bundleKeys != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (bundleKeys != null ? bundleKeys.hashCode() : 0);
        return result;
    }
}
