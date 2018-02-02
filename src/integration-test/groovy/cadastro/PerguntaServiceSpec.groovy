package cadastro

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PerguntaServiceSpec extends Specification {

    PerguntaService perguntaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pergunta(...).save(flush: true, failOnError: true)
        //new Pergunta(...).save(flush: true, failOnError: true)
        //Pergunta pergunta = new Pergunta(...).save(flush: true, failOnError: true)
        //new Pergunta(...).save(flush: true, failOnError: true)
        //new Pergunta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pergunta.id
    }

    void "test get"() {
        setupData()

        expect:
        perguntaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pergunta> perguntaList = perguntaService.list(max: 2, offset: 2)

        then:
        perguntaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        perguntaService.count() == 5
    }

    void "test delete"() {
        Long perguntaId = setupData()

        expect:
        perguntaService.count() == 5

        when:
        perguntaService.delete(perguntaId)
        sessionFactory.currentSession.flush()

        then:
        perguntaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pergunta pergunta = new Pergunta()
        perguntaService.save(pergunta)

        then:
        pergunta.id != null
    }
}
