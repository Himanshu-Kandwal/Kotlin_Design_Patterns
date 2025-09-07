package behavioural

/*
The Command design pattern wraps up actions inside an object, so you can run them at a later
time.

 */

// 1. Command Interface - defines what every command can do
interface Command {
    fun execute()
    fun undo()
}

// 2. Receiver - the actual object that does the work
class TV {
    private var isOn = false
    private var volume = 10

    fun turnOn() {
        isOn = true
        println("TV is ON")
    }

    fun turnOff() {
        isOn = false
        println("TV is OFF")
    }

    fun volumeUp() {
        volume++
        println("Volume: $volume")
    }

    fun volumeDown() {
        volume--
        println("Volume: $volume")
    }
}

// 3. Concrete Commands - wrap each action in an object
class TVOnCommand(private val tv: TV) : Command {
    override fun execute() = tv.turnOn()
    override fun undo() = tv.turnOff()
}

class TVOffCommand(private val tv: TV) : Command {
    override fun execute() = tv.turnOff()
    override fun undo() = tv.turnOn()
}

class VolumeUpCommand(private val tv: TV) : Command {
    override fun execute() = tv.volumeUp()
    override fun undo() = tv.volumeDown()
}

// 4. Invoker - the remote control that executes commands
class RemoteControl {
    private val history = mutableListOf<Command>() //undo functionality storage

    fun pressButton(command: Command) {
        command.execute()
        history.add(command)  // Save for undo
    }

    fun pressUndo() {
        if (history.isNotEmpty()) {
            val lastCommand = history.removeAt(history.size - 1)
            lastCommand.undo()
        }
    }
}

// 5. Usage - Client code
fun main() {
    val tv = TV()
    val remote = RemoteControl()

    // Create command objects
    val turnOn = TVOnCommand(tv)
    val volumeUp = VolumeUpCommand(tv)

    // Press buttons on remote
    remote.pressButton(turnOn)      // TV is ON
    remote.pressButton(volumeUp)    // Volume: 11
    remote.pressButton(volumeUp)    // Volume: 12

    // Undo last action
    remote.pressUndo()              // Volume: 11
    remote.pressUndo()              // Volume: 10
    remote.pressUndo()              // TV is OFF
}
