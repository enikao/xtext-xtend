/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CompilerBug410797Test extends AbstractXtendCompilerTest {
  @Test
  public void testBug_410797_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Iterable<D> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val list = <E>newArrayList");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val g = new G");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("list.map[e|e.m].flatten.map[d(g)]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def d(F f, G g) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new D");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<F>newArrayList");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class G {\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class F {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.collect.Iterables;");
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ListExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<D> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Iterable<D> _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final ArrayList<E> list = CollectionLiterals.<E>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final G g = new G();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final Function1<E, ArrayList<F>> _function = new Function1<E, ArrayList<F>>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public ArrayList<F> apply(final E e) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return e.m();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final Function1<F, D> _function_1 = new Function1<F, D>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public D apply(final F it) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return C.this.d(it, g);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = IterableExtensions.<F, D>map(Iterables.<F>concat(ListExtensions.<E, ArrayList<F>>map(list, _function)), _function_1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _xblockexpression;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public D d(final F f, final G g) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new D();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug_410797_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Iterable<D> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val g = new G();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<E>newArrayList.map[e|e.m].flatten.map[d(g)]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def d(F f, G g) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new D");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<F>newArrayList");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class G {\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class F {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.collect.Iterables;");
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ListExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<D> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Iterable<D> _xblockexpression = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("{");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final G g = new G();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final Function1<E, ArrayList<F>> _function = new Function1<E, ArrayList<F>>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public ArrayList<F> apply(final E e) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return e.m();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("final Function1<F, D> _function_1 = new Function1<F, D>() {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("public D apply(final F it) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("return C.this.d(it, g);");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("_xblockexpression = IterableExtensions.<F, D>map(Iterables.<F>concat(ListExtensions.<E, ArrayList<F>>map(CollectionLiterals.<E>newArrayList(), _function)), _function_1);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _xblockexpression;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public D d(final F f, final G g) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new D();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug_410797_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Iterable<D> m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<E>newArrayList.map[e|e.m].flatten.map[d(new G)]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def d(F f, G g) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new D");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class D {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<F>newArrayList");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class G {\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class F {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.collect.Iterables;");
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.ListExtensions;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<D> m() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function1<E, ArrayList<F>> _function = new Function1<E, ArrayList<F>>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public ArrayList<F> apply(final E e) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return e.m();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function1<F, D> _function_1 = new Function1<F, D>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public D apply(final F it) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("G _g = new G();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return C.this.d(it, _g);");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return IterableExtensions.<F, D>map(Iterables.<F>concat(ListExtensions.<E, ArrayList<F>>map(CollectionLiterals.<E>newArrayList(), _function)), _function_1);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public D d(final F f, final G g) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return new D();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug_410797_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package org.eclipse.xtext.xbase.formatting");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import com.google.inject.Inject");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.nodemodel.INode");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.nodemodel.ILeafNode");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator");
    _builder.newLine();
    _builder.append("import org.eclipse.xtext.nodemodel.ICompositeNode");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Data class HiddenLeafs {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int offset");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("List<LeafInfo> leafs = newArrayList");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def boolean isSingleWhitespace() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leafs.empty || (leafs.size == 1 && leafs.head instanceof WhitespaceInfo)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int getLenght() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leafs.fold(0, [x, i | x + i.node?.length])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int getNewLines() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leafs.fold(0, [x, i | x + i.newLines])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def int getNewLinesInComments() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leafs.filter(CommentInfo).fold(0, [x, i | x + i.newLines])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def containsComment(){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("leafs.filter(CommentInfo).size > 0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.eclipse.xtext.xbase.formatting;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import com.google.common.collect.Iterables;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.Data;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.nodemodel.ILeafNode;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.formatting.CommentInfo;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.formatting.LeafInfo;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.formatting.WhitespaceInfo;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function2;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.IterableExtensions;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringHelper;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Data");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class HiddenLeafs {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final int _offset;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final List<LeafInfo> _leafs = CollectionLiterals.<LeafInfo>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean isSingleWhitespace() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (this.getLeafs().isEmpty() || ((this.getLeafs().size() == 1) && (IterableExtensions.<LeafInfo>head(this.getLeafs()) instanceof WhitespaceInfo)));");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int getLenght() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Integer apply(final Integer x, final LeafInfo i) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("ILeafNode _node = i.getNode();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("int _length = 0;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("if (_node!=null) {");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("_length=_node.getLength();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return Integer.valueOf(((x).intValue() + _length));");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (int) IterableExtensions.<LeafInfo, Integer>fold(this.getLeafs(), Integer.valueOf(0), _function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int getNewLines() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Integer, LeafInfo, Integer> _function = new Function2<Integer, LeafInfo, Integer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Integer apply(final Integer x, final LeafInfo i) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("int _newLines = i.getNewLines();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return Integer.valueOf(((x).intValue() + _newLines));");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (int) IterableExtensions.<LeafInfo, Integer>fold(this.getLeafs(), Integer.valueOf(0), _function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int getNewLinesInComments() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Function2<Integer, CommentInfo, Integer> _function = new Function2<Integer, CommentInfo, Integer>() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("public Integer apply(final Integer x, final CommentInfo i) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("int _newLines = i.getNewLines();");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return Integer.valueOf(((x).intValue() + _newLines));");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (int) IterableExtensions.<CommentInfo, Integer>fold(Iterables.<CommentInfo>filter(this.getLeafs(), CommentInfo.class), Integer.valueOf(0), _function);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean containsComment() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int _size = IterableExtensions.size(Iterables.<CommentInfo>filter(this.getLeafs(), CommentInfo.class));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return (_size > 0);");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public HiddenLeafs(final int offset) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._offset = offset;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int hashCode() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final int prime = 31;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int result = 1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + this._offset;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + ((this._leafs== null) ? 0 : this._leafs.hashCode());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean equals(final Object obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this == obj)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj == null)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (getClass() != obj.getClass())");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("HiddenLeafs other = (HiddenLeafs) obj;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (other._offset != this._offset)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this._leafs == null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (other._leafs != null)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (!this._leafs.equals(other._leafs))");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String result = new ToStringHelper().toString(this);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int getOffset() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._offset;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public List<LeafInfo> getLeafs() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._leafs;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}
