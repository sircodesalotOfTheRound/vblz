package com.verba.language.test.lexing.tokens.identifiers;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class KeywordToken extends IdentifierToken {
  private static final Set<String> keywords = ((Supplier<Set<String>>) () -> {
    String[] basicKeywords = new String[]{
      "public", "private", "protect", "internal",
      "static", "operator", "override", "segment", "virtual", "injected",
      "to", "in", "withns", "trait",
      "options", "option", "get", "set", "inline",
      "namespace", "class", "abstract", "extend", "sql", "native",
      "signature", "fn", "task", "template", "fork", "event", "proxy",
      "val", "muta", "yield",
      "new", "inject",
      "return",
      "if", "then", "elseif", "else", "unless", "await",
      "until", "for", "while", "do", "break", "continue", "parallel",
      "isa", "hasa",
      "throw", "try", "catch", "finally",
      "this", "base",
      "none", "some", "is", "isnt",
      "def",
      "match", "case",
      "true", "false",
      "sync",

      // System types
      "byte", "numeric", "dynamic",
      "int8", "int16", "int32", "int64",
      "uint8", "uint16", "uint32", "uint64",
      "char", "string", "unit", "object",
      "sensitive"
    };

    Set<String> keywordSet = new HashSet<String>();
    for (String keyword : basicKeywords) {
      keywordSet.add(keyword);
    }

    return keywordSet;
  }).get();

  public KeywordToken(String representation) {
    super(representation);
  }

  @Override
  public String toString() {
    return super.representation;
  }

  public static boolean isKeyword(String text) {
    return KeywordToken.keywords.contains(text);
  }
}

