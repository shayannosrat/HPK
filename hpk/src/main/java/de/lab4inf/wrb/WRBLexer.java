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
		T__0=1, T__1=2, T__2=3, POWFUNC=4, MAX=5, MIN=6, SCI_NO=7, DIGIT=8, ID=9, 
		ADD=10, MUL=11, DIV=12, SUB=13, POW=14, BRACKET_BEGIN=15, BRACKET_END=16, 
		ASSIGN=17, END=18, NEWLINE=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", 
		"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
		"Y", "Z", "NUMBER", "LAZY_FLOAT", "POWFUNC", "MAX", "MIN", "SCI_NO", "DIGIT", 
		"ID", "ADD", "MUL", "DIV", "SUB", "POW", "BRACKET_BEGIN", "BRACKET_END", 
		"ASSIGN", "END", "NEWLINE", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'{'", "'}'", null, null, null, null, null, null, "'+'", 
		"'*'", "'/'", "'-'", null, "'('", "')'", "'='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "POWFUNC", "MAX", "MIN", "SCI_NO", "DIGIT", "ID", 
		"ADD", "MUL", "DIV", "SUB", "POW", "BRACKET_BEGIN", "BRACKET_END", "ASSIGN", 
		"END", "NEWLINE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00f4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\6\37\u009f\n\37\r\37\16\37\u00a0"+
		"\3\37\3\37\6\37\u00a5\n\37\r\37\16\37\u00a6\5\37\u00a9\n\37\3 \3 \6 \u00ad"+
		"\n \r \16 \u00ae\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3"+
		"$\5$\u00c2\n$\3$\5$\u00c5\n$\3%\6%\u00c8\n%\r%\16%\u00c9\3&\6&\u00cd\n"+
		"&\r&\16&\u00ce\3&\7&\u00d2\n&\f&\16&\u00d5\13&\3\'\3\'\3(\3(\3)\3)\3*"+
		"\3*\3+\3+\3+\5+\u00e2\n+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\5\60\u00ed\n\60"+
		"\3\60\3\60\3\61\3\61\3\61\3\61\2\2\62\3\3\5\4\7\5\t\2\13\2\r\2\17\2\21"+
		"\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63"+
		"\2\65\2\67\29\2;\2=\2?\2A\6C\7E\bG\tI\nK\13M\fO\rQ\16S\17U\20W\21Y\22"+
		"[\23]\24_\25a\26\3\2!\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh"+
		"\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2Q"+
		"Qqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4"+
		"\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62;\4\2--//\5\2C\\aac|\6\2\62;C\\aac|\4\2"+
		"\13\13\"\"\2\u00e2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2A\3\2\2\2\2C\3"+
		"\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2"+
		"\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2"+
		"]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5e\3\2\2\2\7g\3\2\2\2\ti\3"+
		"\2\2\2\13k\3\2\2\2\rm\3\2\2\2\17o\3\2\2\2\21q\3\2\2\2\23s\3\2\2\2\25u"+
		"\3\2\2\2\27w\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35}\3\2\2\2\37\177\3\2\2"+
		"\2!\u0081\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u0089"+
		"\3\2\2\2+\u008b\3\2\2\2-\u008d\3\2\2\2/\u008f\3\2\2\2\61\u0091\3\2\2\2"+
		"\63\u0093\3\2\2\2\65\u0095\3\2\2\2\67\u0097\3\2\2\29\u0099\3\2\2\2;\u009b"+
		"\3\2\2\2=\u009e\3\2\2\2?\u00aa\3\2\2\2A\u00b0\3\2\2\2C\u00b4\3\2\2\2E"+
		"\u00b8\3\2\2\2G\u00c4\3\2\2\2I\u00c7\3\2\2\2K\u00cc\3\2\2\2M\u00d6\3\2"+
		"\2\2O\u00d8\3\2\2\2Q\u00da\3\2\2\2S\u00dc\3\2\2\2U\u00e1\3\2\2\2W\u00e3"+
		"\3\2\2\2Y\u00e5\3\2\2\2[\u00e7\3\2\2\2]\u00e9\3\2\2\2_\u00ec\3\2\2\2a"+
		"\u00f0\3\2\2\2cd\7.\2\2d\4\3\2\2\2ef\7}\2\2f\6\3\2\2\2gh\7\177\2\2h\b"+
		"\3\2\2\2ij\t\2\2\2j\n\3\2\2\2kl\t\3\2\2l\f\3\2\2\2mn\t\4\2\2n\16\3\2\2"+
		"\2op\t\5\2\2p\20\3\2\2\2qr\t\6\2\2r\22\3\2\2\2st\t\7\2\2t\24\3\2\2\2u"+
		"v\t\b\2\2v\26\3\2\2\2wx\t\t\2\2x\30\3\2\2\2yz\t\n\2\2z\32\3\2\2\2{|\t"+
		"\13\2\2|\34\3\2\2\2}~\t\f\2\2~\36\3\2\2\2\177\u0080\t\r\2\2\u0080 \3\2"+
		"\2\2\u0081\u0082\t\16\2\2\u0082\"\3\2\2\2\u0083\u0084\t\17\2\2\u0084$"+
		"\3\2\2\2\u0085\u0086\t\20\2\2\u0086&\3\2\2\2\u0087\u0088\t\21\2\2\u0088"+
		"(\3\2\2\2\u0089\u008a\t\22\2\2\u008a*\3\2\2\2\u008b\u008c\t\23\2\2\u008c"+
		",\3\2\2\2\u008d\u008e\t\24\2\2\u008e.\3\2\2\2\u008f\u0090\t\25\2\2\u0090"+
		"\60\3\2\2\2\u0091\u0092\t\26\2\2\u0092\62\3\2\2\2\u0093\u0094\t\27\2\2"+
		"\u0094\64\3\2\2\2\u0095\u0096\t\30\2\2\u0096\66\3\2\2\2\u0097\u0098\t"+
		"\31\2\2\u00988\3\2\2\2\u0099\u009a\t\32\2\2\u009a:\3\2\2\2\u009b\u009c"+
		"\t\33\2\2\u009c<\3\2\2\2\u009d\u009f\t\34\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a8\3\2"+
		"\2\2\u00a2\u00a4\7\60\2\2\u00a3\u00a5\t\34\2\2\u00a4\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2"+
		"\2\2\u00a8\u00a2\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9>\3\2\2\2\u00aa\u00ac"+
		"\7\60\2\2\u00ab\u00ad\t\34\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2"+
		"\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af@\3\2\2\2\u00b0\u00b1\5"+
		"\'\24\2\u00b1\u00b2\5%\23\2\u00b2\u00b3\5\65\33\2\u00b3B\3\2\2\2\u00b4"+
		"\u00b5\5!\21\2\u00b5\u00b6\5\t\5\2\u00b6\u00b7\5\67\34\2\u00b7D\3\2\2"+
		"\2\u00b8\u00b9\5!\21\2\u00b9\u00ba\5\31\r\2\u00ba\u00bb\5#\22\2\u00bb"+
		"F\3\2\2\2\u00bc\u00c1\5=\37\2\u00bd\u00be\5\21\t\2\u00be\u00bf\t\35\2"+
		"\2\u00bf\u00c0\5=\37\2\u00c0\u00c2\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c5\5? \2\u00c4\u00bc\3\2\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5H\3\2\2\2\u00c6\u00c8\t\34\2\2\u00c7\u00c6\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00caJ\3"+
		"\2\2\2\u00cb\u00cd\t\36\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d2\t\37"+
		"\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4L\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7-\2\2\u00d7"+
		"N\3\2\2\2\u00d8\u00d9\7,\2\2\u00d9P\3\2\2\2\u00da\u00db\7\61\2\2\u00db"+
		"R\3\2\2\2\u00dc\u00dd\7/\2\2\u00ddT\3\2\2\2\u00de\u00df\7,\2\2\u00df\u00e2"+
		"\7,\2\2\u00e0\u00e2\7`\2\2\u00e1\u00de\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"V\3\2\2\2\u00e3\u00e4\7*\2\2\u00e4X\3\2\2\2\u00e5\u00e6\7+\2\2\u00e6Z"+
		"\3\2\2\2\u00e7\u00e8\7?\2\2\u00e8\\\3\2\2\2\u00e9\u00ea\7=\2\2\u00ea^"+
		"\3\2\2\2\u00eb\u00ed\7\17\2\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2"+
		"\u00ed\u00ee\3\2\2\2\u00ee\u00ef\7\f\2\2\u00ef`\3\2\2\2\u00f0\u00f1\t"+
		" \2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\b\61\2\2\u00f3b\3\2\2\2\20\2\u00a0"+
		"\u00a6\u00a8\u00ae\u00c1\u00c4\u00c9\u00cc\u00ce\u00d1\u00d3\u00e1\u00ec"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}