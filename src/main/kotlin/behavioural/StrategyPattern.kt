package behavioural

/*
It is used when we need a family of algorithms, encapsulates each one, and makes them interchangeable at runtime
*/

//Strategy interface
interface PaymentStrategy {
    fun pay(amount: Double)
}

//Concrete implementations of Strategies

//credit card
class CreditCardStrategy : PaymentStrategy {
    //Other credit card attributes here

    //paying customised for CC
    override fun pay(amount: Double) {
        println("Paying $amount by CC")
    }
}

//UPI
class UpiPaymentStrategy : PaymentStrategy {
    //other UPI attributes here

    //paying customised for UPI
    override fun pay(amount: Double) {
        println("Paying $amount by UPI")
    }
}

//Payment handler class
class PaymentManager {

    private var paymentStrategy: PaymentStrategy? = null

    fun setPaymentStrategy(paymentStrategy: PaymentStrategy?) {
        this.paymentStrategy = paymentStrategy
    }

    fun sendPayment(amount: Double) {
        paymentStrategy!!.pay(amount)
    }

}

fun main() {

    val upiPayment = UpiPaymentStrategy() //strategy

    val pm = PaymentManager() //payment manager which uses strategy

    pm.setPaymentStrategy(upiPayment) //setting strategy

    pm.sendPayment(289.08) //calling method which executes based on strategy we fixed above
}