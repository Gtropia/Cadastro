package cadastro

import grails.gorm.services.Service

@Service(Pergunta)
interface PerguntaService {

    Pergunta get(Serializable id)

    List<Pergunta> list(Map args)

    Long count()

    void delete(Serializable id)

    Pergunta save(Pergunta pergunta)

}