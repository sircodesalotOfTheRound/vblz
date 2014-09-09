package com.verba.language.ast;

import com.javalinq.implementations.QList;
import com.javalinq.interfaces.QIterable;
import com.verba.language.expressions.VerbaExpression;

import java.io.Serializable;
import java.util.Iterator;

/**
 * Flattens a tree of expressions into a QList.
 */
public class VerbaASTNodeCollector implements Serializable, QIterable<VerbaExpression> {
    private final QList<VerbaExpression> expressions;

    public VerbaASTNodeCollector(VerbaExpression root) {
        this.expressions = collect(root);
    }

    private QList<VerbaExpression> collect(VerbaExpression root) {
        QList<VerbaExpression> expressions = new QList<>();
        VerbaStatementAndDeclarationVisitor visitor
            = new VerbaStatementAndDeclarationVisitor(root, expressions::add);

        return expressions;
    }

    public QIterable<VerbaExpression> expressions() {
        return this.expressions;
    }

    @Override
    public Iterator<VerbaExpression> iterator() { return expressions.iterator(); }
}
