package com.olkhovyi.mykhailo.parser;

import com.olkhovyi.mykhailo.ast.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final Token EOF = new Token(TokenType.EOF, null);

    private List<Token> tokens;
    private int pos;
    private final int size;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        size = tokens.size();
    }

    public List<Statement> parse () {
        final List<Statement> result = new ArrayList<>();
        while(!match(TokenType.EOF)) {
            result.add(statement());
        }
        return result;
    }

    private Statement statement() {
        if(match(TokenType.PRINT)) {
            return new PrintStatement(expression());
        }
        return assignmentStatement();
    }

    private Statement assignmentStatement() {
        final Token current = get(0);
        if(match(TokenType.WORD) && get(0).getType() == TokenType.EQ) {
            final String variable = current.getText();
            consume(TokenType.EQ);
            return new AssignmentStatement(variable, expression());
        }
        throw new RuntimeException("Невідомий оператор");
    }

    private Expression expression() {
        return additive();
    }
    private Expression additive() {
        Expression result = multiplicative();

        while(true) {
            if (match(TokenType.PLUS)) {
                result = new BinaryExpression('+', result, additive());
                continue;
            }
            if (match(TokenType.MINUS)) {
                result = new BinaryExpression('-', result, additive());
                continue;
            }
            break;
        }
        return result;
    }

    private Expression multiplicative() {
        Expression result = unary();

        while(true) {
            if (match(TokenType.STAR)) {
                result = new BinaryExpression('*', result, unary());
                continue;
            }
            if (match(TokenType.SLASH)) {
                result = new BinaryExpression('/', result, unary());
                continue;
            }
            break;
        }
        return result;
    }

    private Expression unary() {
        if(match(TokenType.MINUS)) {
            return new UnaryExpression('-', primary());
        }
        return primary();

    }

    private Expression primary() {
        final Token current = get(0);

        if (match(TokenType.NUMBER)) {
            return new ValueExpression(Double.parseDouble(current.getText()));
        }
        if (match(TokenType.HEX)) {
            return new ValueExpression(Long.parseLong(current.getText(), 16));
        }
        if (match(TokenType.WORD)) {
            return new VariableExpression(current.getText());
        }
        if (match(TokenType.TEXT)) {
            return new ValueExpression(current.getText());
        }
        if (match(TokenType.LPAREN)) {
            Expression result =  expression();
            match(TokenType.RPAREN);
            return result;
        }
        throw new RuntimeException("Невідомий вираз");
    }

    private Token consume(TokenType type) {
        final Token current = get(0);

        if (type != current.getType()) {
            throw new RuntimeException("Токен " + current.getType() + " не співпадає з " + type);
        }
        pos++;
        return current;
    }

    private boolean match(TokenType type) {
        final Token current = get(0);

        if (type != current.getType()) {
            return false;
        }
        pos++;
        return true;
    }

    private Token get(int relativePosition) {
        final int position = pos + relativePosition;
        if (position >= size) return EOF;
        return tokens.get(position);
    }
}
