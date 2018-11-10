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
		T__0=1, ABS=2, ACOS=3, ASIN=4, ATAN=5, ATAN2=6, CBRT=7, CEIL=8, COS=9, 
		COSH=10, EXP=11, EXPM1=12, FLOOR=13, FLOORDIV=14, FLOORMOD=15, HYPOD=16, 
		LN=17, LOG=18, LOGE=19, LOG10=20, LOG2=21, LB=22, LD=23, LOG1P=24, MAX=25, 
		MIN=26, POWFUNC=27, RINT=28, ROUND=29, SCALB=30, SIGNUM=31, SIN=32, SINH=33, 
		SQRT=34, TAN=35, TANH=36, SCI_NO=37, DIGIT=38, ID=39, ADD=40, MUL=41, 
		DIV=42, SUB=43, POW=44, BRACKET_BEGIN=45, BRACKET_END=46, ASSIGN=47, END=48, 
		NEWLINE=49, WS=50;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "NUMBER", 
		"LAZY_FLOAT", "ABS", "ACOS", "ASIN", "ATAN", "ATAN2", "CBRT", "CEIL", 
		"COS", "COSH", "EXP", "EXPM1", "FLOOR", "FLOORDIV", "FLOORMOD", "HYPOD", 
		"LN", "LOG", "LOGE", "LOG10", "LOG2", "LB", "LD", "LOG1P", "MAX", "MIN", 
		"POWFUNC", "RINT", "ROUND", "SCALB", "SIGNUM", "SIN", "SINH", "SQRT", 
		"TAN", "TANH", "SCI_NO", "DIGIT", "ID", "ADD", "MUL", "DIV", "SUB", "POW", 
		"BRACKET_BEGIN", "BRACKET_END", "ASSIGN", "END", "NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "'+'", "'*'", "'/'", "'-'", null, "'('", "')'", 
		"'='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ABS", "ACOS", "ASIN", "ATAN", "ATAN2", "CBRT", "CEIL", "COS", 
		"COSH", "EXP", "EXPM1", "FLOOR", "FLOORDIV", "FLOORMOD", "HYPOD", "LN", 
		"LOG", "LOGE", "LOG10", "LOG2", "LB", "LD", "LOG1P", "MAX", "MIN", "POWFUNC", 
		"RINT", "ROUND", "SCALB", "SIGNUM", "SIN", "SINH", "SQRT", "TAN", "TANH", 
		"SCI_NO", "DIGIT", "ID", "ADD", "MUL", "DIV", "SUB", "POW", "BRACKET_BEGIN", 
		"BRACKET_END", "ASSIGN", "END", "NEWLINE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\64\u01d2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\6\35\u00d7\n\35\r\35\16\35\u00d8\3\35\3\35\6\35\u00dd\n"+
		"\35\r\35\16\35\u00de\5\35\u00e1\n\35\3\36\3\36\6\36\u00e5\n\36\r\36\16"+
		"\36\u00e6\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*"+
		"\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-"+
		"\3-\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\38\3"+
		"8\38\38\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3"+
		"<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3@\3@\3@\3@\3A\3"+
		"A\3A\3A\3A\3B\3B\3B\3B\3B\5B\u01a0\nB\3B\5B\u01a3\nB\3C\6C\u01a6\nC\r"+
		"C\16C\u01a7\3D\6D\u01ab\nD\rD\16D\u01ac\3D\7D\u01b0\nD\fD\16D\u01b3\13"+
		"D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3I\5I\u01c0\nI\3J\3J\3K\3K\3L\3L\3M\3"+
		"M\3N\5N\u01cb\nN\3N\3N\3O\3O\3O\3O\2\2P\3\3\5\2\7\2\t\2\13\2\r\2\17\2"+
		"\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2"+
		"\63\2\65\2\67\29\2;\2=\4?\5A\6C\7E\bG\tI\nK\13M\fO\rQ\16S\17U\20W\21Y"+
		"\22[\23]\24_\25a\26c\27e\30g\31i\32k\33m\34o\35q\36s\37u w!y\"{#}$\177"+
		"%\u0081&\u0083\'\u0085(\u0087)\u0089*\u008b+\u008d,\u008f-\u0091.\u0093"+
		"/\u0095\60\u0097\61\u0099\62\u009b\63\u009d\64\3\2!\4\2CCcc\4\2DDdd\4"+
		"\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMm"+
		"m\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2"+
		"VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62;\4\2--/"+
		"/\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\2\u01c0\2\3\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2"+
		"q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3"+
		"\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2"+
		"\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\3\u009f\3\2\2\2\5\u00a1"+
		"\3\2\2\2\7\u00a3\3\2\2\2\t\u00a5\3\2\2\2\13\u00a7\3\2\2\2\r\u00a9\3\2"+
		"\2\2\17\u00ab\3\2\2\2\21\u00ad\3\2\2\2\23\u00af\3\2\2\2\25\u00b1\3\2\2"+
		"\2\27\u00b3\3\2\2\2\31\u00b5\3\2\2\2\33\u00b7\3\2\2\2\35\u00b9\3\2\2\2"+
		"\37\u00bb\3\2\2\2!\u00bd\3\2\2\2#\u00bf\3\2\2\2%\u00c1\3\2\2\2\'\u00c3"+
		"\3\2\2\2)\u00c5\3\2\2\2+\u00c7\3\2\2\2-\u00c9\3\2\2\2/\u00cb\3\2\2\2\61"+
		"\u00cd\3\2\2\2\63\u00cf\3\2\2\2\65\u00d1\3\2\2\2\67\u00d3\3\2\2\29\u00d6"+
		"\3\2\2\2;\u00e2\3\2\2\2=\u00e8\3\2\2\2?\u00ec\3\2\2\2A\u00f1\3\2\2\2C"+
		"\u00f6\3\2\2\2E\u00fb\3\2\2\2G\u0101\3\2\2\2I\u0106\3\2\2\2K\u010b\3\2"+
		"\2\2M\u010f\3\2\2\2O\u0114\3\2\2\2Q\u0118\3\2\2\2S\u011e\3\2\2\2U\u0124"+
		"\3\2\2\2W\u012d\3\2\2\2Y\u0136\3\2\2\2[\u013c\3\2\2\2]\u013f\3\2\2\2_"+
		"\u0143\3\2\2\2a\u0148\3\2\2\2c\u014e\3\2\2\2e\u0153\3\2\2\2g\u0156\3\2"+
		"\2\2i\u0159\3\2\2\2k\u015f\3\2\2\2m\u0163\3\2\2\2o\u0167\3\2\2\2q\u016b"+
		"\3\2\2\2s\u0170\3\2\2\2u\u0176\3\2\2\2w\u017c\3\2\2\2y\u0183\3\2\2\2{"+
		"\u0187\3\2\2\2}\u018c\3\2\2\2\177\u0191\3\2\2\2\u0081\u0195\3\2\2\2\u0083"+
		"\u01a2\3\2\2\2\u0085\u01a5\3\2\2\2\u0087\u01aa\3\2\2\2\u0089\u01b4\3\2"+
		"\2\2\u008b\u01b6\3\2\2\2\u008d\u01b8\3\2\2\2\u008f\u01ba\3\2\2\2\u0091"+
		"\u01bf\3\2\2\2\u0093\u01c1\3\2\2\2\u0095\u01c3\3\2\2\2\u0097\u01c5\3\2"+
		"\2\2\u0099\u01c7\3\2\2\2\u009b\u01ca\3\2\2\2\u009d\u01ce\3\2\2\2\u009f"+
		"\u00a0\7.\2\2\u00a0\4\3\2\2\2\u00a1\u00a2\t\2\2\2\u00a2\6\3\2\2\2\u00a3"+
		"\u00a4\t\3\2\2\u00a4\b\3\2\2\2\u00a5\u00a6\t\4\2\2\u00a6\n\3\2\2\2\u00a7"+
		"\u00a8\t\5\2\2\u00a8\f\3\2\2\2\u00a9\u00aa\t\6\2\2\u00aa\16\3\2\2\2\u00ab"+
		"\u00ac\t\7\2\2\u00ac\20\3\2\2\2\u00ad\u00ae\t\b\2\2\u00ae\22\3\2\2\2\u00af"+
		"\u00b0\t\t\2\2\u00b0\24\3\2\2\2\u00b1\u00b2\t\n\2\2\u00b2\26\3\2\2\2\u00b3"+
		"\u00b4\t\13\2\2\u00b4\30\3\2\2\2\u00b5\u00b6\t\f\2\2\u00b6\32\3\2\2\2"+
		"\u00b7\u00b8\t\r\2\2\u00b8\34\3\2\2\2\u00b9\u00ba\t\16\2\2\u00ba\36\3"+
		"\2\2\2\u00bb\u00bc\t\17\2\2\u00bc \3\2\2\2\u00bd\u00be\t\20\2\2\u00be"+
		"\"\3\2\2\2\u00bf\u00c0\t\21\2\2\u00c0$\3\2\2\2\u00c1\u00c2\t\22\2\2\u00c2"+
		"&\3\2\2\2\u00c3\u00c4\t\23\2\2\u00c4(\3\2\2\2\u00c5\u00c6\t\24\2\2\u00c6"+
		"*\3\2\2\2\u00c7\u00c8\t\25\2\2\u00c8,\3\2\2\2\u00c9\u00ca\t\26\2\2\u00ca"+
		".\3\2\2\2\u00cb\u00cc\t\27\2\2\u00cc\60\3\2\2\2\u00cd\u00ce\t\30\2\2\u00ce"+
		"\62\3\2\2\2\u00cf\u00d0\t\31\2\2\u00d0\64\3\2\2\2\u00d1\u00d2\t\32\2\2"+
		"\u00d2\66\3\2\2\2\u00d3\u00d4\t\33\2\2\u00d48\3\2\2\2\u00d5\u00d7\t\34"+
		"\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00e0\3\2\2\2\u00da\u00dc\7\60\2\2\u00db\u00dd\t"+
		"\34\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e1\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1:\3\2\2\2\u00e2\u00e4\7\60\2\2\u00e3\u00e5\t\34\2\2\u00e4\u00e3"+
		"\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"<\3\2\2\2\u00e8\u00e9\5\5\3\2\u00e9\u00ea\5\7\4\2\u00ea\u00eb\5)\25\2"+
		"\u00eb>\3\2\2\2\u00ec\u00ed\5\5\3\2\u00ed\u00ee\5\t\5\2\u00ee\u00ef\5"+
		"!\21\2\u00ef\u00f0\5)\25\2\u00f0@\3\2\2\2\u00f1\u00f2\5\5\3\2\u00f2\u00f3"+
		"\5)\25\2\u00f3\u00f4\5\25\13\2\u00f4\u00f5\5\37\20\2\u00f5B\3\2\2\2\u00f6"+
		"\u00f7\5\5\3\2\u00f7\u00f8\5+\26\2\u00f8\u00f9\5\5\3\2\u00f9\u00fa\5\37"+
		"\20\2\u00faD\3\2\2\2\u00fb\u00fc\5\5\3\2\u00fc\u00fd\5+\26\2\u00fd\u00fe"+
		"\5\5\3\2\u00fe\u00ff\5\37\20\2\u00ff\u0100\7\64\2\2\u0100F\3\2\2\2\u0101"+
		"\u0102\5\t\5\2\u0102\u0103\5\7\4\2\u0103\u0104\5\'\24\2\u0104\u0105\5"+
		"+\26\2\u0105H\3\2\2\2\u0106\u0107\5\t\5\2\u0107\u0108\5\r\7\2\u0108\u0109"+
		"\5\25\13\2\u0109\u010a\5\33\16\2\u010aJ\3\2\2\2\u010b\u010c\5\t\5\2\u010c"+
		"\u010d\5!\21\2\u010d\u010e\5)\25\2\u010eL\3\2\2\2\u010f\u0110\5\t\5\2"+
		"\u0110\u0111\5!\21\2\u0111\u0112\5)\25\2\u0112\u0113\5\23\n\2\u0113N\3"+
		"\2\2\2\u0114\u0115\5\r\7\2\u0115\u0116\5\63\32\2\u0116\u0117\5#\22\2\u0117"+
		"P\3\2\2\2\u0118\u0119\5\r\7\2\u0119\u011a\5\63\32\2\u011a\u011b\5#\22"+
		"\2\u011b\u011c\5\35\17\2\u011c\u011d\7\63\2\2\u011dR\3\2\2\2\u011e\u011f"+
		"\5\17\b\2\u011f\u0120\5\33\16\2\u0120\u0121\5!\21\2\u0121\u0122\5!\21"+
		"\2\u0122\u0123\5\'\24\2\u0123T\3\2\2\2\u0124\u0125\5\17\b\2\u0125\u0126"+
		"\5\33\16\2\u0126\u0127\5!\21\2\u0127\u0128\5!\21\2\u0128\u0129\5\'\24"+
		"\2\u0129\u012a\5\13\6\2\u012a\u012b\5\25\13\2\u012b\u012c\5/\30\2\u012c"+
		"V\3\2\2\2\u012d\u012e\5\17\b\2\u012e\u012f\5\33\16\2\u012f\u0130\5!\21"+
		"\2\u0130\u0131\5!\21\2\u0131\u0132\5\'\24\2\u0132\u0133\5\35\17\2\u0133"+
		"\u0134\5!\21\2\u0134\u0135\5\13\6\2\u0135X\3\2\2\2\u0136\u0137\5\23\n"+
		"\2\u0137\u0138\5\65\33\2\u0138\u0139\5#\22\2\u0139\u013a\5!\21\2\u013a"+
		"\u013b\5\13\6\2\u013bZ\3\2\2\2\u013c\u013d\5\33\16\2\u013d\u013e\5\37"+
		"\20\2\u013e\\\3\2\2\2\u013f\u0140\5\33\16\2\u0140\u0141\5!\21\2\u0141"+
		"\u0142\5\21\t\2\u0142^\3\2\2\2\u0143\u0144\5\33\16\2\u0144\u0145\5!\21"+
		"\2\u0145\u0146\5\21\t\2\u0146\u0147\5\r\7\2\u0147`\3\2\2\2\u0148\u0149"+
		"\5\33\16\2\u0149\u014a\5!\21\2\u014a\u014b\5\21\t\2\u014b\u014c\7\63\2"+
		"\2\u014c\u014d\7\62\2\2\u014db\3\2\2\2\u014e\u014f\5\33\16\2\u014f\u0150"+
		"\5!\21\2\u0150\u0151\5\21\t\2\u0151\u0152\7\64\2\2\u0152d\3\2\2\2\u0153"+
		"\u0154\5\33\16\2\u0154\u0155\5\7\4\2\u0155f\3\2\2\2\u0156\u0157\5\33\16"+
		"\2\u0157\u0158\5\13\6\2\u0158h\3\2\2\2\u0159\u015a\5\33\16\2\u015a\u015b"+
		"\5!\21\2\u015b\u015c\5\21\t\2\u015c\u015d\7\63\2\2\u015d\u015e\5#\22\2"+
		"\u015ej\3\2\2\2\u015f\u0160\5\35\17\2\u0160\u0161\5\5\3\2\u0161\u0162"+
		"\5\63\32\2\u0162l\3\2\2\2\u0163\u0164\5\35\17\2\u0164\u0165\5\25\13\2"+
		"\u0165\u0166\5\37\20\2\u0166n\3\2\2\2\u0167\u0168\5#\22\2\u0168\u0169"+
		"\5!\21\2\u0169\u016a\5\61\31\2\u016ap\3\2\2\2\u016b\u016c\5\'\24\2\u016c"+
		"\u016d\5\25\13\2\u016d\u016e\5\37\20\2\u016e\u016f\5+\26\2\u016fr\3\2"+
		"\2\2\u0170\u0171\5\'\24\2\u0171\u0172\5!\21\2\u0172\u0173\5-\27\2\u0173"+
		"\u0174\5\37\20\2\u0174\u0175\5\13\6\2\u0175t\3\2\2\2\u0176\u0177\5)\25"+
		"\2\u0177\u0178\5\t\5\2\u0178\u0179\5\5\3\2\u0179\u017a\5\33\16\2\u017a"+
		"\u017b\5\7\4\2\u017bv\3\2\2\2\u017c\u017d\5)\25\2\u017d\u017e\5\25\13"+
		"\2\u017e\u017f\5\21\t\2\u017f\u0180\5\37\20\2\u0180\u0181\5-\27\2\u0181"+
		"\u0182\5\35\17\2\u0182x\3\2\2\2\u0183\u0184\5)\25\2\u0184\u0185\5\25\13"+
		"\2\u0185\u0186\5\37\20\2\u0186z\3\2\2\2\u0187\u0188\5)\25\2\u0188\u0189"+
		"\5\25\13\2\u0189\u018a\5\37\20\2\u018a\u018b\5\23\n\2\u018b|\3\2\2\2\u018c"+
		"\u018d\5)\25\2\u018d\u018e\5%\23\2\u018e\u018f\5\'\24\2\u018f\u0190\5"+
		"+\26\2\u0190~\3\2\2\2\u0191\u0192\5+\26\2\u0192\u0193\5\5\3\2\u0193\u0194"+
		"\5\37\20\2\u0194\u0080\3\2\2\2\u0195\u0196\5+\26\2\u0196\u0197\5\5\3\2"+
		"\u0197\u0198\5\37\20\2\u0198\u0199\5\23\n\2\u0199\u0082\3\2\2\2\u019a"+
		"\u019f\59\35\2\u019b\u019c\5\r\7\2\u019c\u019d\t\35\2\2\u019d\u019e\5"+
		"9\35\2\u019e\u01a0\3\2\2\2\u019f\u019b\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u01a3\3\2\2\2\u01a1\u01a3\5;\36\2\u01a2\u019a\3\2\2\2\u01a2\u01a1\3\2"+
		"\2\2\u01a3\u0084\3\2\2\2\u01a4\u01a6\t\34\2\2\u01a5\u01a4\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u0086\3\2"+
		"\2\2\u01a9\u01ab\t\36\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac"+
		"\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad\u01b1\3\2\2\2\u01ae\u01b0\t\37"+
		"\2\2\u01af\u01ae\3\2\2\2\u01b0\u01b3\3\2\2\2\u01b1\u01af\3\2\2\2\u01b1"+
		"\u01b2\3\2\2\2\u01b2\u0088\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b4\u01b5\7-"+
		"\2\2\u01b5\u008a\3\2\2\2\u01b6\u01b7\7,\2\2\u01b7\u008c\3\2\2\2\u01b8"+
		"\u01b9\7\61\2\2\u01b9\u008e\3\2\2\2\u01ba\u01bb\7/\2\2\u01bb\u0090\3\2"+
		"\2\2\u01bc\u01bd\7,\2\2\u01bd\u01c0\7,\2\2\u01be\u01c0\7`\2\2\u01bf\u01bc"+
		"\3\2\2\2\u01bf\u01be\3\2\2\2\u01c0\u0092\3\2\2\2\u01c1\u01c2\7*\2\2\u01c2"+
		"\u0094\3\2\2\2\u01c3\u01c4\7+\2\2\u01c4\u0096\3\2\2\2\u01c5\u01c6\7?\2"+
		"\2\u01c6\u0098\3\2\2\2\u01c7\u01c8\7=\2\2\u01c8\u009a\3\2\2\2\u01c9\u01cb"+
		"\7\17\2\2\u01ca\u01c9\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb\u01cc\3\2\2\2"+
		"\u01cc\u01cd\7\f\2\2\u01cd\u009c\3\2\2\2\u01ce\u01cf\t \2\2\u01cf\u01d0"+
		"\3\2\2\2\u01d0\u01d1\bO\2\2\u01d1\u009e\3\2\2\2\20\2\u00d8\u00de\u00e0"+
		"\u00e6\u019f\u01a2\u01a7\u01aa\u01ac\u01af\u01b1\u01bf\u01ca\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}