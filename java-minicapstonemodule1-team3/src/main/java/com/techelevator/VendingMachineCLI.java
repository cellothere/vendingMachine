package com.techelevator;

import java.io.IOException;

public class VendingMachineCLI {

	public static void main(String[] args) throws IOException {

		VendingMachine capStoneVendingMachine = new VendingMachine();

		capStoneVendingMachine.setOn(false);

		capStoneVendingMachine.runVendingMachine();
	}
}
