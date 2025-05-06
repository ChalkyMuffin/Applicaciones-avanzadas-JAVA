grammar varsTest;

/* Estructura general del programa */
prog    : statement;

vars_decl : 'var' ID (',' ID)* ':' type ';' ;

funcs_decl : 'void' ID '(' params? ')' (':' type)?
             vars_decl*
             body ;

main_body : 'main' body ;

body     : '{' (vars_decl | statement)* '}' ;

statement: assign ';'          # assignStat
        | condition           # condStat
        | cycle               # cycleStat
        | f_call ';'          # funcCallStat
        | print ';'           # printStat
        | ';'                 # emptyStat
        ;

assign   : ID '=' expression ;

condition: 'if' '(' expression ')' statement ('else' statement)? ;

cycle    : 'while' '(' expression ')' 'do' body ;

f_call   : ID '(' (expression (',' expression)*)? ')' ;

print    : 'Print' '(' expression ')' ;

expression
        : expression op=('*'|'/') expression  # MulDiv
        | expression op=('+'|'-') expression  # AddSub
        | expression '>' expression           # Greater
        | expression '<' expression           # Less
        | expression '==' expression          # Equal
        | cte                                 # const
        | ID                                  # id
        | '(' expression ')'                 # parens
        ;

cte     : INT_NUM      # intConst
        | FLOAT_NUM    # floatConst
        ;

params  : param (',' param)* ;
param   : ID ':' type ;

type    : 'int' | 'float' ;

/* Tokens */
INT_NUM : [0-9]+ ;
FLOAT_NUM : [0-9]+ '.' [0-9]+ ;
ID      : [a-zA-Z][a-zA-Z0-9]* ;
WS      : [ \t\r\n]+ -> skip ;
COMMENT : '//' .*? '\n' -> skip ;