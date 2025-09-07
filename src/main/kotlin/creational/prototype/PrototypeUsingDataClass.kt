package creational.prototype

/*
Prototype pattern is used when object creation is complex, and we need slightly different object, so we just clone original
object with little changes we need.

Data class in kotlin automatically has Copy method works similar to Clone method
 */
data class ComplexDataClass(private val content: String, private val num: Int)

fun main() {
    val original = ComplexDataClass("this is content", 100) //num is 100

    val copied = original.copy(num = 90) //num became 90

    println(original)
    println(copied)
}