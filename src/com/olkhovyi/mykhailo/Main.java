package com.olkhovyi.mykhailo;

import com.olkhovyi.mykhailo.ast.Statement;
import com.olkhovyi.mykhailo.lib.Variables;
import com.olkhovyi.mykhailo.parser.Lexer;
import com.olkhovyi.mykhailo.parser.Parser;
import com.olkhovyi.mykhailo.parser.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //final String input = "змінна_а = 2 + 2";

        final String input = new String(Files.readAllBytes(Paths.get("code.txt")), "UTF-8");
        final List<Token> tokens = new Lexer(input).tokenize();

//        for (Token token : tokens) {
//            System.out.println(token);
//        }
//
//        System.out.println("--------------------------------");
//
       final List<Statement> statements = new Parser(tokens).parse();
//        for (Statement statement : statements) {
//            System.out.println(statement);
//        }
//
//        System.out.println("--------------------------------");

        for(Statement statement : statements) {
            statement.execute();
        }

        //System.out.printf("%s = %f\n", "змінна_а", Variables.get("змінна_а"));
    }
}
