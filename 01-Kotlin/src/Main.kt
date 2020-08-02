fun main(args:Array<String>) {
    val pacientes = ArrayList<Pacientes>()
    mostrarMenu(pacientes)
}
public class Pacientes(
        var Nombre:String,
        var Apellido:String,
        var Edad:Int,
        var TipoSangre:String,
        var Cedula:String

)

fun ingresar(pacientes: ArrayList<Pacientes>) {
    print("Ingrese nombre del paciente: ")
    val nombre = readLine().toString()
    print("Ingrese apellido del paciente: ")
    val apellido = readLine().toString()
    print("Ingrese la edad del paciente: ")
    val edad = readLine().toString().toInt()
    print("Ingrese tipo de sangre del paciente: ")
    val tipoSangre = readLine().toString()
    print("Ingrese cedula del paciente: ")
    val cedula = readLine().toString()

    pacientes.add(Pacientes(nombre,apellido,edad,tipoSangre,cedula))
    mostrarMenu(pacientes)
}

fun eliminar(pacientes: ArrayList<Pacientes>){
    print("Ingrese la cedula del paciente a borrar:")
    var cedula = readLine().toString()
    var eliminar=pacientes.removeIf { iteracion : Pacientes ->iteracion.Cedula==cedula
    }
    if(eliminar){
        print("El paciente fue borrado del historial")
        //eliminar(pacientes)
    }else{
        print("El paciente no existe en el historial")
    }
    mostrarMenu(pacientes)
}

fun imprimir(pacientes: ArrayList<Pacientes>){
    for(i in pacientes) {
        println("Nombre y Apellido: "+i.Nombre+" "+i.Apellido+"\n"+"Edad: "+i.Edad+"\n"+"Tipo de Sangre: "+i.TipoSangre+"\n"+"Cedula: "+i.Cedula)
    }
    mostrarMenu(pacientes)
}

fun modificar(pacientes: ArrayList<Pacientes>){
    print("Ingrese la cedula del paciente que desea modificar: ")
    val cedula = readLine().toString()
    var modificar=pacientes.removeIf { iteracion : Pacientes -> iteracion.Cedula==cedula
    }
    if(modificar){
        print("Ingrese nombre del paciente: ")
        val nombre = readLine().toString()
        print("Ingrese apellido del paciente: ")
        val apellido = readLine().toString()
        print("Ingrese la edad del paciente: ")
        val edad = readLine().toString().toInt()
        print("Ingrese tipo de sangre del paciente: ")
        val tipoSangre = readLine().toString()
        print("Ingrese cedula del paciente: ")
        val cedula = readLine().toString()

        pacientes.add(Pacientes(nombre,apellido,edad,tipoSangre,cedula))

    }else{
        print("El paciente no existe en el historial")
    }
    mostrarMenu(pacientes)
}


fun mostrarMenu(pacientes:ArrayList<Pacientes>) {
    var menu: String
    menu = "\n" + " HOSPITAL DEL SUR " + "\n" +
            "1.Ingresar al paciente" + "\n" +
            "2.Imprimir pacientes" + "\n" +
            "3.Modificar pacientes" + "\n" +
            "4.Eliminar pacientes" + "\n" +
            "5.Salir" + "\n"

    print(menu)
    var cont: Int
    while (true) {
        cont = readLine().toString().toInt()
        if (cont > 5 || cont < 1) {
            print("Ingrese las Opciones Mostradas: ")
        } else {
            break
        }
    }

    when (cont) {
        1 -> ingresar(pacientes)
        2 -> imprimir(pacientes)
        3 -> modificar(pacientes)
        4 -> eliminar(pacientes)
        5 -> {
            System.exit(0)
        }
    }

}
