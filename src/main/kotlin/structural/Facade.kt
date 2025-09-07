package structural

//Facade pattern hides complexity behind a clean, easy-to-use interface, so we don't directly use lower level components
//and make it easy

// Complex subsystem classes
class CPU {
    fun terminate(processId:Int) = println("CPU: Terminating process $processId")
    fun execute(processId:Int) = println("CPU: Executing instructions $processId")
}

class Memory {

    fun load(position: Long, data: ByteArray) {
        println("Memory: Loading data at position $position")
    }

}

class HardDrive {
    fun read(lba: Long, size: Int): ByteArray {
        println("HardDrive: Reading $size bytes from sector $lba")
        return ByteArray(size)
    }
}

// Facade class that simplifies the complex subsystem interaction, we don't talk to other sub-components of the system
class ComputerFacade {
    private val cpu = CPU()
    private val memory = Memory()
    private val hardDrive = HardDrive()

    fun startComputer() {
        println("Starting computer...")
        cpu.execute(28288)
        memory.load(0, hardDrive.read(0, 1024))
        println("Computer started successfully")
        cpu.terminate(28288)
    }
}

fun main() {
    val computer = ComputerFacade()
    computer.startComputer()
}
