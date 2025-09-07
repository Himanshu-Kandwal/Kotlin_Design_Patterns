package behavioural

/*
Observer patterns allow us to achieve pub-sub facility in which a Subject is observed by many observers
subject notifies them based on state change happens

 */


// The Subject interface
interface NewsAgency {
    fun addObserver(channel: NewsChannel)
    fun removeObserver(channel: NewsChannel)
    fun notifyObservers(headline: String)
}

// The Observer interface
interface NewsChannel {
    fun update(headline: String)
}

//Concrete Subject which we will be observed

class SomeNewsAgency : NewsAgency {
    private val channels = mutableSetOf<NewsChannel>()

    override fun addObserver(channel: NewsChannel) {
        channels.add(channel)
    }

    override fun removeObserver(channel: NewsChannel) {
        channels.remove(channel)
    }

    override fun notifyObservers(headline: String) {
        println("News Agency: Broadcasting new headline...")
        for (channel in channels) {
            channel.update(headline)
        }
    }

    //state changer method
    fun publishNewHeadline(headline: String) {
        notifyObservers(headline)
    }
}

//Concrete observers

//tv
class TvNewsChannel(private val name: String) : NewsChannel {
    override fun update(headline: String) {
        println("[$name TV]: Breaking News! '$headline'")
    }
}

//radio
class RadioNewsChannel(private val name: String) : NewsChannel {
    override fun update(headline: String) {
        println("[$name Radio]: Breaking News! '$headline'")
    }
}

//telegram
class TelegramNewsChannel(private val name: String) : NewsChannel {
    override fun update(headline: String) {
        println("[$name Telegram]: Breaking News! '$headline'")
    }
}

fun main() {
    val newsAgency = SomeNewsAgency()

    //observers TV type
    val aajTakObserver = TvNewsChannel("AajTak")
    val ndtvObserver = TvNewsChannel("NDTV")

    //observers Radio type
    val radioMirchi = RadioNewsChannel("RadioMirchi")
    val redFM = RadioNewsChannel("RedFM")

    //observers telegram type
    val xyzChannel = TelegramNewsChannel("XyzChannelTelegram")

    //add all observers to subject
    newsAgency.addObserver(aajTakObserver)
    newsAgency.addObserver(ndtvObserver)
    newsAgency.addObserver(radioMirchi)
    newsAgency.addObserver(redFM)
    newsAgency.addObserver(xyzChannel)

    //change subject's state

    newsAgency.publishNewHeadline("Elon musk got bankrupt")

}