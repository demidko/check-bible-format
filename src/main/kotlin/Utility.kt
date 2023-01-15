import app.biblequote.Bible
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.types.file

object Utility : CliktCommand(
  "Утилита для проверки библейских файлов",
  "s.d.g. 2023",
  "check-bible-format"
) {

  val file by argument("файл", "файл библии в этой же папке, например, stern.html").file()

  override fun run() {
    val url = file.toURI().toURL()
    Bible(url)
  }
}

fun main(args: Array<String>) {
  Utility.main(args)
}