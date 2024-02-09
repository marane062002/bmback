package com.bmh.utils;

import java.text.DecimalFormat;

public abstract class FunctionsUtils {
	// Separateur milliers
	public static String decimalSeparator(double montant) {
		String pattern = "###,###.00";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		return decimalFormat.format(montant);
	}
	
	// type marche en arabe
	public static String typeMarcheAr(int idType) {
		String output = "";
		switch (idType) {
		case 1:
			output = "( \u0635\u0641\u0642\u0629 \u0642\u0627\u0628\u0644\u0629 \u0644\u0644\u062a\u062c\u062f\u064a\u062f )";
			break; // Marchés reconductibles
		case 2:
			output = "( \u0635\u0641\u0642\u0629 \u0625\u0637\u0627\u0631 )";
			break; // Marchés-cadre
		case 3:
			output = "( \u0635\u0641\u0642\u0629 \u0645\u062d\u0635\u0635\u0629 )";
			break; // Marchés allotis
		case 4:
			output = "( \u0635\u0641\u0642\u0629 \u0628\u0623\u0642\u0633\u0627\u0637 \u0625\u0634\u062a\u0631\u0627\u0637\u064a\u0629 )";
			break; // Marchés à tranches conditionnelles
		case 5:
			output = "( \u0635\u0641\u0642\u0629 \u0627\u0644\u062a\u0635\u0648\u0631 \u0648\u0627\u0644\u0625\u0646\u062c\u0627\u0632 )";
			break; // Marchés de conception-réalisation
		case 6:
			output = "( \u0635\u0641\u0642\u0629 \u0639\u0627\u062f\u064a\u0629 )";
			break; // Normale
		default:
			output = "";
			break;
		}
		System.out.println("Resultat type marche Ar : " + output);
		return output;
	}
}
