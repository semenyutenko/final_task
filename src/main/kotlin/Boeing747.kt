class Boeing747(id: Int, maxRange: Double, tankCapacity: Double, override val passengersNumber: Int) :
    Aircraft(id, maxRange, tankCapacity), Passenger {

    override val model: String = "Boeing 747"
    override fun showParams() {
        println(model)
        super.showParams()
        println("количество пассажиров: $passengersNumber")
    }
}