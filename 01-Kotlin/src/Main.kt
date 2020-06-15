import java.util.function.Consumer

fun main(args:Array<String>){
    /*print("Hola")
   //Int edad = 31; en java
    //Mutables
    var edadProfesor = 31//no especificamos el tipo de dato
                        //: no es necesario
    //Duck Typing
    var edadCachorro: Int //nedcesitamos el tipo de dato
    edadCachorro = 3
    edadProfesor = 32
    edadCachorro= 4

    //Inmutables
    val_numeroCuenta = 123456//no se puede reasignar
    //numeroCuenta = 123

    val nombreProfesor= "Vicente Adrian"
    val sueldo = 12.20
    val apellidosProfesor = 'a'
    val fechaNacimiento = Date() //new Date();

    //if(sueldo==12.20){
     //   else{

     //   }
    //}
    //when es como el switch en kotlin ya que este no existe
    when(sueldo){
        12.20 -> print("Sueldo normal")
        -12.20 -> print("Sueldo negativo")
        else-> println("No se reconoce el sueldo")
    }
    val esSueldoMayorAlEstablecido = if(sueldo==12.20) true else false

    //calcularSueldo(1000.00, 14.00)
    calcularSueldo(sueldo:1000, tasa:14.00)
    calcularSueldo(tasa=16.00, sueldo=800)
    //Named Parameters

    calcularSueldo(sueldo: 700.00)
    calcularSueldo(650)
*/
    val arregloConstante: Array<Int> = arrayOf(1,2,3)
    val arregloCumpleanos: ArrayList<Int> = arrayListOf(30,31,22,23,20)
    arregloCumpleanos.add(24)
    print(arregloCumpleanos)
    arregloCumpleanos.remove(30)
    print(arregloCumpleanos)

    arregloCumpleanos.forEach{Int
    print("Valor de la iteracion"+ it)}

    arregloCumpleanos.forEach(Consumer { valorIteracion: Int?->
        println("Valor iteracion: "+ valorIteracion)
    })
    arregloCumpleanos.forEach({valorIteracion: Int ->
    println("Valor iteracion: "+valorIteracion)})

    //Operadores->Todos los lenguajes

    //forEach no devuelve nada->Unit
    arregloCumpleanos
            .forEach {
                println("Valor de la iteracion " + it)
            }

    arregloCumpleanos
            .forEachIndexed { index:Int, it:Int ->
                println("Valor de la iteracion " + it)
            }
    val respuestArregloForEach=arregloCumpleanos
            .forEachIndexed { index:Int, iteraccion:Int ->
                println("Valor de la iteracion " + iteraccion)
            }
    println(respuestArregloForEach)

    //MAP-> Muta el arreglo (cambia el arreglo)
    /*arregloCumpleanos.map { iteracion: Int ->
        val nuevoValor=iteracion*-1
        return nuevoValor
    }
*/
    //enviemos el nuvo valor de la itracion
    //nos devuelve es un nuevo arreglo con los valores modificados
    val respuestaMap=arregloCumpleanos.map{
        iterator:Int ->
        iterator*-1

    }

    val respuestaMapDos=arregloCumpleanos.map{
        iterator:Int ->
        val nuevoValor=iterator*-1
        val otroValor=nuevoValor *2
        return@map otroValor

    }

    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCumpleanos)

    //filter =filtra el arreglo
    
    val respuestaFilter: List<int>=arregloCumpleanos.filter {
        iteracion: Int ->
        val esMayorA23:Boolean=iteracion>23
        return @filter esMayor

    }
    arregloCumpleanos.filter { iteracion:Int->iteracion>23 }
    println(respuestaFilter)
    println(arregloCumpleanos
    )








}

fun calcularSueldo(sueldo: Double, tasa: Double= 12.00
                ,calculoEspecial: Int?=null)//Puede ser nulos
: Double {
    if (calculoEspecial!=null){
        return sueldo*tasa*calculoEspecial
    }else{
    return sueldo*tasa
}}




fun imprimirMensaje():Unit{ //Unit=Void
    println("")
}

