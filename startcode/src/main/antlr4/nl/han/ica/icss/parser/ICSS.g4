grammar ICSS;

//--- LEXER: ---

// IF support:
IF: 'if';
ELSE: 'else';
BOX_BRACKET_OPEN: '[';
BOX_BRACKET_CLOSE: ']';


//Literals
TRUE: 'TRUE';
FALSE: 'FALSE';
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;


//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';
SAMEVALUE: '==';
LARGER_THAN: '>';
SMALLER_THAN: '<';




//--- PARSER: ---
stylesheet: variableassignment* stylerule* EOF;

stylerule: selector OPEN_BRACE declaration+ CLOSE_BRACE ;

selector: ID_IDENT | CLASS_IDENT | tag;
declaration: property COLON value SEMICOLON;
property: 'color' | 'background-color' | 'width' | 'height';
value: COLOR | PERCENTAGE | PIXELSIZE | TRUE | FALSE variable;
tag: LOWER_IDENT;
ifclause: IF BOX_BRACKET_OPEN expression BOX_BRACKET_CLOSE OPEN_BRACE body CLOSE_BRACE;
ifelseclause: IF BOX_BRACKET_OPEN expression BOX_BRACKET_CLOSE OPEN_BRACE body CLOSE_BRACE ELSE OPEN_BRACE body CLOSE_BRACE;
body: stylerule+;
expression: TRUE | FALSE | comparison;
comparison: variable comparisonoperation variable;
comparisonoperation: SAMEVALUE | LARGER_THAN | SMALLER_THAN;
variable: LOWER_IDENT | CAPITAL_IDENT;
variableassignment: variable ASSIGNMENT_OPERATOR value;


