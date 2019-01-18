package com.brainmentors.utils;

public interface SQLConstants {
	String USER_LOGIN_SQL = "select userid , password from users where userid=? and password=?";
}
