package org.sefglobal.core.partnership.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class PartnershipAPIException extends Exception {

    public PartnershipAPIException() {
        super();
    }

    public PartnershipAPIException(String msg) {
        super(msg);
    }

    public PartnershipAPIException(String msg, Throwable e) {
        super(msg, e);
    }
}
