// Generated from de/lab4inf/wrb/WRB.g4 by ANTLR 4.7
package de.lab4inf.wrb;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WRBParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NO=1, ID=2, ADD=3, MUL=4, DIV=5, SUB=6, BRACKET_BEGIN=7, BRACKET_END=8, 
		ASSIGN=9, END=10, NEWLINE=11, WS=12;
	public static final int
		RULE_run = 0, RULE_statement = 1, RULE_expr = 2, RULE_assign = 3;
	public static final String[] ruleNames = {
		"run", "statement", "expr", "assign"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'+'", "'*'", "'/'", "'-'", "'('", "')'", "'='", "';'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NO", "ID", "ADD", "MUL", "DIV", "SUB", "BRACKET_BEGIN", "BRACKET_END", 
		"ASSIGN", "END", "NEWLINE", "WS"
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

	@Override
	public String getGrammarFileName() { return "WRB.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private java.util.HashMap<String, Double> memory = new java.util.HashMap<String, Double>();

	public WRBParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public java.util.HashMap<String, Double> getMemory(){
		return this.memory;
	}
	public static class RunContext extends ParserRuleContext {
		public double v;
		public StatementContext s;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public RunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_run; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).enterRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).exitRun(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBVisitor ) return ((WRBVisitor<? extends T>)visitor).visitRun(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RunContext run() throws RecognitionException {
		RunContext _localctx = new RunContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_run);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				((RunContext)_localctx).s = statement();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NO) | (1L << ID) | (1L << BRACKET_BEGIN) | (1L << NEWLINE))) != 0) );
			((RunContext)_localctx).v =  ((RunContext)_localctx).s.v;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public double v;
		public ExprContext exp;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(WRBParser.NEWLINE, 0); }
		public TerminalNode END() { return getToken(WRBParser.END, 0); }
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBVisitor ) return ((WRBVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(15);
				((StatementContext)_localctx).exp = expr(0);
				setState(16);
				_la = _input.LA(1);
				if ( !(_la==END || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((StatementContext)_localctx).v =  ((StatementContext)_localctx).exp.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				assign();
				setState(20);
				_la = _input.LA(1);
				if ( !(_la==END || _la==NEWLINE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(22);
				match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public double value;
		public ExprContext mul1;
		public ExprContext div1;
		public ExprContext sum1;
		public ExprContext sub1;
		public Token n;
		public Token i;
		public ExprContext exp;
		public ExprContext mul2;
		public ExprContext div2;
		public ExprContext sum2;
		public ExprContext sub2;
		public TerminalNode NO() { return getToken(WRBParser.NO, 0); }
		public TerminalNode ID() { return getToken(WRBParser.ID, 0); }
		public TerminalNode BRACKET_BEGIN() { return getToken(WRBParser.BRACKET_BEGIN, 0); }
		public TerminalNode BRACKET_END() { return getToken(WRBParser.BRACKET_END, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(WRBParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(WRBParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(WRBParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(WRBParser.SUB, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBVisitor ) return ((WRBVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NO:
				{
				setState(26);
				((ExprContext)_localctx).n = match(NO);
				((ExprContext)_localctx).value =  Double.parseDouble((((ExprContext)_localctx).n!=null?((ExprContext)_localctx).n.getText():null));
				}
				break;
			case ID:
				{
				setState(28);
				((ExprContext)_localctx).i = match(ID);
				((ExprContext)_localctx).value =  memory.get((((ExprContext)_localctx).i!=null?((ExprContext)_localctx).i.getText():null));
				}
				break;
			case BRACKET_BEGIN:
				{
				setState(30);
				match(BRACKET_BEGIN);
				setState(31);
				((ExprContext)_localctx).exp = expr(0);
				setState(32);
				match(BRACKET_END);
				((ExprContext)_localctx).value =  ((ExprContext)_localctx).exp.value;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(57);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.mul1 = _prevctx;
						_localctx.mul1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(37);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(38);
						match(MUL);
						setState(39);
						((ExprContext)_localctx).mul2 = expr(5);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).mul1.value * ((ExprContext)_localctx).mul2.value;
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.div1 = _prevctx;
						_localctx.div1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(42);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(43);
						match(DIV);
						setState(44);
						((ExprContext)_localctx).div2 = expr(4);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).div1.value / ((ExprContext)_localctx).div2.value;
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.sum1 = _prevctx;
						_localctx.sum1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(47);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(48);
						match(ADD);
						setState(49);
						((ExprContext)_localctx).sum2 = expr(3);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).sum1.value + ((ExprContext)_localctx).sum2.value;
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.sub1 = _prevctx;
						_localctx.sub1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(52);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(53);
						match(SUB);
						setState(54);
						((ExprContext)_localctx).sub2 = expr(2);
						((ExprContext)_localctx).value =  ((ExprContext)_localctx).sub1.value - ((ExprContext)_localctx).sub2.value;
						}
						break;
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public Token i;
		public ExprContext exp;
		public Token j;
		public TerminalNode ASSIGN() { return getToken(WRBParser.ASSIGN, 0); }
		public List<TerminalNode> ID() { return getTokens(WRBParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(WRBParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WRBListener ) ((WRBListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WRBVisitor ) return ((WRBVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assign);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				((AssignContext)_localctx).i = match(ID);
				setState(63);
				match(ASSIGN);
				setState(64);
				((AssignContext)_localctx).exp = expr(0);
				memory.put((((AssignContext)_localctx).i!=null?((AssignContext)_localctx).i.getText():null), ((AssignContext)_localctx).exp.value);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				((AssignContext)_localctx).i = match(ID);
				setState(68);
				match(ASSIGN);
				setState(69);
				((AssignContext)_localctx).j = match(ID);
				memory.put((((AssignContext)_localctx).i!=null?((AssignContext)_localctx).i.getText():null), memory.get((((AssignContext)_localctx).j!=null?((AssignContext)_localctx).j.getText():null)));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16L\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4"+
		"&\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5J\n\5\3\5\2\3\6\6\2\4\6\b\2\3\3\2\f\r\2Q\2\13\3\2\2\2\4\31\3"+
		"\2\2\2\6%\3\2\2\2\bI\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13"+
		"\3\2\2\2\r\16\3\2\2\2\16\17\3\2\2\2\17\20\b\2\1\2\20\3\3\2\2\2\21\22\5"+
		"\6\4\2\22\23\t\2\2\2\23\24\b\3\1\2\24\32\3\2\2\2\25\26\5\b\5\2\26\27\t"+
		"\2\2\2\27\32\3\2\2\2\30\32\7\r\2\2\31\21\3\2\2\2\31\25\3\2\2\2\31\30\3"+
		"\2\2\2\32\5\3\2\2\2\33\34\b\4\1\2\34\35\7\3\2\2\35&\b\4\1\2\36\37\7\4"+
		"\2\2\37&\b\4\1\2 !\7\t\2\2!\"\5\6\4\2\"#\7\n\2\2#$\b\4\1\2$&\3\2\2\2%"+
		"\33\3\2\2\2%\36\3\2\2\2% \3\2\2\2&=\3\2\2\2\'(\f\6\2\2()\7\6\2\2)*\5\6"+
		"\4\7*+\b\4\1\2+<\3\2\2\2,-\f\5\2\2-.\7\7\2\2./\5\6\4\6/\60\b\4\1\2\60"+
		"<\3\2\2\2\61\62\f\4\2\2\62\63\7\5\2\2\63\64\5\6\4\5\64\65\b\4\1\2\65<"+
		"\3\2\2\2\66\67\f\3\2\2\678\7\b\2\289\5\6\4\49:\b\4\1\2:<\3\2\2\2;\'\3"+
		"\2\2\2;,\3\2\2\2;\61\3\2\2\2;\66\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2"+
		">\7\3\2\2\2?=\3\2\2\2@A\7\4\2\2AB\7\13\2\2BC\5\6\4\2CD\b\5\1\2DJ\3\2\2"+
		"\2EF\7\4\2\2FG\7\13\2\2GH\7\4\2\2HJ\b\5\1\2I@\3\2\2\2IE\3\2\2\2J\t\3\2"+
		"\2\2\b\r\31%;=I";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}