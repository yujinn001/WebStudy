package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // 프로그램 종료될 때까지 유지! => 저장 기간
@Target(METHOD) //Method구분
/*
 *  @RequestMapping("a") -> if -> index(찾기)
 *  public void display()
 *  {
 *  }
 */
public @interface RequestMapping {
	public String value();
}
