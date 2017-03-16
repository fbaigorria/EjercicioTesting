package com.meli.academy.grails.test

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Categoria)
class CategoriaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Probando constraint Categoria"() {
	//ATRIBUTO: nombre
	when: 'El nombre comienza con una letra minuscula'
		def cat = new Categoria(nombre: 'bebidas')
	then: 'la validacion no pasa'
		!cat.validate()
		
	when: 'El nombre comienza con una letra mayuscula pero tiene numeros'
		cat = new Categoria(nombre: 'bebidas12')
	then: 'la validacion no pasa'
		!cat.validate()
		
	when: 'El nombre comienza con una letra mayuscula pero tiene caracteres especiales'
		cat = new Categoria(nombre: 'bebidas_frias')
	then: 'la validacion no pasa'
		!cat.validate()
		
	when: 'El nombre comienza con una letra mayuscula y sigue con letras minusculas'
		cat = new Categoria(nombre: "Bebidas")
	then:
		cat.validate()
    }
}
