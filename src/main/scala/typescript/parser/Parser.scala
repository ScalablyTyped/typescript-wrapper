package typescript
package parser

import cats._
import japgolly.scalagraal.Expr.Result
import japgolly.scalagraal.GraalJs._
import japgolly.scalagraal.{ContextSync, Expr, Language}
import org.graalvm.polyglot.{Source, Value}
import org.webjars.WebJarAssetLocator

class Parser private (rootTsExpr: Expr[Value])(private val ctx: ContextSync) {
  ctx.eval(rootTsExpr)
  val typescript: Id[Result[Typescript]] = ctx.eval(Expr("ts").as[Typescript])

  def parse(source: Source): Either[Exception, SourceFile] = {
    typescript
      .map(
        _.createSourceFile(
          "dummy.ts",
          source.getCharacters.toString,
          "99"
        )
      )
  }
}

object Parser {
  private lazy val typescript = new WebJarAssetLocator().getFullPath("typescript", "typescript.js")
  private lazy val typescriptExpr: Expr[Value] = Expr.requireFileOnClasspath(typescript)(Language.JS)

  def apply(context: ContextSync): Parser = new Parser(typescriptExpr)(context)
}
