package structural

/*
Allows incompatible interfaces to work together by creating a bridge between them
or
by converting one to another like USB 2.0 to USB Type-c etc

The diff between decorator and adapter is, decorator uses same component's interface and enhances or adds more functionality
while adapter uses completely different component and converts it into completely different type of component
 */


// 1 - Target interface (one which we wants our component to be converted)
interface Charger {
    fun charge()
}

// Adaptee (what we have) is a different interface than target
class USBCharger {
    fun chargeWithUSB() {
        println("USB charger")
    }
}

// Adapter converts interface
class USBToUSBCAdapter(private val usbCharger: USBCharger) :
    Charger { //takes adaptee --existing type which we already have

    override fun charge() {
        println("USB to USB-C converted")
        usbCharger.chargeWithUSB() // Calls ADAPTEE's method so client calling charge() is indirectly using adaptee's charge method
    }
}

fun main() {
    val usb = USBCharger()
    val converted = USBToUSBCAdapter(usb) //passing existing usb to adapter
    converted.charge() //calling charge on adapter
}

