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

