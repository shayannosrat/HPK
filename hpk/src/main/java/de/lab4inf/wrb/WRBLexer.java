// Generated from de\lab4inf\wrb\WRB.g4 by ANTLR 4.7
package de.lab4inf.wrb;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WRBLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ABS=4, ACOS=5, ASIN=6, ATAN=7, ATAN2=8, CBRT=9, 
		CEIL=10, COS=11, COSH=12, EXP=13, EXPM1=14, FLOOR=15, FLOORDIV=16, FLOORMOD=17, 
		HYPOD=18, LN=19, LOG=20, LOGE=21, LOG10=22, LOG2=23, LB=24, LD=25, LOG1P=26, 
		MAX=27, MIN=28, POWFUNC=29, RINT=30, ROUND=31, SCALB=32, SIGNUM=33, SIN=34, 
		SINH=35, SQRT=36, TAN=37, TANH=38, SCI_NO=39, DIGIT=40, ID=41, ADD=42, 
		MUL=43, DIV=44, SUB=45, POW=46, BRACKET_BEGIN=47, BRACKET_END=48, ASSIGN=49, 
		END=50, NEWLINE=51, WS=52;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
		"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
		"Y", "Z", "NUMBER", "LAZY_FLOAT", "ABS", "ACOS", "ASIN", "ATAN", "ATAN2", 
		"CBRT", "CEIL", "COS", "COSH", "EXP", "EXPM1", "FLOOR", "FLOORDIV", "FLOORMOD", 
		"HYPOD", "LN", "LOG", "LOGE", "LOG10", "LOG2", "LB", "LD", "LOG1P", "MAX", 
		"MIN", "POWFUNC", "RINT", "ROUND", "SCALB", "SIGNUM", "SIN", "SINH", "SQRT", 
		"TAN", "TANH", "SCI_NO", "DIGIT", "ID", "ADD", "MUL", "DIV", "SUB", "POW", 
		"BRACKET_BEGIN", "BRACKET_END", "ASSIGN", "END", "NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'{'", "'}'", null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "'+'", "'*'", "'/'", "'-'", null, 
		"'('", "')'", "'='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "ABS", "ACOS", "ASIN", "ATAN", "ATAN2", "CBRT", 
		"CEIL", "COS", "COSH", "EXP", "EXPM1", "FLOOR", "FLOORDIV", "FLOORMOD", 
		"HYPOD", "LN", "LOG", "LOGE", "LOG10", "LOG2", "LB", "LD", "LOG1P", "MAX", 
		"MIN", "POWFUNC", "RINT", "ROUND", "SCALB", "SIGNUM", "SIN", "SINH", "SQRT", 
		"TAN", "TANH", "SCI_NO", "DIGIT", "ID", "ADD", "MUL", "DIV", "SUB", "POW", 
		"BRACKET_BEGIN", "BRACKET_END", "ASSIGN", "END", "NEWLINE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public WRBLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WRB.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u01da\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u00df\n\37\r\37\16"+
		"\37\u00e0\3\37\3\37\6\37\u00e5\n\37\r\37\16\37\u00e6\5\37\u00e9\n\37\3"+
		" \3 \6 \u00ed\n \r \16 \u00ee\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,"+
		"\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/"+
		"\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\39\39\3"+
		"9\39\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3"+
		">\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3"+
		"B\3B\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\5D\u01a8\nD\3D\5D\u01ab\nD\3E\6E\u01ae"+
		"\nE\rE\16E\u01af\3F\6F\u01b3\nF\rF\16F\u01b4\3F\7F\u01b8\nF\fF\16F\u01bb"+
		"\13F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3K\5K\u01c8\nK\3L\3L\3M\3M\3N\3N\3"+
		"O\3O\3P\5P\u01d3\nP\3P\3P\3Q\3Q\3Q\3Q\2\2R\3\3\5\4\7\5\t\2\13\2\r\2\17"+
		"\2\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61"+
		"\2\63\2\65\2\67\29\2;\2=\2?\2A\6C\7E\bG\tI\nK\13M\fO\rQ\16S\17U\20W\21"+
		"Y\22[\23]\24_\25a\26c\27e\30g\31i\32k\33m\34o\35q\36s\37u w!y\"{#}$\177"+
		"%\u0081&\u0083\'\u0085(\u0087)\u0089*\u008b+\u008d,\u008f-\u0091.\u0093"+
		"/\u0095\60\u0097\61\u0099\62\u009b\63\u009d\64\u009f\65\u00a1\66\3\2!"+
		"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2K"+
		"Kkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4"+
		"\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\"+
		"||\3\2\62;\4\2--//\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\2\u01c8\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2"+
		"\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2"+
		"a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3"+
		"\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2"+
		"\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2"+
		"\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d"+
		"\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f"+
		"\3\2\2\2\2\u00a1\3\2\2\2\3\u00a3\3\2\2\2\5\u00a5\3\2\2\2\7\u00a7\3\2\2"+
		"\2\t\u00a9\3\2\2\2\13\u00ab\3\2\2\2\r\u00ad\3\2\2\2\17\u00af\3\2\2\2\21"+
		"\u00b1\3\2\2\2\23\u00b3\3\2\2\2\25\u00b5\3\2\2\2\27\u00b7\3\2\2\2\31\u00b9"+
		"\3\2\2\2\33\u00bb\3\2\2\2\35\u00bd\3\2\2\2\37\u00bf\3\2\2\2!\u00c1\3\2"+
		"\2\2#\u00c3\3\2\2\2%\u00c5\3\2\2\2\'\u00c7\3\2\2\2)\u00c9\3\2\2\2+\u00cb"+
		"\3\2\2\2-\u00cd\3\2\2\2/\u00cf\3\2\2\2\61\u00d1\3\2\2\2\63\u00d3\3\2\2"+
		"\2\65\u00d5\3\2\2\2\67\u00d7\3\2\2\29\u00d9\3\2\2\2;\u00db\3\2\2\2=\u00de"+
		"\3\2\2\2?\u00ea\3\2\2\2A\u00f0\3\2\2\2C\u00f4\3\2\2\2E\u00f9\3\2\2\2G"+
		"\u00fe\3\2\2\2I\u0103\3\2\2\2K\u0109\3\2\2\2M\u010e\3\2\2\2O\u0113\3\2"+
		"\2\2Q\u0117\3\2\2\2S\u011c\3\2\2\2U\u0120\3\2\2\2W\u0126\3\2\2\2Y\u012c"+
		"\3\2\2\2[\u0135\3\2\2\2]\u013e\3\2\2\2_\u0144\3\2\2\2a\u0147\3\2\2\2c"+
		"\u014b\3\2\2\2e\u0150\3\2\2\2g\u0156\3\2\2\2i\u015b\3\2\2\2k\u015e\3\2"+
		"\2\2m\u0161\3\2\2\2o\u0167\3\2\2\2q\u016b\3\2\2\2s\u016f\3\2\2\2u\u0173"+
		"\3\2\2\2w\u0178\3\2\2\2y\u017e\3\2\2\2{\u0184\3\2\2\2}\u018b\3\2\2\2\177"+
		"\u018f\3\2\2\2\u0081\u0194\3\2\2\2\u0083\u0199\3\2\2\2\u0085\u019d\3\2"+
		"\2\2\u0087\u01aa\3\2\2\2\u0089\u01ad\3\2\2\2\u008b\u01b2\3\2\2\2\u008d"+
		"\u01bc\3\2\2\2\u008f\u01be\3\2\2\2\u0091\u01c0\3\2\2\2\u0093\u01c2\3\2"+
		"\2\2\u0095\u01c7\3\2\2\2\u0097\u01c9\3\2\2\2\u0099\u01cb\3\2\2\2\u009b"+
		"\u01cd\3\2\2\2\u009d\u01cf\3\2\2\2\u009f\u01d2\3\2\2\2\u00a1\u01d6\3\2"+
		"\2\2\u00a3\u00a4\7.\2\2\u00a4\4\3\2\2\2\u00a5\u00a6\7}\2\2\u00a6\6\3\2"+
		"\2\2\u00a7\u00a8\7\177\2\2\u00a8\b\3\2\2\2\u00a9\u00aa\t\2\2\2\u00aa\n"+
		"\3\2\2\2\u00ab\u00ac\t\3\2\2\u00ac\f\3\2\2\2\u00ad\u00ae\t\4\2\2\u00ae"+
		"\16\3\2\2\2\u00af\u00b0\t\5\2\2\u00b0\20\3\2\2\2\u00b1\u00b2\t\6\2\2\u00b2"+
		"\22\3\2\2\2\u00b3\u00b4\t\7\2\2\u00b4\24\3\2\2\2\u00b5\u00b6\t\b\2\2\u00b6"+
		"\26\3\2\2\2\u00b7\u00b8\t\t\2\2\u00b8\30\3\2\2\2\u00b9\u00ba\t\n\2\2\u00ba"+
		"\32\3\2\2\2\u00bb\u00bc\t\13\2\2\u00bc\34\3\2\2\2\u00bd\u00be\t\f\2\2"+
		"\u00be\36\3\2\2\2\u00bf\u00c0\t\r\2\2\u00c0 \3\2\2\2\u00c1\u00c2\t\16"+
		"\2\2\u00c2\"\3\2\2\2\u00c3\u00c4\t\17\2\2\u00c4$\3\2\2\2\u00c5\u00c6\t"+
		"\20\2\2\u00c6&\3\2\2\2\u00c7\u00c8\t\21\2\2\u00c8(\3\2\2\2\u00c9\u00ca"+
		"\t\22\2\2\u00ca*\3\2\2\2\u00cb\u00cc\t\23\2\2\u00cc,\3\2\2\2\u00cd\u00ce"+
		"\t\24\2\2\u00ce.\3\2\2\2\u00cf\u00d0\t\25\2\2\u00d0\60\3\2\2\2\u00d1\u00d2"+
		"\t\26\2\2\u00d2\62\3\2\2\2\u00d3\u00d4\t\27\2\2\u00d4\64\3\2\2\2\u00d5"+
		"\u00d6\t\30\2\2\u00d6\66\3\2\2\2\u00d7\u00d8\t\31\2\2\u00d88\3\2\2\2\u00d9"+
		"\u00da\t\32\2\2\u00da:\3\2\2\2\u00db\u00dc\t\33\2\2\u00dc<\3\2\2\2\u00dd"+
		"\u00df\t\34\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e8\3\2\2\2\u00e2\u00e4\7\60\2\2\u00e3"+
		"\u00e5\t\34\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3"+
		"\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e9\3\2\2\2\u00e8\u00e2\3\2\2\2\u00e8"+
		"\u00e9\3\2\2\2\u00e9>\3\2\2\2\u00ea\u00ec\7\60\2\2\u00eb\u00ed\t\34\2"+
		"\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef@\3\2\2\2\u00f0\u00f1\5\t\5\2\u00f1\u00f2\5\13\6\2\u00f2"+
		"\u00f3\5-\27\2\u00f3B\3\2\2\2\u00f4\u00f5\5\t\5\2\u00f5\u00f6\5\r\7\2"+
		"\u00f6\u00f7\5%\23\2\u00f7\u00f8\5-\27\2\u00f8D\3\2\2\2\u00f9\u00fa\5"+
		"\t\5\2\u00fa\u00fb\5-\27\2\u00fb\u00fc\5\31\r\2\u00fc\u00fd\5#\22\2\u00fd"+
		"F\3\2\2\2\u00fe\u00ff\5\t\5\2\u00ff\u0100\5/\30\2\u0100\u0101\5\t\5\2"+
		"\u0101\u0102\5#\22\2\u0102H\3\2\2\2\u0103\u0104\5\t\5\2\u0104\u0105\5"+
		"/\30\2\u0105\u0106\5\t\5\2\u0106\u0107\5#\22\2\u0107\u0108\7\64\2\2\u0108"+
		"J\3\2\2\2\u0109\u010a\5\r\7\2\u010a\u010b\5\13\6\2\u010b\u010c\5+\26\2"+
		"\u010c\u010d\5/\30\2\u010dL\3\2\2\2\u010e\u010f\5\r\7\2\u010f\u0110\5"+
		"\21\t\2\u0110\u0111\5\31\r\2\u0111\u0112\5\37\20\2\u0112N\3\2\2\2\u0113"+
		"\u0114\5\r\7\2\u0114\u0115\5%\23\2\u0115\u0116\5-\27\2\u0116P\3\2\2\2"+
		"\u0117\u0118\5\r\7\2\u0118\u0119\5%\23\2\u0119\u011a\5-\27\2\u011a\u011b"+
		"\5\27\f\2\u011bR\3\2\2\2\u011c\u011d\5\21\t\2\u011d\u011e\5\67\34\2\u011e"+
		"\u011f\5\'\24\2\u011fT\3\2\2\2\u0120\u0121\5\21\t\2\u0121\u0122\5\67\34"+
		"\2\u0122\u0123\5\'\24\2\u0123\u0124\5!\21\2\u0124\u0125\7\63\2\2\u0125"+
		"V\3\2\2\2\u0126\u0127\5\23\n\2\u0127\u0128\5\37\20\2\u0128\u0129\5%\23"+
		"\2\u0129\u012a\5%\23\2\u012a\u012b\5+\26\2\u012bX\3\2\2\2\u012c\u012d"+
		"\5\23\n\2\u012d\u012e\5\37\20\2\u012e\u012f\5%\23\2\u012f\u0130\5%\23"+
		"\2\u0130\u0131\5+\26\2\u0131\u0132\5\17\b\2\u0132\u0133\5\31\r\2\u0133"+
		"\u0134\5\63\32\2\u0134Z\3\2\2\2\u0135\u0136\5\23\n\2\u0136\u0137\5\37"+
		"\20\2\u0137\u0138\5%\23\2\u0138\u0139\5%\23\2\u0139\u013a\5+\26\2\u013a"+
		"\u013b\5!\21\2\u013b\u013c\5%\23\2\u013c\u013d\5\17\b\2\u013d\\\3\2\2"+
		"\2\u013e\u013f\5\27\f\2\u013f\u0140\59\35\2\u0140\u0141\5\'\24\2\u0141"+
		"\u0142\5%\23\2\u0142\u0143\5\17\b\2\u0143^\3\2\2\2\u0144\u0145\5\37\20"+
		"\2\u0145\u0146\5#\22\2\u0146`\3\2\2\2\u0147\u0148\5\37\20\2\u0148\u0149"+
		"\5%\23\2\u0149\u014a\5\25\13\2\u014ab\3\2\2\2\u014b\u014c\5\37\20\2\u014c"+
		"\u014d\5%\23\2\u014d\u014e\5\25\13\2\u014e\u014f\5\21\t\2\u014fd\3\2\2"+
		"\2\u0150\u0151\5\37\20\2\u0151\u0152\5%\23\2\u0152\u0153\5\25\13\2\u0153"+
		"\u0154\7\63\2\2\u0154\u0155\7\62\2\2\u0155f\3\2\2\2\u0156\u0157\5\37\20"+
		"\2\u0157\u0158\5%\23\2\u0158\u0159\5\25\13\2\u0159\u015a\7\64\2\2\u015a"+
		"h\3\2\2\2\u015b\u015c\5\37\20\2\u015c\u015d\5\13\6\2\u015dj\3\2\2\2\u015e"+
		"\u015f\5\37\20\2\u015f\u0160\5\17\b\2\u0160l\3\2\2\2\u0161\u0162\5\37"+
		"\20\2\u0162\u0163\5%\23\2\u0163\u0164\5\25\13\2\u0164\u0165\7\63\2\2\u0165"+
		"\u0166\5\'\24\2\u0166n\3\2\2\2\u0167\u0168\5!\21\2\u0168\u0169\5\t\5\2"+
		"\u0169\u016a\5\67\34\2\u016ap\3\2\2\2\u016b\u016c\5!\21\2\u016c\u016d"+
		"\5\31\r\2\u016d\u016e\5#\22\2\u016er\3\2\2\2\u016f\u0170\5\'\24\2\u0170"+
		"\u0171\5%\23\2\u0171\u0172\5\65\33\2\u0172t\3\2\2\2\u0173\u0174\5+\26"+
		"\2\u0174\u0175\5\31\r\2\u0175\u0176\5#\22\2\u0176\u0177\5/\30\2\u0177"+
		"v\3\2\2\2\u0178\u0179\5+\26\2\u0179\u017a\5%\23\2\u017a\u017b\5\61\31"+
		"\2\u017b\u017c\5#\22\2\u017c\u017d\5\17\b\2\u017dx\3\2\2\2\u017e\u017f"+
		"\5-\27\2\u017f\u0180\5\r\7\2\u0180\u0181\5\t\5\2\u0181\u0182\5\37\20\2"+
		"\u0182\u0183\5\13\6\2\u0183z\3\2\2\2\u0184\u0185\5-\27\2\u0185\u0186\5"+
		"\31\r\2\u0186\u0187\5\25\13\2\u0187\u0188\5#\22\2\u0188\u0189\5\61\31"+
		"\2\u0189\u018a\5!\21\2\u018a|\3\2\2\2\u018b\u018c\5-\27\2\u018c\u018d"+
		"\5\31\r\2\u018d\u018e\5#\22\2\u018e~\3\2\2\2\u018f\u0190\5-\27\2\u0190"+
		"\u0191\5\31\r\2\u0191\u0192\5#\22\2\u0192\u0193\5\27\f\2\u0193\u0080\3"+
		"\2\2\2\u0194\u0195\5-\27\2\u0195\u0196\5)\25\2\u0196\u0197\5+\26\2\u0197"+
		"\u0198\5/\30\2\u0198\u0082\3\2\2\2\u0199\u019a\5/\30\2\u019a\u019b\5\t"+
		"\5\2\u019b\u019c\5#\22\2\u019c\u0084\3\2\2\2\u019d\u019e\5/\30\2\u019e"+
		"\u019f\5\t\5\2\u019f\u01a0\5#\22\2\u01a0\u01a1\5\27\f\2\u01a1\u0086\3"+
		"\2\2\2\u01a2\u01a7\5=\37\2\u01a3\u01a4\5\21\t\2\u01a4\u01a5\t\35\2\2\u01a5"+
		"\u01a6\5=\37\2\u01a6\u01a8\3\2\2\2\u01a7\u01a3\3\2\2\2\u01a7\u01a8\3\2"+
		"\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01ab\5? \2\u01aa\u01a2\3\2\2\2\u01aa\u01a9"+
		"\3\2\2\2\u01ab\u0088\3\2\2\2\u01ac\u01ae\t\34\2\2\u01ad\u01ac\3\2\2\2"+
		"\u01ae\u01af\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u008a"+
		"\3\2\2\2\u01b1\u01b3\t\36\2\2\u01b2\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2"+
		"\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5\u01b9\3\2\2\2\u01b6\u01b8"+
		"\t\37\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb\3\2\2\2\u01b9\u01b7\3\2\2\2"+
		"\u01b9\u01ba\3\2\2\2\u01ba\u008c\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bc\u01bd"+
		"\7-\2\2\u01bd\u008e\3\2\2\2\u01be\u01bf\7,\2\2\u01bf\u0090\3\2\2\2\u01c0"+
		"\u01c1\7\61\2\2\u01c1\u0092\3\2\2\2\u01c2\u01c3\7/\2\2\u01c3\u0094\3\2"+
		"\2\2\u01c4\u01c5\7,\2\2\u01c5\u01c8\7,\2\2\u01c6\u01c8\7`\2\2\u01c7\u01c4"+
		"\3\2\2\2\u01c7\u01c6\3\2\2\2\u01c8\u0096\3\2\2\2\u01c9\u01ca\7*\2\2\u01ca"+
		"\u0098\3\2\2\2\u01cb\u01cc\7+\2\2\u01cc\u009a\3\2\2\2\u01cd\u01ce\7?\2"+
		"\2\u01ce\u009c\3\2\2\2\u01cf\u01d0\7=\2\2\u01d0\u009e\3\2\2\2\u01d1\u01d3"+
		"\7\17\2\2\u01d2\u01d1\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d4\3\2\2\2"+
		"\u01d4\u01d5\7\f\2\2\u01d5\u00a0\3\2\2\2\u01d6\u01d7\t \2\2\u01d7\u01d8"+
		"\3\2\2\2\u01d8\u01d9\bQ\2\2\u01d9\u00a2\3\2\2\2\20\2\u00e0\u00e6\u00e8"+
		"\u00ee\u01a7\u01aa\u01af\u01b2\u01b4\u01b7\u01b9\u01c7\u01d2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}