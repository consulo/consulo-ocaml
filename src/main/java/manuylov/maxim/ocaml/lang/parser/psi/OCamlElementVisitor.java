/*
 * OCaml Support For IntelliJ Platform.
 * Copyright (C) 2010 Maxim Manuylov
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */

package manuylov.maxim.ocaml.lang.parser.psi;

import javax.annotation.Nonnull;

import com.intellij.psi.PsiElementVisitor;
import manuylov.maxim.ocaml.lang.parser.psi.element.*;

/**
 * @author Maxim.Manuylov
 *         Date: 22.03.2009
 */
public abstract class OCamlElementVisitor extends PsiElementVisitor
{
	public abstract void visitLetBinding(@Nonnull final OCamlLetBinding psiElement);

	public abstract void visitLetStatement(@Nonnull final OCamlLetStatement psiElement);

	public abstract void visitLetExpression(@Nonnull final OCamlLetExpression psiElement);

	public abstract void visitLetClassExpression(@Nonnull final OCamlLetClassExpression psiElement);

	public abstract void visitExternalDefinition(@Nonnull final OCamlExternalDefinition psiElement);

	public abstract void visitExceptionDefinition(@Nonnull final OCamlExceptionDefinition psiElement);

	public abstract void visitOpenDirective(@Nonnull final OCamlOpenDirective psiElement);

	public abstract void visitIncludeDirectiveDefinition(@Nonnull final OCamlIncludeDirectiveDefinition psiElement);

	public abstract void visitExceptionSpecification(@Nonnull final OCamlExceptionSpecification psiElement);

	public abstract void visitIncludeDirectiveSpecification(@Nonnull final OCamlIncludeDirectiveSpecification psiElement);

	public abstract void visitValueSpecification(@Nonnull final OCamlValueSpecification psiElement);

	public abstract void visitExternalDeclaration(@Nonnull final OCamlExternalDeclaration psiElement);

	public abstract void visitTypeDefinition(@Nonnull final OCamlTypeDefinition psiElement);

	public abstract void visitTypeBinding(@Nonnull final OCamlTypeBinding psiElement);

	public abstract void visitTypeParameter(@Nonnull final OCamlTypeParameter psiElement);

	public abstract void visitPlusMinusTypeParameter(@Nonnull final OCamlPlusMinusTypeParameter psiElement);

	public abstract void visitRecordTypeDefinition(@Nonnull final OCamlRecordTypeDefinition psiElement);

	public abstract void visitRecordFieldDefinition(@Nonnull final OCamlRecordFieldDefinition psiElement);

	public abstract void visitRecordFieldInitializationInExpression(@Nonnull final OCamlRecordFieldInitializationInExpression psiElement);

	public abstract void visitVariantTypeDefinition(@Nonnull final OCamlVariantTypeDefinition psiElement);

	public abstract void visitConstructorDefinition(@Nonnull final OCamlConstructorDefinition psiElement);

	public abstract void visitTypeDefinitionConstraint(@Nonnull final OCamlTypeDefinitionConstraint psiElement);

	public abstract void visitAsTypeExpression(@Nonnull final OCamlAsTypeExpression psiElement);

	public abstract void visitFunctionTypeExpression(@Nonnull final OCamlFunctionTypeExpression psiElement);

	public abstract void visitTupleTypeExpression(@Nonnull final OCamlTupleTypeExpression psiElement);

	public abstract void visitSuperClassTypeExpression(@Nonnull final OCamlSuperClassTypeExpression psiElement);

	public abstract void visitTypeConstructorApplicationTypeExpression(@Nonnull final OCamlTypeConstructorApplicationTypeExpression psiElement);

	public abstract void visitObjectInterfaceTypeExpression(@Nonnull final OCamlObjectInterfaceTypeExpression psiElement);

	public abstract void visitMethodType(@Nonnull final OCamlMethodType psiElement);

	public abstract void visitVariantTypeTypeExpression(@Nonnull final OCamlVariantTypeTypeExpression psiElement);

	public abstract void visitTagSpec(@Nonnull final OCamlTagSpec psiElement);

	public abstract void visitTagSpecFull(@Nonnull final OCamlTagSpecFull psiElement);

	public abstract void visitPolyTypeExpression(@Nonnull final OCamlPolyTypeExpression psiElement);

	public abstract void visitClassDefinition(@Nonnull final OCamlClassDefinition psiElement);

	public abstract void visitClassBinding(@Nonnull final OCamlClassBinding psiElement);

	public abstract void visitClassTypeDefinition(@Nonnull final OCamlClassTypeDefinition psiElement);

	public abstract void visitClassTypeBinding(@Nonnull final OCamlClassTypeBinding psiElement);

	public abstract void visitFunctionClassType(@Nonnull final OCamlFunctionClassType psiElement);

	public abstract void visitClassPathApplication(@Nonnull final OCamlClassPathApplication psiElement);

	public abstract void visitObjectEndClassBodyType(@Nonnull final OCamlObjectEndClassBodyType psiElement);

	public abstract void visitInheritClassFiledSpecification(@Nonnull final OCamlInheritClassFiledSpecification psiElement);

	public abstract void visitValueClassFieldSpecification(@Nonnull final OCamlValueClassFieldSpecification psiElement);

	public abstract void visitMethodClassFieldSpecification(@Nonnull final OCamlMethodClassFieldSpecification psiElement);

	public abstract void visitConstraintClassFieldSpecification(@Nonnull final OCamlConstraintClassFieldSpecification psiElement);

	public abstract void visitFunctionApplicationClassExpression(@Nonnull final OCamlFunctionApplicationClassExpression psiElement);

	public abstract void visitObjectEndClassExpression(@Nonnull final OCamlObjectEndClassExpression psiElement);

	public abstract void visitInheritClassFieldDefinition(@Nonnull final OCamlInheritClassFieldDefinition psiElement);

	public abstract void visitInitializerClassFieldDefinition(@Nonnull final OCamlInitializerClassFieldDefinition psiElement);

	public abstract void visitConstraintClassFieldDefinition(@Nonnull final OCamlConstraintClassFieldDefinition psiElement);

	public abstract void visitValueClassFieldDefinition(@Nonnull final OCamlValueClassFieldDefinition psiElement);

	public abstract void visitMethodClassFieldDefinition(@Nonnull final OCamlMethodClassFieldDefinition psiElement);

	public abstract void visitFunctionClassExpression(@Nonnull final OCamlFunctionClassExpression psiElement);

	public abstract void visitClassSpecification(@Nonnull final OCamlClassSpecification psiElement);

	public abstract void visitClassSpecificationBinding(@Nonnull final OCamlClassSpecificationBinding psiElement);

	public abstract void visitClassTypeConstraint(@Nonnull final OCamlClassTypeConstraint psiElement);

	public abstract void visitModuleDefinition(@Nonnull final OCamlModuleDefinition psiElement);

	public abstract void visitModuleTypeDefinition(@Nonnull final OCamlModuleTypeDefinition psiElement);

	public abstract void visitFunctorModuleType(@Nonnull final OCamlFunctorModuleType psiElement);

	public abstract void visitSigEndModuleType(@Nonnull final OCamlSigEndModuleType psiElement);

	public abstract void visitModuleTypeTypeConstraint(@Nonnull final OCamlModuleTypeTypeConstraint psiElement);

	public abstract void visitModuleTypeModuleConstraint(@Nonnull final OCamlModuleTypeModuleConstraint psiElement);

	public abstract void visitFunctorApplicationModuleExpression(@Nonnull final OCamlFunctorApplicationModuleExpression psiElement);

	public abstract void visitStructEndModuleExpression(@Nonnull final OCamlStructEndModuleExpression psiElement);

	public abstract void visitFunctorModuleExpression(@Nonnull final OCamlFunctorModuleExpression psiElement);

	public abstract void visitModuleTypeConstraintModuleExpression(@Nonnull final OCamlModuleTypeConstraintModuleExpression psiElement);

	public abstract void visitModuleTypeWithConstraints(@Nonnull final OCamlModuleTypeWithConstraints psiElement);

	public abstract void visitModuleTypeSpecification(@Nonnull final OCamlModuleTypeSpecification psiElement);

	public abstract void visitModuleSpecification(@Nonnull final OCamlModuleSpecification psiElement);

	public abstract void visitValueName(@Nonnull final OCamlValueName psiElement);

	public abstract void visitValueNamePattern(@Nonnull final OCamlValueNamePattern psiElement);

	public abstract void visitOperatorName(@Nonnull final OCamlOperatorName psiElement);

	public abstract void visitModulePath(@Nonnull final OCamlModulePath psiElement);

	public abstract void visitModuleName(@Nonnull final OCamlModuleName psiElement);

	public abstract void visitConstructorPathExpression(@Nonnull final OCamlConstructorPathExpression psiElement);

	public abstract void visitConstructorNameExpression(@Nonnull final OCamlConstructorNameExpression psiElement);

	public abstract void visitConstructorPathPattern(@Nonnull final OCamlConstructorPathPattern psiElement);

	public abstract void visitConstructorNamePattern(@Nonnull final OCamlConstructorNamePattern psiElement);

	public abstract void visitTypeConstructorName(@Nonnull final OCamlTypeConstructorName psiElement);

	public abstract void visitFieldName(@Nonnull final OCamlFieldName psiElement);

	public abstract void visitClassPath(@Nonnull final OCamlClassPath psiElement);

	public abstract void visitClassName(@Nonnull final OCamlClassName psiElement);

	public abstract void visitMethodName(@Nonnull final OCamlMethodName psiElement);

	public abstract void visitInstVarName(@Nonnull final OCamlInstVarName psiElement);

	public abstract void visitLabelName(@Nonnull final OCamlLabelName psiElement);

	public abstract void visitModuleTypeName(@Nonnull final OCamlModuleTypeName psiElement);

	public abstract void visitExtendedModulePath(@Nonnull final OCamlExtendedModulePath psiElement);

	public abstract void visitExtendedModuleName(@Nonnull final OCamlExtendedModuleName psiElement);

	public abstract void visitTypeConstructorPath(@Nonnull final OCamlTypeConstructorPath psiElement);

	public abstract void visitModuleTypePath(@Nonnull final OCamlModuleTypePath psiElement);

	public abstract void visitTagName(@Nonnull final OCamlTagName psiElement);

	public abstract void visitValuePath(@Nonnull final OCamlValuePath psiElement);

	public abstract void visitFieldPath(@Nonnull final OCamlFieldPath psiElement);

	public abstract void visitConstantExpression(@Nonnull final OCamlConstantExpression psiElement);

	public abstract void visitConstantPattern(@Nonnull final OCamlConstantPattern psiElement);

	public abstract void visitMatchExpression(@Nonnull final OCamlMatchExpression psiElement);

	public abstract void visitFunExpression(@Nonnull final OCamlFunExpression psiElement);

	public abstract void visitFunctionExpression(@Nonnull final OCamlFunctionExpression psiElement);

	public abstract void visitTryExpression(@Nonnull final OCamlTryExpression psiElement);

	public abstract void visitPatternMatching(@Nonnull final OCamlPatternMatching psiElement);

	public abstract void visitSemicolonExpression(@Nonnull final OCamlSemicolonExpression psiElement);

	public abstract void visitIfExpression(@Nonnull final OCamlIfExpression psiElement);

	public abstract void visitForExpression(@Nonnull final OCamlForExpression psiElement);

	public abstract void visitWhileExpression(@Nonnull final OCamlWhileExpression psiElement);

	public abstract void visitAssignmentExpression(@Nonnull final OCamlAssignmentExpression psiElement);

	public abstract void visitCommaExpression(@Nonnull final OCamlCommaExpression psiElement);

	public abstract void visitBinaryExpression(@Nonnull final OCamlBinaryExpression psiElement);

	public abstract void visitHeadTailExpression(@Nonnull final OCamlHeadTailExpression psiElement);

	public abstract void visitAssertExpression(@Nonnull final OCamlAssertExpression psiElement);

	public abstract void visitLazyExpression(@Nonnull final OCamlLazyExpression psiElement);

	public abstract void visitConstructorApplicationExpression(@Nonnull final OCamlConstructorApplicationExpression psiElement);

	public abstract void visitFunctionApplicationExpression(@Nonnull final OCamlFunctionApplicationExpression psiElement);

	public abstract void visitArrayElementAccessingExpression(@Nonnull final OCamlArrayElementAccessingExpression psiElement);

	public abstract void visitStringCharAccessingExpression(@Nonnull final OCamlStringCharAccessingExpression psiElement);

	public abstract void visitRecordFieldAccessingExpression(@Nonnull final OCamlRecordFieldAccessingExpression psiElement);

	public abstract void visitUnaryExpression(@Nonnull final OCamlUnaryExpression psiElement);

	public abstract void visitClassMethodAccessingExpression(@Nonnull final OCamlClassMethodAccessingExpression psiElement);

	public abstract void visitTaggedExpression(@Nonnull final OCamlTaggedExpression psiElement);

	public abstract void visitTypeConstraintExpression(@Nonnull final OCamlTypeConstraintExpression psiElement);

	public abstract void visitCastingExpression(@Nonnull final OCamlCastingExpression psiElement);

	public abstract void visitListExpression(@Nonnull final OCamlListExpression psiElement);

	public abstract void visitArrayExpression(@Nonnull final OCamlArrayExpression psiElement);

	public abstract void visitRecordExpression(@Nonnull final OCamlRecordExpression psiElement);

	public abstract void visitInheritedRecordExpression(@Nonnull final OCamlInheritedRecordExpression psiElement);

	public abstract void visitInstanceDuplicatingExpression(@Nonnull final OCamlInstanceDuplicatingExpression psiElement);

	public abstract void visitObjectClassBodyEndExpression(@Nonnull final OCamlObjectClassBodyEndExpression psiElement);

	public abstract void visitNewInstanceExpression(@Nonnull final OCamlNewInstanceExpression psiElement);

	public abstract void visitArgument(@Nonnull final OCamlArgument psiElement);

	public abstract void visitParameter(@Nonnull final OCamlParameter psiElement);

	public abstract void visitAsPattern(@Nonnull final OCamlAsPattern psiElement);

	public abstract void visitOrPattern(@Nonnull final OCamlOrPattern psiElement);

	public abstract void visitCommaPattern(@Nonnull final OCamlCommaPattern psiElement);

	public abstract void visitHeadTailPattern(@Nonnull final OCamlHeadTailPattern psiElement);

	public abstract void visitConstructorApplicationPattern(@Nonnull final OCamlConstructorApplicationPattern psiElement);

	public abstract void visitTaggedPattern(@Nonnull final OCamlTaggedPattern psiElement);

	public abstract void visitTypeConstructorPattern(@Nonnull final OCamlTypeConstructorPattern psiElement);

	public abstract void visitLazyPattern(@Nonnull final OCamlLazyPattern psiElement);

	public abstract void visitListPattern(@Nonnull final OCamlListPattern psiElement);

	public abstract void visitArrayPattern(@Nonnull final OCamlArrayPattern psiElement);

	public abstract void visitRecordPattern(@Nonnull final OCamlRecordPattern psiElement);

	public abstract void visitTypeConstraintPattern(@Nonnull final OCamlTypeConstraintPattern psiElement);

	public abstract void visitBrackets(@Nonnull final OCamlBrackets psiElement);

	public abstract void visitUnknownElement(@Nonnull final OCamlUnknownElement psiElement);

	public abstract void visitTypeParameterName(@Nonnull final OCamlTypeParameterName psiElement);

	public abstract void visitForExpressionIndexVariableName(@Nonnull final OCamlForExpressionIndexVariableName psiElement);

	public abstract void visitForExpressionBinding(@Nonnull final OCamlForExpressionBinding psiElement);

	public abstract void visitLabelDefinition(@Nonnull final OCamlLabelDefinition psiElement);

	public abstract void visitTypeParameterDefinition(@Nonnull final OCamlTypeParameterDefinition psiElement);

	public abstract void visitObjectSelfDefinition(@Nonnull final OCamlObjectSelfDefinition psiElement);

	public abstract void visitModuleTypeDefinitionBinding(@Nonnull final OCamlModuleTypeDefinitionBinding psiElement);

	public abstract void visitModuleTypeSpecificationBinding(@Nonnull final OCamlModuleTypeSpecificationBinding psiElement);

	public abstract void visitModuleDefinitionBinding(@Nonnull final OCamlModuleDefinitionBinding psiElement);

	public abstract void visitModuleSpecificationBinding(@Nonnull final OCamlModuleSpecificationBinding psiElement);

	public abstract void visitModuleParameter(@Nonnull final OCamlModuleParameter psiElement);

	public abstract void visitFileModuleExpression(@Nonnull final OCamlFileModuleExpression psiElement);

	public abstract void visitFileModuleType(@Nonnull final OCamlFileModuleType psiElement);

	public abstract void visitCommentBlock(@Nonnull final OCamlCommentBlock psiElement);

	public abstract void visitUnclosedComment(@Nonnull final OCamlUnclosedComment psiElement);

	public abstract void visitLetBindingPattern(@Nonnull final OCamlLetBindingPattern psiElement);

	public abstract void visitRecordFieldInitializationInPattern(@Nonnull final OCamlRecordFieldInitializationInPattern psiElement);

	public abstract void visitInstVarNameDefinition(@Nonnull final OCamlInstVarNameDefinition psiElement);

	public abstract void visitConstructorNameDefinition(@Nonnull final OCamlConstructorNameDefinition psiElement);

	public abstract void visitTypeParameterizedBinding(@Nonnull final OCamlTypeParameterizedBinding psiElement);

	public abstract void visitCharRangePattern(@Nonnull final OCamlCharRangePattern psiElement);

	public abstract void visitFileModuleDefinitionBinding(@Nonnull final OCamlFileModuleDefinitionBinding psiElement);

	public abstract void visitFileModuleSpecificationBinding(@Nonnull final OCamlFileModuleSpecificationBinding psiElement);

	public abstract void visitParenthesesExpression(@Nonnull final OCamlParenthesesExpression psiElement);

	public abstract void visitParenthesesPattern(@Nonnull final OCamlParenthesesPattern psiElement);

	public abstract void visitParenthesesTypeExpression(@Nonnull final OCamlParenthesesTypeExpression psiElement);

	public abstract void visitParenthesesClassExpression(@Nonnull final OCamlParenthesesClassExpression psiElement);

	public abstract void visitParenthesesModuleExpression(@Nonnull final OCamlParenthesesModuleExpression psiElement);

	public abstract void visitParenthesesTypeParameters(@Nonnull final OCamlParenthesesTypeParameters psiElement);

	public abstract void visitParenthesesModuleType(@Nonnull final OCamlParenthesesModuleType psiElement);

	public abstract void visitParentheses(@Nonnull final OCamlParentheses psiElement);

	public abstract void visitUnderscoreTypeExpression(@Nonnull final OCamlUnderscoreTypeExpression psiElement);

	public abstract void visitUnderscorePattern(@Nonnull final OCamlUnderscorePattern psiElement);

	public abstract void visitExpressionStatement(@Nonnull final OCamlExpressionStatement psiElement);

	public abstract void visitConstructorName(@Nonnull final OCamlConstructorName psiElement);

	public abstract void visitConstructorPath(@Nonnull final OCamlConstructorPath psiElement);

	public abstract void visitObjectSelfSpecification(@Nonnull final OCamlObjectSelfSpecification psiElement);
}
