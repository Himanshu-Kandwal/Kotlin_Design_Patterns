package creational.factory

import javax.print.Doc


/*
A factory pattern having a class as factory and have a STATIC method to create products/objects based on an ENUM or String
 */

// Product interface
interface File {
    fun write(content: String)
    fun open(): String
}

// Product 1
private class PdfFile : File {

    private var content: String = ""

    override fun write(content: String) {
        this.content = content
    }

    override fun open(): String {
        return content
    }
}

//product 2
private class DocFile : File {

    private var content: String = ""

    override fun write(content: String) {
        this.content = content
    }

    override fun open(): String {
        return content
    }

}

// Factory with a static method
object FileFactory {
    fun create(type: String): File {
        return when (type.lowercase()) {
            "pdf" -> PdfFile()
            "doc" -> DocFile()
            else -> throw IllegalArgumentException("Unsupported file type: $type")
        }
    }
}

// Using
fun main() {
    val pdf = FileFactory.create("pdf") //creating pdf file
    pdf.write("hey its pdf")

    val doc = FileFactory.create("doc") //creating doc
    doc.write("hey its doc")

    println(pdf.open())
    println(doc.open())

}
