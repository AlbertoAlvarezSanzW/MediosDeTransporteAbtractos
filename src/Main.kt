import kotlin.random.Random

fun main() {
    val bus1 = Bus()
    val bus2 = Bus()
    val barco1 = BarcoGrande()
    val barco2 = BarcoGrande()
    val flotaDeLaEmpresa = listOf(bus1, bus2, barco1, barco2)

    for (medioDeTransporte in flotaDeLaEmpresa) {
        medioDeTransporte.transladarse("Barcelona", "Ibiza")
    }

}


abstract class MedioDeTransporte(){
    abstract fun transladarse(orignen: String, destino: String)

    protected fun llegarADestino() {
        println("Llegar a destino...")
    }

    protected fun iniciarRuta() {
        println("Inicio la ruta...")
    }
}

class Bus : MedioDeTransporte(){
    override fun transladarse(orignen: String, destino: String) {
        println("Comienza un translado de un Bus")

        if (comprobarEstadoCarreteras(orignen, destino)) {
            iniciarRuta()
            hacerDescanso()
            llegarADestino()
        } else {
            println("Cancelamos la ruta por baches")
        }
    }

    private fun hacerDescanso() {
        println("A descanso")
    }



    fun comprobarEstadoCarreteras(orignen: String, destino: String) : Boolean {
        return Random.nextBoolean()
    }
}

class BarcoGrande : MedioDeTransporte(){
    override fun transladarse(orignen: String, destino: String) {
        println("Comienza un translado de un Barco")
        comprobarMeteo(orignen, destino)
        if (comprobarMeteo(orignen, destino) > 90) {
            println("No zarpamos")
        } else {
            iniciarRuta()
            llegarADestino()
        }
    }

    fun comprobarMeteo(orignen: String, destino: String) : Int{
        // Cuando más alto el Int, peor tiempo
        return Random.nextInt(100)
    }

}