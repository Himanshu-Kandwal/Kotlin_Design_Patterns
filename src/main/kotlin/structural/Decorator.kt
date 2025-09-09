package structural

/*

Decorator pattern allow us to wrap a core object into a object which has extra functionality so without altering core object
we can add features to it.
*/

// 1 - Component interface

interface Pizza {
    fun getCost(): Int
    fun getDescription(): String
}

// 2 - Implementation of component (pizza

class BasicPizza : Pizza {
    override fun getCost(): Int {
        return 200
    }

    override fun getDescription(): String {
        return "Basic Pizza"
    }
}

// 3 - Abstract Decorator (with reference to core component i.e pizza being decorated)
abstract class PizzaDecorator(val pizza: Pizza) : Pizza {

    override fun getDescription(): String {
        return pizza.getDescription() //use existing impl from component
    }

    override fun getCost(): Int {
        return pizza.getCost() //use existing impl from component
    }
}

// 4 - Multiple implementations of decorator class based on requirements

// Decorator 1

class CheeseTopping(pizza: Pizza) : PizzaDecorator(pizza) {
    override fun getDescription(): String {
        return pizza.getDescription() + ", Extra Cheese" // Add new behavior with existing
    }

    override fun getCost(): Int {
        return pizza.getCost() + 50 // Add cost
    }
}

// Decorator 2

class OliveTopping(pizza: Pizza) : PizzaDecorator(pizza) {
    override fun getDescription(): String {
        return pizza.getDescription() + ", Olives"
    }

    override fun getCost(): Int {
        return pizza.getCost() + 30
    }
}

// Concrete Decorator 3

class MushroomTopping(pizza: Pizza) : PizzaDecorator(pizza) {
    override fun getDescription(): String {
        return pizza.getDescription() + ", Mushrooms"
    }

    override fun getCost(): Int {
        return pizza.getCost() + 40
    }
}


fun main() {
    val plainPizza = BasicPizza() //basic component i.e pizza
    println("Before decoration :  ${plainPizza.getDescription()}")

    val pizzaWithMushroomTopping =
        MushroomTopping(plainPizza) //decorating using mushroomtopping, we can use some other topping from above also
    println("After mushroom added( decoration) :  ${pizzaWithMushroomTopping.getDescription()}")

}