package cadastro

class Pergunta {
    String nome
    String time

    static constraints = {
        nome (nullable : false,blank: false)
        time inList :["Atletico","Cruzeiro","América"]
    }
}
