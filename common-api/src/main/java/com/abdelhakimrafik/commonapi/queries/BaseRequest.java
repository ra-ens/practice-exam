package com.abdelhakimrafik.commonapi.queries;

public class BaseRequest<T> {
    protected T id;

    public BaseRequest(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
