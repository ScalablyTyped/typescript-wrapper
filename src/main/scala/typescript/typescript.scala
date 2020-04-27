package typescript

trait Typescript {
  def createSourceFile(fileName: String, sourceText: String, languageVersion: String): SourceFile
}

trait TextRange {
  var end: Double
  var pos: Double
}

trait Node extends TextRange {
  //  var decorators: js.UndefOr[NodeArray[Decorator]]
  //  var flags: NodeFlags
  var kind: Int
  //  var modifiers: js.UndefOr[ModifiersArray]
  var parent: Node

  //  def forEachChild[T](cbNode: js.Function1[/* node */ this.type, js.UndefOr[T]]): js.UndefOr[T]
  //  def forEachChild[T](
  //                       cbNode: js.Function1[/* node */ this.type, js.UndefOr[T]],
  //                       cbNodeArray: js.Function1[/* nodes */ NodeArray[this.type], js.UndefOr[T]]
  //                     ): js.UndefOr[T]
  def getChildAt(index: Double): Node

  def getChildAt(index: Double, sourceFile: SourceFile): Node

  def getChildCount(): Double

  def getChildCount(sourceFile: SourceFile): Double

  def getChildren(): Array[Node]

  def getChildren(sourceFile: SourceFile): Array[Node]

  def getEnd(): Double

  //  def getFirstToken(): js.UndefOr[Node]
  //  def getFirstToken(sourceFile: SourceFile): js.UndefOr[Node]
  def getFullStart(): Double

  def getFullText(): java.lang.String

  def getFullText(sourceFile: SourceFile): java.lang.String

  def getFullWidth(): Double

  //  def getLastToken(): js.UndefOr[Node]
  //  def getLastToken(sourceFile: SourceFile): js.UndefOr[Node]
  def getLeadingTriviaWidth(): Double

  def getLeadingTriviaWidth(sourceFile: SourceFile): Double

  def getSourceFile(): SourceFile

  def getStart(): Double

  def getStart(sourceFile: SourceFile): Double

  def getStart(sourceFile: SourceFile, includeJsDocComment: Boolean): Double

  def getText(): java.lang.String

  def getText(sourceFile: SourceFile): java.lang.String

  def getWidth(): Double

  //  def getWidth(sourceFile: SourceFileLike): Double
}

trait Statement extends Node {
  var _statementBrand: Any
}

trait SourceFile {
  //    var amdDependencies: js.Array[AmdDependency]
  //    var endOfFileToken: Token[typings.typescript.mod.SyntaxKind.EndOfFileToken]
  var fileName: java.lang.String
  /**
   * lib.d.ts should have a reference comment like
   *
   * /// <reference no-default-lib="true"/>
   *
   * If any other file has this comment, it signals not to include lib.d.ts
   * because this containing file is intended to act as a default library.
   */
  var hasNoDefaultLib: Boolean
  var isDeclarationFile: Boolean
  var kind: Int
  //    var languageVariant: LanguageVariant
//  var languageVersion: ScriptTarget
  //    var libReferenceDirectives: js.Array[FileReference]
  //    var moduleName: js.UndefOr[java.lang.String]
  //    var referencedFiles: js.Array[FileReference]
  var statements: Array[Statement]
  var text: java.lang.String

  //    var typeReferenceDirectives: js.Array[FileReference]
  //    def getLineAndCharacterOfPosition(pos: Double): LineAndCharacter
  def getLineEndOfPosition(pos: Double): Double

  //    def getLineStarts(): js.Array[Double]
  def getPositionOfLineAndCharacter(line: Double, character: Double): Double

  //    def update(newText: java.lang.String, textChangeRange: TextChangeRange): SourceFile
}
