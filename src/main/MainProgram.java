package main;

import java.awt.EventQueue;

import gui.DangNhap;

public class MainProgram {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DangNhap().setVisible(true);
			}
		});
	}
}