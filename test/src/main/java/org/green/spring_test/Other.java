package org.green.spring_test;

import org.springframework.stereotype.Component;

@Component
public class Other {
	private Some some;

	public Other(Some some) {
		super();
		this.some = some;
	}

	public Other() {
		super();
	}

	public Some getSome() {
		return some;
	}

	public void setSome(Some some) {
		this.some = some;
	}

	@Override
	public String toString() {
		return "Other [some=" + some + "]";
	}
}
