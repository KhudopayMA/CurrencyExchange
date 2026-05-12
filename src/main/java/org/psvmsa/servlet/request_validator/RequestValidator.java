package org.psvmsa.servlet.request_validator;

public interface RequestValidator<T> {

    void validate(T entity);
}
