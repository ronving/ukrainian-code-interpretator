package com.olkhovyi.mykhailo.parser;

public enum TokenType {

    // types
    NUMBER,
    HEX,
    WORD,
    TEXT,

    // keywords
    PRINT,
    IF,
    ELSE,

    // operations
    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    LT,
    GT,

    LPAREN,
    RPAREN,

    EOF
}
