package com.ripper.budding.io.heartbeat;

import lombok.Data;

import java.io.Serializable;

@Data
public class Heart implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String sex;

	@Override
	public String toString() {
		return "Heart [name=" + name + ", sex=" + sex + "]";
	}
}
