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
	| assignMatrix (NEWLINE | END)
	| m=matrixMult (NEWLINE | END)					
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
	: m=mathFunction								
	| evalUserFunc
	;

mathFunction
	: ABS '(' e=expr ')'							
	| ACOS '(' e=expr ')'							
	| ASIN '(' e=expr ')'							
	| ATAN '(' e=expr ')'							
	| CBRT '(' e=expr ')'							
	| CEIL '(' e=expr ')'							
	| COS '(' e=expr ')'							
	| COSH '(' e=expr ')'							
	| EXP '(' e=expr ')'							
	| EXPM1 '(' e=expr ')'							
	| FLOOR '(' e=expr ')'							
	| (LN| LOGE) '(' e=expr ')'						
	| (LOG | LOG10) '(' e=expr ')'					
	| (LOG2 | LD | LB) '(' e=expr ')'				
	| a=max											
	| i=min											
	| POWFUNC '('e1=expr','e2=expr')'				
	| RINT '(' e=expr ')'							
	| SIGNUM '(' e=expr ')'							
	| SIN '(' e=expr ')'							
	| SINH '(' e=expr ')'							
	| SQRT '(' e=expr ')'							
	| TAN '(' e=expr ')'							
	| TANH '(' e=expr ')'							
	;

min 
	: MIN '(' expr (',' expr)* ')'
	;
	
max 
	: MAX '(' expr (',' expr)* ')'
	;
	
evalUserFunc
	: i=ID '(' p=evalParams ')'
	;
	
evalParams
	: //p=params
	expr(','expr)*
	//SCI_NO(','SCI_NO)*
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
	
matrixMult
	: a=matrix '*' b=matrix
	;
	
assignMatrix
	: i=ID ASSIGN m=matrix
	;
	
vector
	: '{' SCI_NO(','SCI_NO)* '}';
matrix
	: '{' vector(','vector)* '}';
	
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

// Token

// Math Functions

ABS:			A B S;
ACOS:			A C O S;
ASIN:			A S I N;
ATAN:			A T A N;
ATAN2:			A T A N '2';
CBRT:			C B R T;
CEIL:			C E I L;
COS:			C O S;
COSH:			C O S H;
EXP:			E X P;
EXPM1:			E X P M '1';
FLOOR:			F L O O R;
FLOORDIV:		F L O O R D I V;
FLOORMOD:		F L O O R M O D;
HYPOD:			H Y P O D;
LN:				L N;
LOG:			L O G;
LOGE:			L O G E;
LOG10:			L O G '10';
LOG2:			L O G '2';
LB:				L B;
LD:				L D;
LOG1P:			L O G '1' P;
MAX:			M A X;
MIN:			M I N;
POWFUNC:		P O W;
RINT:			R I N T;
ROUND:			R O U N D;
SCALB:			S C A L B;
SIGNUM:			S I G N U M;
SIN:			S I N;
SINH:			S I N H;
SQRT:			S Q R T;
TAN:			T A N;
TANH:			T A N H;

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