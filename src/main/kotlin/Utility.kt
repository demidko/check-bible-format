import app.biblequote.Bible
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file

object Utility : CliktCommand(
  "Утилита для проверки библейских файлов",
  "s.d.g. 2023",
  "check-bible-format"
) {

  private val file by argument("файл", "файл библии в этой же папке, например, stern.html").file()

  override fun run() {
    val bible = file.toURI().toURL().let(::Bible)
    for (book in bible.booksNames) {
      echo("\"$book\" to listOf(")
      for (chapter in (1..bible.chaptersCount(book))) {
        echo("${bible.versesCount(book, chapter)}", lineSeparator = ", ")
      }
      echo("),")
    }
  }
}

fun main(args: Array<String>) {
  Utility.main(args)
}