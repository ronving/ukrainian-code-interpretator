package com.olkhovyi.mykhailo;

import com.olkhovyi.mykhailo.ast.Expression;
import com.olkhovyi.mykhailo.parser.Lexer;
import com.olkhovyi.mykhailo.parser.Parser;
import com.olkhovyi.mykhailo.parser.Token;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String input = "(2+2)*#0F";
        final List<Token> tokens = new Lexer(input).tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }

        final List<Expression> expressions = new Parser(tokens).parse();
        for (Expression exp : expressions) {
            System.out.println(exp + " = " + exp.eval());
        }
    }
}
