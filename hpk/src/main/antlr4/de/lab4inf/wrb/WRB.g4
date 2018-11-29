grammar WRB;

options{
	language = Java;
}

//
// PARSER RULES
//

run
	: s=statement+
	;

statement 
	: exp=expr (NEWLINE | END)																
	| a=assignVar (NEWLINE | END)					
	| f=assignFunc (NEWLINE | END)					
	;

expr 
	: t=term										
	| t1=expr a=exprAdd								
	| t1=expr s=exprSub								
	;

exprAdd 
	: ADD t=term									
	;
	
exprSub 
	: SUB t=term									
	;
	
term 
	: f=factor									
	| f1=term m=termMul								
	| f1=term d=termDiv								
	;

termMul
	: MUL f=factor									
	;
	
termDiv 
	: DIV f=factor									
	;
	
factor
	: a=signedAtom									
	| b=signedAtom p=pow							
	;

pow
	: POW factor							
 	;

signedAtom
   	: ADD a=atom									
   	| SUB a=atom									
   	| a=atom										
	;

atom
   	: n=SCI_NO										
   	| '(' e=expr ')'								
   	| f=function									
   	| i=ID											
   	;	
   	
function
	:	a=max											
	|	i=min	
	|	POWFUNC '('e1=expr','e2=expr')' 
	|	id=ID '(' e=expr(','expr)* ')'	
	;


min  
	: MIN '(' expr (',' expr)* ')'
	;
	
max 
	: MAX '(' expr (',' expr)* ')'
	;


assignFunc
	: i=ID '(' p=params ')' ASSIGN e=expr 					
	;

params 
	: ID(','ID)*
	;
	
userFunction:;

assignVar 
	: i=ID ASSIGN exp=expr							
	| i=ID ASSIGN j=ID								
	;
	
//	
// LEXER RULES
//

// Fragments 

fragment A : [aA]; // match either an 'a' or 'A'
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

fragment NUMBER:		[0-9]+('.'[0-9]+)?;	
fragment LAZY_FLOAT: 	'.'[0-9]+;
 
POWFUNC:		P O W;
MAX:			M A X;
MIN:			M I N;


SCI_NO:			(NUMBER (E ('+' | '-') NUMBER)?) | LAZY_FLOAT;

DIGIT:			[0-9]+;

ID:				([A-Z] | [a-z] | '_')+([A-Z] | [a-z] | [0-9] | '_')*;

ADD:			'+';
MUL:			'*';
DIV:			'/';
SUB:			'-';
POW:			'**' | '^';

BRACKET_BEGIN:	'(';
BRACKET_END:	')';

ASSIGN:			'=';

END:			';';

NEWLINE:		'\r'? '\n' ;
WS:				(' ' | '\t') ->skip;