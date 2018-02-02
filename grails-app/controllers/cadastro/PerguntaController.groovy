package cadastro

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PerguntaController {

    PerguntaService perguntaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond perguntaService.list(params), model:[perguntaCount: perguntaService.count()]
    }

    def show(Long id) {
        respond perguntaService.get(id)
    }

    def create() {
        respond new Pergunta(params)
    }

    def save(Pergunta pergunta) {
        if (pergunta == null) {
            notFound()
            return
        }

        try {
            perguntaService.save(pergunta)
        } catch (ValidationException e) {
            respond pergunta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pergunta.label', default: 'Pergunta'), pergunta.id])
                redirect pergunta
            }
            '*' { respond pergunta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond perguntaService.get(id)
    }

    def update(Pergunta pergunta) {
        if (pergunta == null) {
            notFound()
            return
        }

        try {
            perguntaService.save(pergunta)
        } catch (ValidationException e) {
            respond pergunta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'pergunta.label', default: 'Pergunta'), pergunta.id])
                redirect pergunta
            }
            '*'{ respond pergunta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        perguntaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'pergunta.label', default: 'Pergunta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pergunta.label', default: 'Pergunta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
