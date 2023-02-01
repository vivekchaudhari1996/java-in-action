package com.koko.java8.inaction.resourcecleanup;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
	void accept(T instance) throws X;
}