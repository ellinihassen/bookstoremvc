package com.vermeg.bookstoremvc.utils;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME="Authorization";
    public static final String SECRET_KEY="secretkey";
    public static final long EXPIRATION=10*24*3600;
    public static final String HEADER_PREFIX="Bearer ";
}
