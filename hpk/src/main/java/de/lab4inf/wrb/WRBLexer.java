// Generated from de/lab4inf/wrb/WRB.g4 by ANTLR 4.7
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
		T__0=1, POWFUNC=2, MAX=3, MIN=4, SCI_NO=5, DIGIT=6, ID=7, ADD=8, MUL=9, 
		DIV=10, SUB=11, POW=12, BRACKET_BEGIN=13, BRACKET_END=14, ASSIGN=15, END=16, 
		NEWLINE=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
		"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "NUMBER", 
		"LAZY_FLOAT", "POWFUNC", "MAX", "MIN", "SCI_NO", "DIGIT", "ID", "ADD", 
		"MUL", "DIV", "SUB", "POW", "BRACKET_BEGIN", "BRACKET_END", "ASSIGN", 
		"END", "NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", null, null, null, null, null, null, "'+'", "'*'", "'/'", 
		"'-'", null, "'('", "')'", "'='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "POWFUNC", "MAX", "MIN", "SCI_NO", "DIGIT", "ID", "ADD", "MUL", 
		"DIV", "SUB", "POW", "BRACKET_BEGIN", "BRACKET_END", "ASSIGN", "END", 
		"NEWLINE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00ec\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\6\35\u0097\n\35\r\35\16\35\u0098\3\35\3\35\6\35\u009d\n\35\r\35\16\35"+
		"\u009e\5\35\u00a1\n\35\3\36\3\36\6\36\u00a5\n\36\r\36\16\36\u00a6\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\5\"\u00ba"+
		"\n\"\3\"\5\"\u00bd\n\"\3#\6#\u00c0\n#\r#\16#\u00c1\3$\6$\u00c5\n$\r$\16"+
		"$\u00c6\3$\7$\u00ca\n$\f$\16$\u00cd\13$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3"+
		")\3)\5)\u00da\n)\3*\3*\3+\3+\3,\3,\3-\3-\3.\5.\u00e5\n.\3.\3.\3/\3/\3"+
		"/\3/\2\2\60\3\3\5\2\7\2\t\2\13\2\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33"+
		"\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\4?\5"+
		"A\6C\7E\bG\tI\nK\13M\fO\rQ\16S\17U\20W\21Y\22[\23]\24\3\2!\4\2CCcc\4\2"+
		"DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4"+
		"\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUu"+
		"u\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62;\4"+
		"\2--//\5\2C\\aac|\6\2\62;C\\aac|\4\2\13\13\"\"\2\u00da\2\3\3\2\2\2\2="+
		"\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2"+
		"\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2"+
		"\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2\2\7c"+
		"\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23"+
		"o\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31u\3\2\2\2\33w\3\2\2\2\35y\3\2\2\2"+
		"\37{\3\2\2\2!}\3\2\2\2#\177\3\2\2\2%\u0081\3\2\2\2\'\u0083\3\2\2\2)\u0085"+
		"\3\2\2\2+\u0087\3\2\2\2-\u0089\3\2\2\2/\u008b\3\2\2\2\61\u008d\3\2\2\2"+
		"\63\u008f\3\2\2\2\65\u0091\3\2\2\2\67\u0093\3\2\2\29\u0096\3\2\2\2;\u00a2"+
		"\3\2\2\2=\u00a8\3\2\2\2?\u00ac\3\2\2\2A\u00b0\3\2\2\2C\u00bc\3\2\2\2E"+
		"\u00bf\3\2\2\2G\u00c4\3\2\2\2I\u00ce\3\2\2\2K\u00d0\3\2\2\2M\u00d2\3\2"+
		"\2\2O\u00d4\3\2\2\2Q\u00d9\3\2\2\2S\u00db\3\2\2\2U\u00dd\3\2\2\2W\u00df"+
		"\3\2\2\2Y\u00e1\3\2\2\2[\u00e4\3\2\2\2]\u00e8\3\2\2\2_`\7.\2\2`\4\3\2"+
		"\2\2ab\t\2\2\2b\6\3\2\2\2cd\t\3\2\2d\b\3\2\2\2ef\t\4\2\2f\n\3\2\2\2gh"+
		"\t\5\2\2h\f\3\2\2\2ij\t\6\2\2j\16\3\2\2\2kl\t\7\2\2l\20\3\2\2\2mn\t\b"+
		"\2\2n\22\3\2\2\2op\t\t\2\2p\24\3\2\2\2qr\t\n\2\2r\26\3\2\2\2st\t\13\2"+
		"\2t\30\3\2\2\2uv\t\f\2\2v\32\3\2\2\2wx\t\r\2\2x\34\3\2\2\2yz\t\16\2\2"+
		"z\36\3\2\2\2{|\t\17\2\2| \3\2\2\2}~\t\20\2\2~\"\3\2\2\2\177\u0080\t\21"+
		"\2\2\u0080$\3\2\2\2\u0081\u0082\t\22\2\2\u0082&\3\2\2\2\u0083\u0084\t"+
		"\23\2\2\u0084(\3\2\2\2\u0085\u0086\t\24\2\2\u0086*\3\2\2\2\u0087\u0088"+
		"\t\25\2\2\u0088,\3\2\2\2\u0089\u008a\t\26\2\2\u008a.\3\2\2\2\u008b\u008c"+
		"\t\27\2\2\u008c\60\3\2\2\2\u008d\u008e\t\30\2\2\u008e\62\3\2\2\2\u008f"+
		"\u0090\t\31\2\2\u0090\64\3\2\2\2\u0091\u0092\t\32\2\2\u0092\66\3\2\2\2"+
		"\u0093\u0094\t\33\2\2\u00948\3\2\2\2\u0095\u0097\t\34\2\2\u0096\u0095"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u00a0\3\2\2\2\u009a\u009c\7\60\2\2\u009b\u009d\t\34\2\2\u009c\u009b\3"+
		"\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a1\3\2\2\2\u00a0\u009a\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1:\3\2\2\2"+
		"\u00a2\u00a4\7\60\2\2\u00a3\u00a5\t\34\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a6"+
		"\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7<\3\2\2\2\u00a8"+
		"\u00a9\5#\22\2\u00a9\u00aa\5!\21\2\u00aa\u00ab\5\61\31\2\u00ab>\3\2\2"+
		"\2\u00ac\u00ad\5\35\17\2\u00ad\u00ae\5\5\3\2\u00ae\u00af\5\63\32\2\u00af"+
		"@\3\2\2\2\u00b0\u00b1\5\35\17\2\u00b1\u00b2\5\25\13\2\u00b2\u00b3\5\37"+
		"\20\2\u00b3B\3\2\2\2\u00b4\u00b9\59\35\2\u00b5\u00b6\5\r\7\2\u00b6\u00b7"+
		"\t\35\2\2\u00b7\u00b8\59\35\2\u00b8\u00ba\3\2\2\2\u00b9\u00b5\3\2\2\2"+
		"\u00b9\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00bd\5;\36\2\u00bc\u00b4"+
		"\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bdD\3\2\2\2\u00be\u00c0\t\34\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2F\3\2\2\2\u00c3\u00c5\t\36\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00cb\3\2\2\2\u00c8"+
		"\u00ca\t\37\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3"+
		"\2\2\2\u00cb\u00cc\3\2\2\2\u00ccH\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf"+
		"\7-\2\2\u00cfJ\3\2\2\2\u00d0\u00d1\7,\2\2\u00d1L\3\2\2\2\u00d2\u00d3\7"+
		"\61\2\2\u00d3N\3\2\2\2\u00d4\u00d5\7/\2\2\u00d5P\3\2\2\2\u00d6\u00d7\7"+
		",\2\2\u00d7\u00da\7,\2\2\u00d8\u00da\7`\2\2\u00d9\u00d6\3\2\2\2\u00d9"+
		"\u00d8\3\2\2\2\u00daR\3\2\2\2\u00db\u00dc\7*\2\2\u00dcT\3\2\2\2\u00dd"+
		"\u00de\7+\2\2\u00deV\3\2\2\2\u00df\u00e0\7?\2\2\u00e0X\3\2\2\2\u00e1\u00e2"+
		"\7=\2\2\u00e2Z\3\2\2\2\u00e3\u00e5\7\17\2\2\u00e4\u00e3\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\f\2\2\u00e7\\\3\2\2\2"+
		"\u00e8\u00e9\t \2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\b/\2\2\u00eb^\3\2"+
		"\2\2\20\2\u0098\u009e\u00a0\u00a6\u00b9\u00bc\u00c1\u00c4\u00c6\u00c9"+
		"\u00cb\u00d9\u00e4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}