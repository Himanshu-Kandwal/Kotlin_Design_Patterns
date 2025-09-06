package creational.builder

/*
Builder pattern is used when:

When object is complex has so many arguments in constructor or so many optional constructor
When we want object to be immutable after it's creation
When we want more readable api to the client
 */

//Computer is what we want to build
//Private constructor so nobody can do Computer() to create object
class Computer private constructor(
    val cpu: String?,
    val ramGb: Int?,
    val ssdGb: Int?,
    val gpu: String?
) {
    class Builder {
        var cpu: String? = null
        var ramGb: Int? = null
        var ssdGb: Int? = null
        var gpu: String? = null

        fun cpu(value: String) = apply { cpu = value }
        fun ramGb(value: Int) = apply { ramGb = value }
        fun ssdGb(value: Int) = apply { ssdGb = value }
        fun gpu(value: String) = apply { gpu = value }

        fun build() = Computer(cpu, ramGb, ssdGb, gpu)
    }

    override fun toString(): String {
        return "Computer(cpu=$cpu, ramGb=$ramGb, ssdGb=$ssdGb, gpu=$gpu)"
    }
}

//usage
fun main() {
    val pc = Computer.Builder()
        .cpu("Ryzen 7")
        .ramGb(32)
        .ssdGb(1024)
        .gpu("RTX 4070")
        .build()

    val pc1 = Computer.Builder()
        .cpu("Intel i7")
        .ramGb(64)
        .ssdGb(2024)
        .gpu("RTX 1080")
        .build()

    println(pc)
    println(pc1)

}