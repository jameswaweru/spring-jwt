package com.jameswaweru.jwt.dto;

import java.util.Collection;
import java.util.Collections;

public class ResponseDTO<E> {
    private String statusCode;
    private String statusMessage;
    private Collection<E> data;
    private Collection<String> errors;

    public ResponseDTO(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = Collections.emptyList();
        this.errors = Collections.emptyList();
    }

    public ResponseDTO(String statusCode, String statusMessage, Collection<E> data) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
        this.errors = Collections.emptyList();
    }

    public static <E> ResponseDTOBuilder<E> builder() {
        return new ResponseDTOBuilder();
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public Collection<E> getData() {
        return this.data;
    }

    public Collection<String> getErrors() {
        return this.errors;
    }

    public void setStatusCode(final String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMessage(final String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public void setData(final Collection<E> data) {
        this.data = data;
    }

    public void setErrors(final Collection<String> errors) {
        this.errors = errors;
    }

    public String toString() {
        String var10000 = this.getStatusCode();
        return "ResponseDTO(statusCode=" + var10000 + ", statusMessage=" + this.getStatusMessage() + ", data=" + this.getData() + ", errors=" + this.getErrors() + ")";
    }

    public ResponseDTO() {
    }

    public ResponseDTO(final String statusCode, final String statusMessage, final Collection<E> data, final Collection<String> errors) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.data = data;
        this.errors = errors;
    }

    public static class ResponseDTOBuilder<E> {
        private String statusCode;
        private String statusMessage;
        private Collection<E> data;
        private Collection<String> errors;

        ResponseDTOBuilder() {
        }

        public ResponseDTOBuilder<E> statusCode(final String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseDTOBuilder<E> statusMessage(final String statusMessage) {
            this.statusMessage = statusMessage;
            return this;
        }

        public ResponseDTOBuilder<E> data(final Collection<E> data) {
            this.data = data;
            return this;
        }

        public ResponseDTOBuilder<E> errors(final Collection<String> errors) {
            this.errors = errors;
            return this;
        }

        public ResponseDTO<E> build() {
            return new ResponseDTO(this.statusCode, this.statusMessage, this.data, this.errors);
        }

        public String toString() {
            return "ResponseDTO.ResponseDTOBuilder(statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", data=" + this.data + ", errors=" + this.errors + ")";
        }
    }
}
