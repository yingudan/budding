package com.ripper.budding.string;

import java.util.UUID;

public class Uuid {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
		System.out.println(getUUID());
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
