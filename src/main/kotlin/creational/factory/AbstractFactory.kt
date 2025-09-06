package creational.factory

/*
Abstract factory pattern -> factory of factories

It is used when we have multiple products which have groups/families and related to each other.

A family means some relation between products which make them be together,
like all dark ui component go together, same goes for light ui components
we never have dark ui component with light component

Dark UI family -> dark button, dark checkbox etc
Light Ui family -> light button, light checkbox etc

for every family we have concrete implementation of abstract factory
 */
// Product type 1 -> button
interface Button {   // Abstract product
    fun render()
}

class DarkButton : Button {   // Concrete product
    override fun render() = println("Rendering Dark Button")
}

class LightButton : Button {  // Concrete product
    override fun render() = println("Rendering Light Button")
}

// Product type 2: Checkboxes
interface Checkbox {   // Abstract product
    fun render()
}

class DarkCheckbox : Checkbox {   // Concrete product
    override fun render() = println("Rendering Dark Checkbox")
}

class LightCheckbox : Checkbox {  // Concrete product
    override fun render() = println("Rendering Light Checkbox")
}

// Abstract Factory
interface UIFactory {
    fun createButton(): Button     // Factory method for product type 1
    fun createCheckbox(): Checkbox // Factory method for product type 2
}

// Concrete Factories

//Dark family products
class DarkUIFactory : UIFactory {   // Produces only Dark-themed products
    override fun createButton(): Button = DarkButton()
    override fun createCheckbox(): Checkbox = DarkCheckbox()
}

//light family products
class LightUIFactory : UIFactory {  // Produces only Light-themed products
    override fun createButton(): Button = LightButton()
    override fun createCheckbox(): Checkbox = LightCheckbox()
}

// using factory
//renderUI does not know how button and which family button etc is being created i.e it neither knows implementation of
// factory being dark or light nor it knows how the product being created by UiFactories which are abstract
fun renderUI(factory: UIFactory) { //abstract factory

    val button = factory.createButton()
    val checkbox = factory.createCheckbox()

    // Works with abstract types (Button, Checkbox)
    button.render()
    checkbox.render()
}

/*
In Factory Method, the creator defines a factory method for one product type, and subclasses decide which product to create.
In Abstract Factory, the factory defines methods for multiple product types, and each concrete factory creates a full family of related products.
In both, the client/creator does not know the concrete products directly.
 */
fun main() {
    // Swap factories to change whole product family (Dark / Light theme)
    renderUI(DarkUIFactory()) //concrete darkUi factory passing
    renderUI(LightUIFactory()) //concrete light factory passing
}
