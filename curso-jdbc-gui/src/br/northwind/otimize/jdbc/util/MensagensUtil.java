package br.northwind.otimize.jdbc.util;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MensagensUtil {
	
	public static void addMsg(Component component,  String msg) {
		JOptionPane.showMessageDialog(component, msg);
	}

}
