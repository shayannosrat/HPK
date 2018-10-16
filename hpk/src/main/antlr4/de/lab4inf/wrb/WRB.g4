grammar WRB;

options{
	language = Java;
}

@parser::members{
	private java.util.HashMap<String, Double> memory = new java.util.HashMap<String, Double>();
}

//
// PARSER RULES
//

run returns [double v]
	: s=statement+								{$v = $s.v;}
	;

statement returns [double v]
	: exp=expr (NEWLINE | END)					{$v = $exp.value;}
	| assign (NEWLINE | END)							
	| NEWLINE
	;

expr returns [double value]
	: n=NO 										{$value = Double.parseDouble($n.text);}
	| i=ID										{$value = memory.get($i.text);}			
	| BRACKET_BEGIN exp=expr BRACKET_END 		{$value = $exp.value;}
	| mul1=expr MUL mul2=expr					{$value = $mul1.value * $mul2.value;}
	| div1=expr DIV div2=expr					{$value = $div1.value / $div2.value;}	
	| sum1=expr ADD sum2=expr					{$value = $sum1.value + $sum2.value;}
	| sub1=expr SUB sub2=expr					{$value = $sub1.value - $sub2.value;}
	;
	
assign
	: i=ID ASSIGN exp=expr						{memory.put($i.text, $exp.value);}
	| i=ID ASSIGN j=ID							{memory.put($i.text, memory.get($j.text));}
	;

//	
// LEXER RULES
//

NO:				'-'?[0-9]+('.'[0-9]+)?;

ID:				([A-Z] | [a-z] | '_')+([A-Z] | [a-z] | [0-9] | '_')*;

ADD:			'+';
MUL:			'*';
DIV:			'/';
SUB:			'-';

BRACKET_BEGIN:	'(';
BRACKET_END:	')';

ASSIGN:			'=';

END:			';';

NEWLINE:		'\r'? '\n' ;
WS:				(' ' | '\t') ->skip;