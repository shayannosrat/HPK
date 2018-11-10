package de.lab4inf.wrb;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ThrowingErrorListener extends BaseErrorListener {

	   public static final ThrowingErrorListener INSTANCE = new ThrowingErrorListener();

	   @Override
	   public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
	      throws IllegalArgumentException {
	         throw new IllegalArgumentException("line " + line + ":" + charPositionInLine + " " + msg);
	      }
	}
