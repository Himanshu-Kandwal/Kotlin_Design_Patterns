package creational.factory

/*
Factory Method: creation of product is decided by the subclass of creator abstract class which contains factory method

In factory method , factory is a method not a class, subclass decides how each respective product will be created
 */


// Product
interface Document {
    fun print()
}

// Concrete products
class PdfDocument : Document {
    override fun print() = println("Printing PDF Document")
}

class WordDocument : Document {
    override fun print() = println("Printing Word Document")
}


// Creator having factory method
abstract class DocumentCreator {
    abstract fun createDocument(): Document  // Factory Method

    fun openDocument() { //method which we call and automatically calls the createDocument method
        val doc = createDocument()
        println("Opening document...")
        doc.print()
    }
}

// PDF doc creator to create PDF doc
class PdfDocumentCreator : DocumentCreator() {
    override fun createDocument(): Document = PdfDocument()
}

//Word Doc creator to create Word Doc
class WordDocumentCreator : DocumentCreator() {
    override fun createDocument(): Document = WordDocument()
}

// usage

fun main() {
    //Document creator which is initialised by PDF creator
    val pdfCreator: DocumentCreator = PdfDocumentCreator()
    pdfCreator.openDocument() // creates pdf

    //Document creator which is initialised by Word document creator
    val wordCreator: DocumentCreator = WordDocumentCreator()
    wordCreator.openDocument() //creates word
}
