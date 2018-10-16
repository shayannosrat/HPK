package de.lab4inf.wrb;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.*;

import de.lab4inf.wrb.WRBLexer;
import de.lab4inf.wrb.WRBObserver;
import de.lab4inf.wrb.WRBParser;
import de.lab4inf.wrb.WRBParser.RunContext;

public class App {
	public static void main(String args[]) throws Exception {
		//Init des Read Buffers
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expr = br.readLine();
		int line = 1;
		
		//Parser und Observer erstellen
		WRBParser parser = new WRBParser(null);
		WRBObserver ob = new WRBObserver();
		
		WRBParser.RunContext r;
		
		while(expr != null) {
		
			CharStream inputStream = CharStreams.fromString(expr+'\n');
			WRBLexer lexer = new WRBLexer(inputStream);
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser.setInputStream(tokenStream); // neuen Token-Stream an parser geben
			
			try {
				r = parser.run(); // Token-Stream parsen
				Double res = Double.valueOf(ob.visitRun(r));// Ergebnis ausgeben
				System.out.println("Visitor: " + res);
				
			} catch(Exception e) {
				System.err.println("Fehler: " + e.toString());
			}
			
			expr = br.readLine(); // nächste Zeile lesen
			line++;
		}
	}
}
