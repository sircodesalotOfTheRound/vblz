package com.verba.language.expressions.categories;

import com.verba.language.expressions.VerbaExpression;
import com.verba.language.expressions.backtracking.BacktrackRuleSet;
import com.verba.language.expressions.backtracking.rules.LiteralExpressionRule;
import com.verba.language.expressions.backtracking.rules.NamedValueExpressionBacktrackRule;
import com.verba.language.parsing.Lexer;

/**
 * Created by sircodesalot on 14-5-21.
 */
public interface MarkupRvalueExpression {
  static final BacktrackRuleSet<MarkupRvalueExpression> rules
    = new BacktrackRuleSet<MarkupRvalueExpression>()
    .addRule(new LiteralExpressionRule())
    .addRule(new NamedValueExpressionBacktrackRule());

  public static MarkupRvalueExpression read(VerbaExpression parent, Lexer lexer) {
    return rules.resolve(parent, lexer);
  }
}
