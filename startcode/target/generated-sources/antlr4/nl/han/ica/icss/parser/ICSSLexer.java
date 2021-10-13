// Generated from nl\han\ica\icss\parser\ICSS.g4 by ANTLR 4.9.1
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ICSSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, IF=5, ELSE=6, BOX_BRACKET_OPEN=7, BOX_BRACKET_CLOSE=8, 
		TRUE=9, FALSE=10, PIXELSIZE=11, PERCENTAGE=12, SCALAR=13, COLOR=14, ID_IDENT=15, 
		CLASS_IDENT=16, LOWER_IDENT=17, CAPITAL_IDENT=18, WS=19, OPEN_BRACE=20, 
		CLOSE_BRACE=21, SEMICOLON=22, COLON=23, PLUS=24, MIN=25, MUL=26, ASSIGNMENT_OPERATOR=27, 
		SAMEVALUE=28, LARGER_THAN=29, SMALLER_THAN=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", 
			"TRUE", "FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", 
			"CLASS_IDENT", "LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", 
			"SEMICOLON", "COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR", "SAMEVALUE", 
			"LARGER_THAN", "SMALLER_THAN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'color'", "'background-color'", "'width'", "'height'", "'if'", 
			"'else'", "'['", "']'", "'TRUE'", "'FALSE'", null, null, null, null, 
			null, null, null, null, null, "'{'", "'}'", "';'", "':'", "'+'", "'-'", 
			"'*'", "':='", "'=='", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "IF", "ELSE", "BOX_BRACKET_OPEN", "BOX_BRACKET_CLOSE", 
			"TRUE", "FALSE", "PIXELSIZE", "PERCENTAGE", "SCALAR", "COLOR", "ID_IDENT", 
			"CLASS_IDENT", "LOWER_IDENT", "CAPITAL_IDENT", "WS", "OPEN_BRACE", "CLOSE_BRACE", 
			"SEMICOLON", "COLON", "PLUS", "MIN", "MUL", "ASSIGNMENT_OPERATOR", "SAMEVALUE", 
			"LARGER_THAN", "SMALLER_THAN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public ICSSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00cf\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\6\f|\n\f\r\f\16\f}\3\f\3\f\3\f\3\r\6\r\u0084"+
		"\n\r\r\r\16\r\u0085\3\r\3\r\3\16\6\16\u008b\n\16\r\16\16\16\u008c\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\6\20\u0099\n\20\r\20\16"+
		"\20\u009a\3\21\3\21\6\21\u009f\n\21\r\21\16\21\u00a0\3\22\3\22\7\22\u00a5"+
		"\n\22\f\22\16\22\u00a8\13\22\3\23\3\23\7\23\u00ac\n\23\f\23\16\23\u00af"+
		"\13\23\3\24\6\24\u00b2\n\24\r\24\16\24\u00b3\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\36\3\36\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= \3\2\t\3\2\62;\4\2\62;ch\5\2"+
		"//\62;c|\3\2c|\3\2C\\\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u00d6\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\3?\3\2\2\2\5E\3\2\2\2\7V\3\2\2\2\t\\\3\2\2\2\13c\3\2\2\2\r"+
		"f\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25t\3\2\2\2\27{\3\2\2\2"+
		"\31\u0083\3\2\2\2\33\u008a\3\2\2\2\35\u008e\3\2\2\2\37\u0096\3\2\2\2!"+
		"\u009c\3\2\2\2#\u00a2\3\2\2\2%\u00a9\3\2\2\2\'\u00b1\3\2\2\2)\u00b7\3"+
		"\2\2\2+\u00b9\3\2\2\2-\u00bb\3\2\2\2/\u00bd\3\2\2\2\61\u00bf\3\2\2\2\63"+
		"\u00c1\3\2\2\2\65\u00c3\3\2\2\2\67\u00c5\3\2\2\29\u00c8\3\2\2\2;\u00cb"+
		"\3\2\2\2=\u00cd\3\2\2\2?@\7e\2\2@A\7q\2\2AB\7n\2\2BC\7q\2\2CD\7t\2\2D"+
		"\4\3\2\2\2EF\7d\2\2FG\7c\2\2GH\7e\2\2HI\7m\2\2IJ\7i\2\2JK\7t\2\2KL\7q"+
		"\2\2LM\7w\2\2MN\7p\2\2NO\7f\2\2OP\7/\2\2PQ\7e\2\2QR\7q\2\2RS\7n\2\2ST"+
		"\7q\2\2TU\7t\2\2U\6\3\2\2\2VW\7y\2\2WX\7k\2\2XY\7f\2\2YZ\7v\2\2Z[\7j\2"+
		"\2[\b\3\2\2\2\\]\7j\2\2]^\7g\2\2^_\7k\2\2_`\7i\2\2`a\7j\2\2ab\7v\2\2b"+
		"\n\3\2\2\2cd\7k\2\2de\7h\2\2e\f\3\2\2\2fg\7g\2\2gh\7n\2\2hi\7u\2\2ij\7"+
		"g\2\2j\16\3\2\2\2kl\7]\2\2l\20\3\2\2\2mn\7_\2\2n\22\3\2\2\2op\7V\2\2p"+
		"q\7T\2\2qr\7W\2\2rs\7G\2\2s\24\3\2\2\2tu\7H\2\2uv\7C\2\2vw\7N\2\2wx\7"+
		"U\2\2xy\7G\2\2y\26\3\2\2\2z|\t\2\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3"+
		"\2\2\2~\177\3\2\2\2\177\u0080\7r\2\2\u0080\u0081\7z\2\2\u0081\30\3\2\2"+
		"\2\u0082\u0084\t\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7\'\2\2\u0088"+
		"\32\3\2\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2"+
		"\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\34\3\2\2\2\u008e\u008f"+
		"\7%\2\2\u008f\u0090\t\3\2\2\u0090\u0091\t\3\2\2\u0091\u0092\t\3\2\2\u0092"+
		"\u0093\t\3\2\2\u0093\u0094\t\3\2\2\u0094\u0095\t\3\2\2\u0095\36\3\2\2"+
		"\2\u0096\u0098\7%\2\2\u0097\u0099\t\4\2\2\u0098\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b \3\2\2\2\u009c"+
		"\u009e\7\60\2\2\u009d\u009f\t\4\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3"+
		"\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\"\3\2\2\2\u00a2\u00a6"+
		"\t\5\2\2\u00a3\u00a5\t\4\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7$\3\2\2\2\u00a8\u00a6\3\2\2\2"+
		"\u00a9\u00ad\t\6\2\2\u00aa\u00ac\t\7\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae&\3\2\2\2\u00af"+
		"\u00ad\3\2\2\2\u00b0\u00b2\t\b\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b6\b\24\2\2\u00b6(\3\2\2\2\u00b7\u00b8\7}\2\2\u00b8*\3\2\2\2\u00b9"+
		"\u00ba\7\177\2\2\u00ba,\3\2\2\2\u00bb\u00bc\7=\2\2\u00bc.\3\2\2\2\u00bd"+
		"\u00be\7<\2\2\u00be\60\3\2\2\2\u00bf\u00c0\7-\2\2\u00c0\62\3\2\2\2\u00c1"+
		"\u00c2\7/\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\66\3\2\2\2\u00c5"+
		"\u00c6\7<\2\2\u00c6\u00c7\7?\2\2\u00c78\3\2\2\2\u00c8\u00c9\7?\2\2\u00c9"+
		"\u00ca\7?\2\2\u00ca:\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc<\3\2\2\2\u00cd\u00ce"+
		"\7>\2\2\u00ce>\3\2\2\2\13\2}\u0085\u008c\u009a\u00a0\u00a6\u00ad\u00b3"+
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