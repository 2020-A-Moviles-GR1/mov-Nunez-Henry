
fun main(args:Array<String>) {
    val pacientes = ArrayList<Pacientes>()
    mostrarMenu(pacientes)
}
public class Pacientes(
        var Nombre:String,
        var Edad:Int,
        var Apellido:String
        //var Telefono:String,
        //var TipoSangre:String

)

fun ingresar(pacientes: ArrayList<Pacientes>) {
    print("Ingrese nombre del paciente: ")
    val nombre = readLine().toString()
    print("Ingrese napellido del paciente: ")
    val apellido = readLine().toString()
    print("Ingrese la edad del paciente: ")
    val edad = readLine().toString().toInt()

    pacientes.add(Pacientes(nombre, edad,apellido))
    mostrarMenu(pacientes)
}

fun eliminar(pacientes: ArrayList<Pacientes>){
    print("Ingrese el nombre del paciente a borrar:")
    var nombre = readLine().toString()
    var eliminar=pacientes.removeIf { iteracion : Pacientes ->iteracion.Nombre==nombre
    }
    if(eliminar){
        eliminar(pacientes)
    }else{
        print("El paciente no existe en el historial")
    }
    mostrarMenu(pacientes)
}

fun imprimir(pacientes: ArrayList<Pacientes>){
    for(i in pacientes) {
        println(i.Nombre+"\n"+i.Edad)
    }
    mostrarMenu(pacientes)
}

fun modificar(pacientes: ArrayList<Pacientes>){
    print("Ingrese el paciente que desea modificar: ")
    val nombre = readLine().toString()
    var modificar=pacientes.removeIf { iteracion : Pacientes -> iteracion.Nombre==nombre
    }
    if(modificar){
        print("Ingrese el nombre del paciente")
        val nombre= readLine().toString()
        print("Ingrese el apellido del paciente")
        val apellido= readLine().toString()
        print("Ingrese la edad a modificar: ")
        val edad = readLine().toString().toInt()
        pacientes.add(Pacientes(nombre,edad,apellido))
    }else{
        print("El paciente no existe")
    }
    mostrarMenu(pacientes)
}


fun mostrarMenu(pacientes:ArrayList<Pacientes>) {
    var menu:String
    menu="\n"+"           HOSPITAL DEL SUR         "+"\n"+
            "1.Ingresar al paciente"+"\n"+
            "2.Imprimir pacientes"+"\n"+
            "3.Modificar pacientes"+"\n"+
            "4.Eliminar pacientes"+"\n"+
            "5.Salir"+"\n"

    print(menu)
    var cont:Int
    while (true){
            cont = readLine().toString().toInt()
            if (cont>5 || cont<1){
                print("Ingrese las Opciones Mostradas: ")
            }else{
                break
            }
    }

    when(cont){
        1->ingresar(pacientes)
        2->imprimir(pacientes)
        3->modificar(pacientes)
        4->eliminar(pacientes)
        5->{System.exit(0)}
    }








}